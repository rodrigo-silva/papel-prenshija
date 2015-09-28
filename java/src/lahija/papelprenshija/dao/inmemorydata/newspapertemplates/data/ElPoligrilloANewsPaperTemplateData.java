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
public class ElPoligrilloANewsPaperTemplateData extends AbstractNewsPaperTemplateData {

   public ElPoligrilloANewsPaperTemplateData() {
      super();
   }

   @Override
   protected BackgroundTemplate getInternalBackgroundTemplate() {
      final TwoDimensionsValues pictureScale = new TwoDimensionsValues(576, 332);
      final TwoDimensionsValues pictureCoordinates = new TwoDimensionsValues(9, 468);
      final BackgroundTemplate backgroundTemplate =
               new BackgroundTemplate(TEMPLATE_BASE_DIR + "ElPoligrilloA.jpg", pictureScale, pictureCoordinates);

      return backgroundTemplate;
   }

   @Override
   protected TextSection getInternalTitleSection() {
      final TextSectionFont textFont = new TextSectionFont(55, 55, "Times New Roman", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(8, 245);
      final Integer textLeading = -10;
      final Integer textWidth = 578;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalSubtitleSection() {
      final TextSectionFont textFont = new TextSectionFont(18, 18, "Times New Roman", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(5, 363);
      final Integer textLeading = 0;
      final Integer textWidth = 580;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalImageCaption() {
      return null;
   }
}
