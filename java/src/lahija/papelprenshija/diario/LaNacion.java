package lahija.papelprenshija.diario;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LaNacion extends Diario {
  private final Image photo;
  /** 58 */
  private final String title;
  private final String subtitle;
  private final String caption;

  public LaNacion(final Image photo, final String title, final String subtitle,
      final String caption) {
    this.photo = photo;
    this.title = title;
    this.subtitle = subtitle;
    this.caption = caption.toUpperCase();
  }

  @Override
  public BufferedImage crearTapa() throws IOException {

    final BufferedImage tapa = ImageIO.read(new File("templates/lanacion.jpg"));
    final Graphics2D graf = tapa.createGraphics();

    final Image scaledPhoto = this.photo.getScaledInstance(486, 312, Image.SCALE_SMOOTH);
    graf.drawImage(scaledPhoto, 2, 692, null);

    this.writeText(graf, this.title, new Font("Times New Roman", Font.BOLD, 55), 15, 270,
        490, -10);
    this.writeText(graf, this.subtitle, new Font("Times New Roman", Font.BOLD, 18), 15,
        400, 485, 0);
    this.writeText(graf, this.caption, new Font("Arial", Font.BOLD, 24), 30,
        650, 545, 0);

    return tapa;
  }
}
