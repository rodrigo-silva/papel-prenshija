package lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data;

import java.awt.Font;

import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;
import lahija.papelprenshija.model.template.components.TextSectionFont;
import lahija.papelprenshija.model.template.components.abstractions.TwoDimensionsValues;

/**
 * Data for "ClarinA" newspaper template.
 *
 * @author rsilva
 *
 */
public class ClarinANewsPaperTemplateData extends AbstractNewsPaperTemplateData {

   public ClarinANewsPaperTemplateData() {
     super();
   }

   @Override
   protected BackgroundTemplate getInternalBackgroundTemplate() {
      final TwoDimensionsValues pictureScale = new TwoDimensionsValues(730, 300);
      final TwoDimensionsValues pictureCoordinates = new TwoDimensionsValues(10, 260);
      final BackgroundTemplate backgroundTemplate =
               new BackgroundTemplate(TEMPLATE_BASE_DIR + "clarinA.jpg", pictureScale, pictureCoordinates);

      return backgroundTemplate;
   }

   @Override
   protected TextSection getInternalTitleSection() {
      final TextSectionFont textFont = new TextSectionFont(85, 110, "Arial Narrow Bold", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(10, 580);
      final Integer textLeading = -15;
      final Integer textWidth = 580;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalSubtitleSection() {
      final TextSectionFont textFont = new TextSectionFont(20, 20, "Arial Narrow Bold", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(10, 790);
      final Integer textLeading = 0;
      final Integer textWidth = 580;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalImageCaption() {
      return null;
   }
}
