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
public class ElCapitalBNewsPaperTemplateData extends AbstractNewsPaperTemplateData {

   public ElCapitalBNewsPaperTemplateData() {
      super();
   }

   @Override
   protected BackgroundTemplate getInternalBackgroundTemplate() {
      final TwoDimensionsValues pictureCoordinates = new TwoDimensionsValues(9, 500);
      final TwoDimensionsValues pictureScale = new TwoDimensionsValues(570, 426);
      final BackgroundTemplate backgroundTemplate =
               new BackgroundTemplate(TEMPLATE_BASE_DIR + "ElCapitalB.jpg", pictureScale, pictureCoordinates);

      return backgroundTemplate;
   }

   @Override
   protected TextSection getInternalTitleSection() {
      final TextSectionFont textFont = new TextSectionFont(55, 55, "Times New Roman", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(10, 190);
      final Integer textLeading = -10;
      final Integer textWidth = 570;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalSubtitleSection() {
      final TextSectionFont textFont = new TextSectionFont(18, 18, "Times New Roman", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(12, 426);
      final Integer textLeading = 0;
      final Integer textWidth = 390;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalImageCaption() {
      final TextSectionFont textFont = new TextSectionFont(24, 24, "Arial", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(10, 930);
      final Integer textLeading = 0;
      final Integer textWidth = 560;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }
}
