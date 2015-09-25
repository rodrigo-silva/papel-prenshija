package lahija.papelprenshija.factory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.bind.ValidationException;

import lahija.papelprenshija.dao.InMemoryDAO;
import lahija.papelprenshija.model.FrontPage;
import lahija.papelprenshija.model.exception.RequestParametersValidationException;
import lahija.papelprenshija.model.exception.SystemException;
import lahija.papelprenshija.model.params.FrontPageInstanceParams;
import lahija.papelprenshija.model.template.INewspaperTemplate;
import lahija.papelprenshija.service.params.FrontPageRequestParams;

/**
 * Creates Front pages from UI parameters. It knows about data access, {@link INewspaperTemplate} creation, picture access and so.
 *
 * @author rsilva
 *
 */
public class FrontPageFactory {

   public static FrontPage createFrontPage(final FrontPageRequestParams requestParams) {
      final FrontPageInstanceParams frontPageInstanceParams = getInstanceParams(requestParams);
      final INewspaperTemplate newspaperTemplate = InMemoryDAO.getNewspaperTemplateByName(requestParams.getTemplateName());

      return new FrontPage(newspaperTemplate, frontPageInstanceParams);
   }

   /**
    * Builds instance parameters.
    *
    * @param requestParams
    * @return
    * @throws IOException
    */
   private static FrontPageInstanceParams getInstanceParams(final FrontPageRequestParams requestParams) {
      final BufferedImage featureImage = readFeatureImage(requestParams.getFeatureImagePath());
      final FrontPageInstanceParams frontPageInstanceParams =
               new FrontPageInstanceParams(requestParams.getTitle(), requestParams.getSubtitle(), featureImage,
                        requestParams.getCaption());

      return frontPageInstanceParams;
   }

   /**
    * Reads the feature image. If path does not exists throws {@link ValidationException}
    *
    * @param featureImagePath
    * @return
    * @throws IOException
    */
   private static BufferedImage readFeatureImage(final String featureImagePath) {
      if(featureImagePath == null || "".equals(featureImagePath)) {
         throw new RequestParametersValidationException("Pone una ruta a una imagen.");
      }
      validateFileExists(featureImagePath);
      try {
         return ImageIO.read(new File(featureImagePath));
      } catch (final IOException e) {
         throw new SystemException("Error de lectura en este archivo: " + featureImagePath, e);
      }
   }

   /**
    * Checks if the given path exists and is a file (rather than directory).
    *
    * @param featureImagePath
    */
   private static void validateFileExists(final String featureImagePath) {
      final File f = new File(featureImagePath);
      if(!f.exists()) {
         throw new RequestParametersValidationException("Este archivito: " + f.getAbsolutePath() + " no existe...");
      }

      if (f.isDirectory()) {
         throw new RequestParametersValidationException("Esta direccion: " + f.getAbsolutePath() + " es un directorio. Necesito un archivo.");
      }
   }
}
