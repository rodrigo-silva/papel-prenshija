package lahija.papelprenshija.diario.factory.template.components;

import java.awt.Font;

/**
 * For a text section this represents the used font.
 *
 * @author rsilva
 *
 */
public class TextSectionFont {
   private final Integer smallSize;
   private final Integer bigSize;
   private final String fontName;
   private final Integer fontStyle;

   /**
    *
    * @param smallSize font size to use in large text (like 3 lines text)
    * @param bigSize font size to use in smaller texts
    * @param fontName name of the font
    * @param fontStyle values from {@link Font} like {@link Font#ITALIC}
    */
   public TextSectionFont(final Integer smallSize, final Integer bigSize, final String fontName, final Integer fontStyle) {
      this.smallSize = smallSize;
      this.bigSize = bigSize;
      this.fontName = fontName;
      this.fontStyle = fontStyle;
   }

   /**
    * @return the smallSize
    */
   public Integer getSmallSize() {
      return this.smallSize;
   }

   /**
    * @return the bigSize
    */
   public Integer getBigSize() {
      return this.bigSize;
   }

   /**
    * @return the fontName
    */
   public String getFontName() {
      return this.fontName;
   }

   /**
    * @return the fontStyle
    */
   public Integer getFontStyle() {
      return this.fontStyle;
   }
}