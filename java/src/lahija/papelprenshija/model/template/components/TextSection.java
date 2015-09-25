package lahija.papelprenshija.model.template.components;

import lahija.papelprenshija.model.template.components.abstractions.TwoDimensionsValues;

/**
 * Represents a text being written on a template. Encapsulates font properties, coordinates, leading and so.
 * @author rsilva
 *
 */
public class TextSection {
   private final TextSectionFont textFont;
   private final TwoDimensionsValues textCoordinates;
   private final Integer textLeading;
   private final Integer textWidth;

   /**
    * @param textFont
    * @param textCoordinates (0,0) starting coordinates
    * @param textLeading text leading property
    * @param textWidth block text with
    */
   public TextSection(final TextSectionFont textFont, final TwoDimensionsValues textCoordinates, final Integer textLeading,
            final Integer textWidth) {
      this.textFont = textFont;
      this.textCoordinates = textCoordinates;
      this.textLeading = textLeading;
      this.textWidth = textWidth;
   }

   /**
    * @return the textFont
    */
   public TextSectionFont getTextFont() {
      return this.textFont;
   }

   /**
    * @return the textCoordinates
    */
   public TwoDimensionsValues getTextCoordinates() {
      return this.textCoordinates;
   }

   /**
    * @return the textLeading
    */
   public Integer getTextLeading() {
      return this.textLeading;
   }

   /**
    * @return the textWidth
    */
   public Integer getTextWidth() {
      return this.textWidth;
   }
}