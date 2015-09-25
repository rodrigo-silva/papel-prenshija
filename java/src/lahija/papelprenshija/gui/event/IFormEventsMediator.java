package lahija.papelprenshija.gui.event;

import lahija.papelprenshija.gui.component.form.TemplateComboBoxItem;

/**
 * Component within form may want to talk each other when event occurs. Instead of knowing each other they talk to this mediator. Mediator
 * knows all its contained components. For example, a button click may change text input value. Instead of button listener knowing about
 * text input, it talk to mediator and mediator talks to text input.
 *
 * @author rsilva
 *
 */
public interface IFormEventsMediator {

   /**
    * When a picture file is chosen, tell mediator the filepath
    *
    * @param filepath path to picture file
    */
   void onPictureFileChosen(final String filepath);

   /**
    * When the Create front page button has been cliked.
    */
   void onCreateFrontPageButtonClick();

   /**
    * When user picks template from combobox.
    *
    * @param item selected item
    */
   void onFrontPageTemplateSelect(final TemplateComboBoxItem item);

}
