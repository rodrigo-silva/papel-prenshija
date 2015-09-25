package lahija.papelprenshija.model.template;

import java.util.NoSuchElementException;

import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;

/**
 * Newspaper template, represents Newspaper structure. Background image, text and picture coordinates, font type, style and sizes.
 *
 * @author rsilva
 *
 */
public interface INewspaperTemplate {

   /**
    * Checks if the newspaper has image caption since it is @Nullable
    * @return
    */
   boolean hasImageCaption();

   /**
    * @return the backgroundTemplate
    */
   BackgroundTemplate getBackgroundTemplate();

   /**
    * @return the titleSection
    */
   TextSection getTitleSection();

   /**
    * @return the subtitleSection
    */
   TextSection getSubtitleSection();

   /**
    * @return the imageCaption if is not null. {@link NoSuchElementException} otherwise
    */
   TextSection getImageCaption();

}