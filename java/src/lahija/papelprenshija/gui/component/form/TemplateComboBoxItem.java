package lahija.papelprenshija.gui.component.form;

public class TemplateComboBoxItem {
   private final String displayName;
   private final String pathToBackgroudTemplate;

   /**
    * @param displayName
    * @param pathToBackgroudTemplate
    */
   public TemplateComboBoxItem(final String displayName, final String pathToBackgroudTemplate) {
      this.displayName = displayName;
      this.pathToBackgroudTemplate = pathToBackgroudTemplate;
   }

   /**
    * @return the displayName
    */
   public String getDisplayName() {
      return this.displayName;
   }

   /**
    * @return the pathToBackgroudTemplate
    */
   public String getPathToBackgroudTemplate() {
      return this.pathToBackgroudTemplate;
   }

   @Override
   public String toString() {
       return this.displayName;
   }
}
