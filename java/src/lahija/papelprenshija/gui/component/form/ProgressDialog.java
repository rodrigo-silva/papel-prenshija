package lahija.papelprenshija.gui.component.form;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

/**
 * Progress dialog when creating the front page image representation.
 *
 * @author rsilva
 *
 */
public class ProgressDialog extends JDialog {
   private static final long serialVersionUID = -7524128548071972188L;

   public ProgressDialog(final JFrame parentFrame, final String message) {
      super(parentFrame, true);

      final JProgressBar bar = new JProgressBar();
      bar.setIndeterminate(true);
      bar.setStringPainted(true);
      bar.setString(message);
      this.add(bar);
      this.setUndecorated(true);
      this.setLocationRelativeTo(parentFrame);
      this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
      this.setModal(true);
      this.pack();
   }
}
