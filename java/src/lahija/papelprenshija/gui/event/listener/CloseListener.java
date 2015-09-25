package lahija.papelprenshija.gui.event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for closing the app.
 *
 * @author rsilva
 *
 */
public class CloseListener implements ActionListener {

   @Override
   public void actionPerformed(final ActionEvent e) {
      System.exit(0);
   }

}
