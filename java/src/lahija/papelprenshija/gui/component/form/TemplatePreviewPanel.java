package lahija.papelprenshija.gui.component.form;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import lahija.papelprenshija.model.exception.SystemException;
/**
 * Preview panel for templates
 * @author rsilva
 *
 */
public class TemplatePreviewPanel extends JPanel {
   private static final long serialVersionUID = 4547360583087769138L;
   private final Integer width = 150;
   private final Integer height = 200;
   private Image image;

   public TemplatePreviewPanel(final String pathToPreview) {
      this.setImage(pathToPreview);
   }

   public void rePaintImage(final String pathToPreview) {
      this.setImage(pathToPreview);
      this.repaint();
   }

   @Override
   public void paintComponent(final Graphics graphics) {
      super.paintComponents(graphics);
      graphics.drawImage(this.image, 0, 0, null);
   }

   /**
    * @return the width
    */
   public Integer getPreviewWidth() {
      return this.width;
   }

   /**
    * @return the height
    */
   public Integer getPreviewHeight() {
      return this.height;
   }

   /**
    * @param pathToPreview
    */
   private void setImage(final String pathToPreview) {
      try {
         this.image = ImageIO.read(new File(pathToPreview)).getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
      } catch (final IOException e) {
       //TODO: How handles this thrown exception?????
         throw new SystemException("Cannot read template image for: " + pathToPreview + " You will have to reinstall the app.", e);
      }
   }
}
