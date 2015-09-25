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
public class ClarinNewsPaperTemplateData extends AbstractNewsPaperTemplateData {

   public ClarinNewsPaperTemplateData() {
     super();
   }

   @Override
   protected BackgroundTemplate getInternalBackgroundTemplate() {
      final TwoDimensionsValues pictureScale = new TwoDimensionsValues(566, 326);
      final TwoDimensionsValues pictureCoordinates = new TwoDimensionsValues(20, 598);
      final BackgroundTemplate backgroundTemplate =
               new BackgroundTemplate(TEMPLATE_BASE_DIR + "clarin.jpg", pictureScale, pictureCoordinates);

      return backgroundTemplate;
   }

   @Override
   protected TextSection getInternalTitleSection() {
      final TextSectionFont textFont = new TextSectionFont(85, 110, "Arial Narrow Bold", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(10, 264);
      final Integer textLeading = -15;
      final Integer textWidth = 570;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalSubtitleSection() {
      final TextSectionFont textFont = new TextSectionFont(20, 20, "Arial Narrow Bold", Font.BOLD);
      final TwoDimensionsValues textCoordinates = new TwoDimensionsValues(16, 484);
      final Integer textLeading = 0;
      final Integer textWidth = 570;

      return new TextSection(textFont, textCoordinates, textLeading, textWidth);
   }

   @Override
   protected TextSection getInternalImageCaption() {
      return null;
   }
}
