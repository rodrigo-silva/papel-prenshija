package lahija.papelprenshija.dao.inmemorydata.newspapertemplates;

import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.ClarinANewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.ClarinBNewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.ClarinCNewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.ClarinNewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.ElCapitalANewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.ElCapitalBNewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.ElPoligrilloANewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.INewsPaperTemplateData;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.LaNacionANewsPaperTemplateData;
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
   CLARINA("Clarin A", new ClarinANewsPaperTemplateData()),
   CLARINB("Clarin B", new ClarinBNewsPaperTemplateData()),
   CLARINC("Clarin C", new ClarinCNewsPaperTemplateData()),
   LOS_ANDES("Los Andes", new LosAndesNewsPaperTemplateData()),
   EL_POLIGRILLO_A("El Capital A", new ElCapitalANewsPaperTemplateData()),
   EL_POLIGRILLO_B("El Capital B", new ElCapitalBNewsPaperTemplateData()),
   EL_CAPITAL_A("El poligrillo A", new ElPoligrilloANewsPaperTemplateData()),
   LA_NACION("La Nacion", new LaNacionNewsPaperTemplateData()),
   LA_NACIONA("La Nacion A", new LaNacionANewsPaperTemplateData());

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
