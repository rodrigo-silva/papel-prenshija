package lahija.papelprenshija.diario;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LaPosta extends Diario {
  private final Image photo;
  /** 58 */
  private final String title;
  private final String subtitle;
  private final String caption;

  public LaPosta(final Image photo, final String title, final String subtitle,
      final String caption) {
    this.photo = photo;
    this.title = title;
    this.subtitle = subtitle;
    this.caption = caption;
  }

  @Override
  public BufferedImage crearTapa() throws IOException {

    final BufferedImage tapa = ImageIO.read(new File("templates/laposta.jpg"));
    final Graphics2D graf = tapa.createGraphics();

    final Image scaledPhoto = this.photo.getScaledInstance(520, 500, Image.SCALE_SMOOTH);
    graf.drawImage(scaledPhoto, 170, 550, null);

    this.writeText(graf, this.title, new Font("Helvetica-ExtraCompressed", Font.ITALIC,
        85), 170, 420, 560, 0);
    this.writeText(graf, this.subtitle, new Font("Helvética-Narrow", Font.PLAIN, 20),
        170, 340, 560, 0);
    this.writeText(graf, this.caption, new Font("HelveticaNeue-Medium", Font.BOLD, 24),
        180, 1050, 545, 0);

    return tapa;
  }
}
