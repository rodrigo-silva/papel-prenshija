package lahija.papelprenshija.diario;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LosAndes extends Diario {
  private final Image photo;
  /** 58 */
  private final String title;
  private final String subtitle;
  private final String caption;

  public LosAndes(final Image photo, final String title, final String subtitle, final String caption) {
    this.photo = photo;
    this.title = title;
    this.subtitle = subtitle;
    this.caption = caption.toUpperCase();
  }

  @Override
public BufferedImage crearTapa() throws IOException {
    final BufferedImage losAndes = ImageIO.read(new File("templates/losandes.jpg"));
    final Graphics2D graf = losAndes.createGraphics();

    final Image scaledPhoto = this.photo.getScaledInstance(580 - 19, 900 - 523, Image.SCALE_SMOOTH);
    graf.drawImage(scaledPhoto, 19, 523, null);

    this.writeText(graf, this.title, new Font("Times New Roman", Font.BOLD, 60), 15, 265, 585, -8);
    this.writeText(graf, this.subtitle, new Font("Arial", Font.BOLD, 16), 15, 370, 585, 0);
    this.writeText(graf, this.caption, new Font("Arial", Font.BOLD, 24), 30, 495, 545, 0);

    return losAndes;
  }
}
