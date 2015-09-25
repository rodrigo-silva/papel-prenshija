package lahija.papelprenshija.diario;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Clarin extends Diario {
   private final Image photo;
   /** 58 */
   private final String title;
   private final String subtitle;
   private final String caption;

   public Clarin(final Image photo, final String title, final String subtitle, final String caption) {
      this.photo = photo;
      this.title = title;
      this.subtitle = subtitle;
      this.caption = caption;
   }

   @Override
   public BufferedImage crearTapa() throws IOException {

      final BufferedImage tapa = ImageIO.read(new File("templates/clarin.jpg"));
      final Graphics2D graf = tapa.createGraphics();

      final Image scaledPhoto = this.photo.getScaledInstance(566, 326, Image.SCALE_SMOOTH);
      graf.drawImage(scaledPhoto, 20, 598, null);
      final Font titleFont = this.getTitleFont(570, graf.getFontRenderContext());
      this.writeText(graf, this.title, titleFont, 10, 264, 570, -15);
      this.writeText(graf, this.subtitle, new Font("Arial Narrow Bold", Font.BOLD, 20), 16, 484, 570, 0);
      //    writeText(graf, caption, new Font("Arial Narrow Bold", Font.PLAIN, 25), 15,
      //        610, 80, 0);

      return tapa;
   }

   private Font getTitleFont(final double width, final FontRenderContext fontRenderContext) {
      final Font defaultFont = new Font("Arial Narrow Bold", Font.BOLD, 85);
      final double lines = defaultFont.getStringBounds(this.title, fontRenderContext).getWidth() / width;
      if (lines > 2) {
         return defaultFont;
      } else {
         return new Font("Arial Narrow Bold", Font.BOLD, 110);
      }
   }
}
