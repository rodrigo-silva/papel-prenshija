package lahija.papelprenshija.gui.event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import lahija.papelprenshija.gui.component.form.FormPanel;

/**
 * Listener for file choose or browse file button.
 *
 * @author rsilva
 *
 */
public class FileChooserListener implements ActionListener {

   private final FormPanel panelContainer;
   private final JFileChooser fileChooser;

   /**
    * Contructor
    * @param panelContainer a form panel containing browse button. Needed to know where to pop up browse dialog and which notify file has
    * been chosen
    */
   public FileChooserListener(final FormPanel panelContainer) {
      this.panelContainer = panelContainer;
      final FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
      this.fileChooser = new JFileChooser();
      this.fileChooser.addChoosableFileFilter(imageFilter);
      this.fileChooser.setFileFilter(imageFilter);
      this.fileChooser.setAcceptAllFileFilterUsed(false);
   }

   @Override
   public void actionPerformed(final ActionEvent e) {
      final int returnVal = this.fileChooser.showOpenDialog(this.panelContainer);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
         final File file = this.fileChooser.getSelectedFile();
         this.panelContainer.onPictureFileChosen(file.getAbsolutePath());
      }
   }
}
