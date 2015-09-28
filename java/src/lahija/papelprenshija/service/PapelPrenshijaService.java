package lahija.papelprenshija.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import lahija.papelprenshija.dao.InMemoryDAO;
import lahija.papelprenshija.factory.FrontPageFactory;
import lahija.papelprenshija.factory.FrontPageImageRepresentationFactory;
import lahija.papelprenshija.model.FrontPage;
import lahija.papelprenshija.model.exception.RequestParametersValidationException;
import lahija.papelprenshija.model.exception.SystemException;
import lahija.papelprenshija.model.template.INewspaperTemplate;
import lahija.papelprenshija.service.params.FrontPageRequestParams;

/**
 * State less service to interact with data, backend, factories and so. It is responsible to accomplish use cases.<br/>
 * <strong>The class is static and it is on purpose. Since it is and will be the only service it doesn't make sense dealing with instances
 * and dependency injention. If app grows enough, this design must be changed</strong>
 *
 * @author rsilva
 *
 */
public class PapelPrenshijaService {

   public static final String OUTPUT_PATH;

   static {
      if (new File(System.getenv("userprofile") + "\\Escritorio").exists()) {
         OUTPUT_PATH = System.getenv("userprofile") + "\\Escritorio\\";
      } else if (new File(System.getenv("userprofile") + "\\Desktop").exists()) {
         OUTPUT_PATH = System.getenv("userprofile") + "\\Desktop\\";
      } else {
         OUTPUT_PATH = "output/";
      }
   }

   /**
    * Gets list of front page names.
    *
    * @return
    */
   public static List<String> getFrontPageNames() {
      return InMemoryDAO.getFrontPageNames();
   }

   /**
    * Returns front page names list with path to background template
    *
    * @return
    */
   public static Map<String, String> getFrontPageNamesAndBackgroundTemplatePreviewPath() {
      final Map<String, String> frontPageNamesAndBackgroundTemplatePath =
               InMemoryDAO.getFrontPageNamesAndBackgroundTemplatePath();
      final HashMap<String, String> namesAndPreviews = new LinkedHashMap<String, String>();
      for (final Entry<String, String> entry : frontPageNamesAndBackgroundTemplatePath.entrySet()) {
         final String path = entry.getValue();
         //TODO: COC, is it right?? Could be saved in db?
         final String pathToPreview = path.substring(0, path.lastIndexOf(".jpg")) + "_preview.jpg";
         namesAndPreviews.put(entry.getKey(), pathToPreview);
      }

      return namesAndPreviews;
   }

   /**
    *
    * @param requestParams
    */
   public static void printFrontPage(final FrontPageRequestParams requestParams) {
      validateParams(requestParams);
      final FrontPage frontPage = FrontPageFactory.createFrontPage(requestParams);
      final FrontPageImageRepresentationFactory factory = new FrontPageImageRepresentationFactory(frontPage);
      final BufferedImage image = factory.createFrontPageImageRepresentation();
      try {
         writeToDisk(image, requestParams.getTemplateName());
      } catch (final IOException e) {
         throw new SystemException("PUff! Error de escritura en el disco. Que onda?", e);
      }
   }

   /**
    * Simple validates for incoming paramenters
    *
    * @param requestParams
    */
   private static void validateParams(final FrontPageRequestParams requestParams) {
      if (requestParams.getTitle() == null || "".equals(requestParams.getTitle())) {
         throw new RequestParametersValidationException("Titulo no puede estar vacio");
      }
      if (requestParams.getSubtitle() == null || "".equals(requestParams.getSubtitle())) {
         throw new RequestParametersValidationException("Subtitulo no puede estar vacio");
      }
      if (requestParams.getFeatureImagePath() == null || "".equals(requestParams.getFeatureImagePath())) {
         throw new RequestParametersValidationException("Debes seleccionar una imagen");
      }
      if (requestParams.getTemplateName() == null || "".equals(requestParams.getTemplateName())) {
         throw new RequestParametersValidationException("Tenes que selecionar un template");
      }
      validateImageCaption(requestParams);
   }

   /**
    * Validates only image caption parameter. The thing is some templates might not require this field, so validation is not that simple.
    *
    * @param requestParams
    */
   private static void validateImageCaption(final FrontPageRequestParams requestParams) {
      final INewspaperTemplate newspaperTemplate = InMemoryDAO.getNewspaperTemplateByName(requestParams.getTemplateName());
      if (newspaperTemplate.hasImageCaption()) {
         if (requestParams.getCaption() == null || "".equals(requestParams.getCaption())) {
            throw new RequestParametersValidationException("Para el diario " + requestParams.getTemplateName()
                     + " el texto de imagen no puede ser vacio.");
         }
      }
   }

   /**
    * Writes to disk the result image.
    *
    * @param image
    * @param templateName
    * @throws IOException
    */
   private static void writeToDisk(final BufferedImage image, final String templateName) throws IOException {
      final File outputFolder = new File(OUTPUT_PATH);
      if (!outputFolder.exists()) {
         outputFolder.mkdir();
      }
      final String fileName = templateName + ".jpg";
      ImageIO.write(image, "jpg", new File(OUTPUT_PATH + fileName));
   }
}
