package lahija.papelprenshija.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.NewsPaperTemplateDataEnum;
import lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data.INewsPaperTemplateData;
import lahija.papelprenshija.model.template.INewspaperTemplate;
import lahija.papelprenshija.model.template.impl.NewspaperTemplate;

/**
 * DAO to access In Memory data.
 *
 * @author rsilva
 *
 */
public class InMemoryDAO {

   /**
    * Returns front page names list
    *
    * @return
    */
   public static List<String> getFrontPageNames() {
      final List<String> names = new ArrayList<>();
      final NewsPaperTemplateDataEnum[] values = NewsPaperTemplateDataEnum.values();
      for (final NewsPaperTemplateDataEnum newsPaperTemplateEnum : values) {
         names.add(newsPaperTemplateEnum.getName());
      }

      return names;
   }

   /**
    * returns template for the given name.
    *
    * @param name
    * @return
    */
   public static INewspaperTemplate getNewspaperTemplateByName(final String name) {
      final NewsPaperTemplateDataEnum newsPaperTemplate = NewsPaperTemplateDataEnum.forName(name);
      final INewsPaperTemplateData data = newsPaperTemplate.getData();

      return new NewspaperTemplate(data.getBackgroundTemplate(), data.getTitleSection(), data.getSubtitleSection(),
               data.getImageCaption());
   }

   /**
    * Returns front page names list with path to background template
    *
    * @return
    */
   public static Map<String, String> getFrontPageNamesAndBackgroundTemplatePath() {
      final Map<String, String> namesAndPaths = new LinkedHashMap<String, String>();
      final NewsPaperTemplateDataEnum[] values = NewsPaperTemplateDataEnum.values();
      for (final NewsPaperTemplateDataEnum value : values) {
         namesAndPaths.put(value.getName(), value.getData().getBackgroundTemplate().getPath());
      }

      return namesAndPaths;
   }

}
