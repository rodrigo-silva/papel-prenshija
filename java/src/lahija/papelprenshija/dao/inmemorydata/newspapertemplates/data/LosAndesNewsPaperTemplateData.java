package lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data;

import java.awt.Font;

import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;
import lahija.papelprenshija.model.template.components.TextSectionFont;
import lahija.papelprenshija.model.template.components.abstractions.TwoDimensionsValues;

/**
 * Data for newspaper template.
 *
 * @author rsilva
 *
 */
public class LosAndesNewsPaperTemplateData extends AbstractNewsPaperTemplateData {

   public LosAndesNewsPaperTemplateData() {
      super();
   }

   @Override
   protected BackgroundTemplate getInternalBackgroundTemplate() {
      final TwoDimensionsValues pictureScale = new TwoDimensionsValues(561, 377);
      final TwoDimensionsValues pictureCoordinates = new TwoDimensionsValues(19, 523);
      final BackgroundTemplate backgroundTemplate =
               new BackgroundTemplate(TEMPLATE_BASE_DIR + "losandes.jpg", pictureScale, pictureCoordinates);
      return backgroundTemplate;
   }

   @Override
   protected TextSection getInternalTitleSection() {
      final TextSectionFont textFont = new TextSectionFont(60, 60, "Times New Roman", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(15, 265);
      final Integer textLeading = -8;
      final Integer textWidth = 585;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalSubtitleSection() {
      final TextSectionFont textFont = new TextSectionFont(20, 20, "Arial", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(15, 370);
      final Integer textLeading = 0;
      final Integer textWidth = 585;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalImageCaption() {
      final TextSectionFont textFont = new TextSectionFont(24, 24, "Arial", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(30, 495);
      final Integer textLeading = 0;
      final Integer textWidth = 545;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }
}
