package lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data;

import java.awt.Font;

import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;
import lahija.papelprenshija.model.template.components.TextSectionFont;
import lahija.papelprenshija.model.template.components.abstractions.TwoDimensionsValues;

/**
 * Data for "La Posta" newspaper template.
 *
 * @author rsilva
 *
 */
public class LaPostaNewsPaperTemplateData extends AbstractNewsPaperTemplateData {

   public LaPostaNewsPaperTemplateData() {
     super();
   }

   @Override
   protected BackgroundTemplate getInternalBackgroundTemplate() {
      final TwoDimensionsValues pictureScale = new TwoDimensionsValues(520, 500);
      final TwoDimensionsValues pictureCoordinates = new TwoDimensionsValues(170, 550);
      final BackgroundTemplate backgroundTemplate2 =
               new BackgroundTemplate(TEMPLATE_BASE_DIR + "laposta.jpg", pictureScale, pictureCoordinates);
      return backgroundTemplate2;
   }

   @Override
   protected TextSection getInternalTitleSection() {
      final TextSectionFont textFont = new TextSectionFont(85, 85, "Helvetica-ExtraCompressed", Font.ITALIC);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(170, 420);
      final Integer textLeading = 0;
      final Integer textWidth = 560;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalSubtitleSection() {
      final TextSectionFont textFont = new TextSectionFont(20, 20, "Helvetica-Narrow", Font.PLAIN);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(170, 340);
      final Integer textLeading = 0;
      final Integer textWidth = 560;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalImageCaption() {
      final TextSectionFont textFont = new TextSectionFont(24, 24, "HelveticaNeue-Medium", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(180, 1050);
      final Integer textLeading = 0;
      final Integer textWidth = 545;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }
}
