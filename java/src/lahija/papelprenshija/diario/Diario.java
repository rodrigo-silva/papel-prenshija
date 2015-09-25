package lahija.papelprenshija.diario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

public abstract class Diario {

   public abstract BufferedImage crearTapa() throws IOException;

   void writeText(final Graphics2D g, final String input, final Font font, final int x, int y, final int width, final int leading) {

      g.addRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
      g.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));

      final AttributedString as = new AttributedString(input);
      as.addAttribute(TextAttribute.FONT, font);
      as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);

      final AttributedCharacterIterator characterIterator = as.getIterator();
      final FontRenderContext fontRenderContext = g.getFontRenderContext();
      final LineBreakMeasurer measurer = new LineBreakMeasurer(characterIterator, fontRenderContext);

      while (measurer.getPosition() < characterIterator.getEndIndex()) {
         final TextLayout textLayout = measurer.nextLayout(width);
         y += textLayout.getAscent() + leading;
         textLayout.draw(g, x, y);
         y += textLayout.getDescent() + leading;
      }
   }

}
