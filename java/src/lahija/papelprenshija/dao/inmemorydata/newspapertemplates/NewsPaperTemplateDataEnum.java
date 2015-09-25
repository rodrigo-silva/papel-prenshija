package lahija.papelprenshija.dao.inmemorydata.newspapertemplates;

import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.ClarinNewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.INewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.LaNacionNewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.LaPostaNewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.LosAndesNewsPaperTemplateData;

/**
 * Enum for NewsPaperTemplateData, it binds data to a key, which is news paper name, and holds all possible data and no more.
 * @author rsilva
 *
 */
public enum NewsPaperTemplateDataEnum {
   LA_POSTA("La Posta", new LaPostaNewsPaperTemplateData()),
   CLARIN("Clarin", new ClarinNewsPaperTemplateData()),
   LOS_ANDES("Los Andes", new LosAndesNewsPaperTemplateData()),
   LA_NACION("La Nacion", new LaNacionNewsPaperTemplateData());

   private final String name;
   private final INewsPaperTemplateData data;

   private NewsPaperTemplateDataEnum(final String name, final INewsPaperTemplateData data) {
      this.name = name;
      this.data = data;
   }

   public String getName() {
      return this.name;
   }

   public INewsPaperTemplateData getData() {
      return this.data;
   }

   /**
    * Give it a name and will get the suitable enum :)
    *
    * @param name
    * @return
    */
   public static NewsPaperTemplateDataEnum forName(final String name) {
      final NewsPaperTemplateDataEnum[] values = NewsPaperTemplateDataEnum.values();
      for (final NewsPaperTemplateDataEnum value : values) {
         if (value.getName().equalsIgnoreCase(name)) {
            return value;
         }
      }
      throw new IllegalArgumentException("Cannot resolve to a Newspaper template the given name: " + name);
   }

}
