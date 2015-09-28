package lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data;

import java.awt.Font;

import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;
import lahija.papelprenshija.model.template.components.TextSectionFont;
import lahija.papelprenshija.model.template.components.abstractions.TwoDimensionsValues;

/**
 * Data for specific newspaper template.
 *
 * @author rsilva
 *
 */
public class LaNacionANewsPaperTemplateData extends AbstractNewsPaperTemplateData {

   public LaNacionANewsPaperTemplateData() {
      super();
   }

   @Override
   protected BackgroundTemplate getInternalBackgroundTemplate() {
      final TwoDimensionsValues pictureScale = new TwoDimensionsValues(486, 312);
      final TwoDimensionsValues pictureCoordinates = new TwoDimensionsValues(2, 692);
      final BackgroundTemplate backgroundTemplate =
               new BackgroundTemplate(TEMPLATE_BASE_DIR + "lanacionA.jpg", pictureScale, pictureCoordinates);

      return backgroundTemplate;
   }

   @Override
   protected TextSection getInternalTitleSection() {
      final TextSectionFont textFont = new TextSectionFont(55, 55, "Times New Roman", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(15, 270);
      final Integer textLeading = -10;
      final Integer textWidth = 490;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalSubtitleSection() {
      final TextSectionFont textFont = new TextSectionFont(18, 18, "Times New Roman", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(15, 400);
      final Integer textLeading = 0;
      final Integer textWidth = 485;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalImageCaption() {
      final TextSectionFont textFont = new TextSectionFont(24, 24, "Arial", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(30, 650);
      final Integer textLeading = 0;
      final Integer textWidth = 545;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }
}
