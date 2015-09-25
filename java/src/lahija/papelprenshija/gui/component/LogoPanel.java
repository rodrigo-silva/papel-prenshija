package lahija.papelprenshija.gui.component;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import lahija.papelprenshija.model.exception.SystemException;

/**
 * Logo panel with hardcoded image
 * @author rsilva
 *
 */
public class LogoPanel extends JPanel {
   private static final long serialVersionUID = -180996120970650749L;
   private final Integer width = 420;
   private final Integer height = 120;
   private final String pathToPreview = "support/logo-app.jpg";

   @Override
   public void paintComponent(final Graphics graphics) {
      super.paintComponents(graphics);
      try {
         graphics.drawImage(
                  ImageIO.read(new File(this.pathToPreview)).getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH), 0,
                  0, null);
      } catch (final IOException e) {
         //TODO: How handles this thrown exception?????
         throw new SystemException("Cannot read template image for: " + this.pathToPreview
                  + " You will have to reinstall the app.", e);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(this.width, this.height);
   }
}
