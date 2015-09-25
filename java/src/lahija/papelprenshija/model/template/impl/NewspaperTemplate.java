package lahija.papelprenshija.model.template.impl;

import java.util.NoSuchElementException;

import lahija.papelprenshija.model.template.INewspaperTemplate;
import lahija.papelprenshija.model.template.components.BackgroundTemplate;
import lahija.papelprenshija.model.template.components.TextSection;

import com.sun.istack.internal.Nullable;

/**
 * Newspaper template, represents Newspaper structure. Background image, text and picture coordinates, font type, style and sizes.
 *
 * @author rsilva
 *
 */
public class NewspaperTemplate implements INewspaperTemplate {
   private final BackgroundTemplate backgroundTemplate;
   private final TextSection titleSection;
   private final TextSection subtitleSection;
   @Nullable
   private final TextSection imageCaption;

   /**
    * @param backgroundTemplate
    * @param titleSection
    * @param subtitleSection
    * @param imageCaption
    */
   public NewspaperTemplate(final BackgroundTemplate backgroundTemplate, final TextSection titleSection, final TextSection subtitleSection,
            @Nullable final TextSection imageCaption) {
      this.backgroundTemplate = backgroundTemplate;
      this.titleSection = titleSection;
      this.subtitleSection = subtitleSection;
      this.imageCaption = imageCaption;
   }

   @Override
   public boolean hasImageCaption() {
      return this.imageCaption != null;
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
      if (this.hasImageCaption()) {
         return this.imageCaption;
      } else {
         throw new NoSuchElementException("Newspaper doesn't have image caption. Please check is before requesting it.");
      }
   }


}
