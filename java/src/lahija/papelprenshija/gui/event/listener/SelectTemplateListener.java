package lahija.papelprenshija.gui.event.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import lahija.papelprenshija.gui.component.form.TemplateComboBoxItem;
import lahija.papelprenshija.gui.event.IFormEventsMediator;

public class SelectTemplateListener implements ItemListener{
   private final IFormEventsMediator mediator;

   /**
    *
    * @param mediator to tell what template user picked
    */
   public SelectTemplateListener(final IFormEventsMediator mediator) {
      this.mediator = mediator;

   }
   @Override
   public void itemStateChanged(final ItemEvent e) {
      if(e.getStateChange() == ItemEvent.SELECTED){
         final TemplateComboBoxItem item = (TemplateComboBoxItem) e.getItem();
         this.mediator.onFrontPageTemplateSelect(item);
      }
   }

}
