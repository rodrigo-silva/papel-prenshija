package lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data;

import java.awt.Font;

import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;
import lahija.papelprenshija.model.template.components.TextSectionFont;
import lahija.papelprenshija.model.template.components.abstractions.TwoDimensionsValues;

/**
 * Data for "ClarinC" newspaper template.
 *
 * @author rsilva
 *
 */
public class ClarinCNewsPaperTemplateData extends AbstractNewsPaperTemplateData {

   public ClarinCNewsPaperTemplateData() {
      super();
   }

   @Override
   protected BackgroundTemplate getInternalBackgroundTemplate() {
      final TwoDimensionsValues pictureScale = new TwoDimensionsValues(580, 340);
      final TwoDimensionsValues pictureCoordinates = new TwoDimensionsValues(10, 540);
      final BackgroundTemplate backgroundTemplate =
               new BackgroundTemplate(TEMPLATE_BASE_DIR + "clarinC.jpg", pictureScale, pictureCoordinates);

      return backgroundTemplate;
   }

   @Override
   protected TextSection getInternalTitleSection() {
      final TextSectionFont textFont = new TextSectionFont(85, 110, "Arial Narrow Bold", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(10, 260);
      final Integer textLeading = -15;
      final Integer textWidth = 580;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalSubtitleSection() {
      final TextSectionFont textFont = new TextSectionFont(20, 20, "Arial Narrow Bold", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(10, 480);
      final Integer textLeading = 0;
      final Integer textWidth = 550;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalImageCaption() {
      final TextSectionFont textFont = new TextSectionFont(20, 20, "Arial Narrow Bold", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(10, 880);
      final Integer textLeading = 0;
      final Integer textWidth = 580;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }
}
