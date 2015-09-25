package lahija.papelprenshija.dao.inmemorydata.newspapertemplates.data;

import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;

import com.sun.istack.internal.Nullable;

/**
 * Abstraction of new paper data template. It has common structure and behaviour.
 * Subclasses must implement method to provide real data.
 *
 * @author rsilva
 *
 */
public abstract class AbstractNewsPaperTemplateData implements INewsPaperTemplateData {
   protected static String TEMPLATE_BASE_DIR = "templates/";

   private final BackgroundTemplate backgroundTemplate;
   private final TextSection titleSection;
   private final TextSection subtitleSection;
   @Nullable
   private final TextSection imageCaption;

   protected AbstractNewsPaperTemplateData() {
      this.backgroundTemplate = this.getInternalBackgroundTemplate();
      this.titleSection = this.getInternalTitleSection();
      this.subtitleSection = this.getInternalSubtitleSection();
      this.imageCaption = this.getInternalImageCaption();
   }

   @Override
   public BackgroundTemplate getBackgroundTemplate() {
      return this.backgroundTemplate;
   }

   @Override
   public TextSection getTitleSection() {
      return this.titleSection;
   }

   @Override
   public TextSection getSubtitleSection() {
      return this.subtitleSection;
   }


   @Override
   public TextSection getImageCaption() {
      return this.imageCaption;
   }

   /**
    * Create {@link BackgroundTemplate} with hardcoded values, of course
    *
    * @return
    */
   protected abstract BackgroundTemplate getInternalBackgroundTemplate();

   /**
    *
    * Create {@link TextSection} for title section with hardcoded values, of course
    *
    * @return
    */
   protected abstract TextSection getInternalTitleSection();

   /**
    * Create {@link TextSection} for subtitle section with hardcoded values, of course
    *
    * @return
    */
   protected abstract TextSection getInternalSubtitleSection();

   /**
    * Create {@link TextSection} for caption section with hardcoded values, of course
    *
    * @return
    */
   protected abstract TextSection getInternalImageCaption();
}
