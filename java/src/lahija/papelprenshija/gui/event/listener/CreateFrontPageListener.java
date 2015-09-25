package lahija.papelprenshija.gui.event.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lahija.papelprenshija.gui.event.IFormEventsMediator;

/**
 * Listener for create front page button
 *
 * @author rsilva
 *
 */
public class CreateFrontPageListener implements ActionListener{

   private final IFormEventsMediator mediator;

   public CreateFrontPageListener(final IFormEventsMediator mediator) {
      this.mediator = mediator;
   }

   @Override
   public void actionPerformed(final ActionEvent arg0) {
      this.mediator.onCreateFrontPageButtonClick();
   }
}
