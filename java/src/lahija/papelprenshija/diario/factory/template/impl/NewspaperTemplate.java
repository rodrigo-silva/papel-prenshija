package lahija.papelprenshija.diario.factory.template.impl;

import java.util.NoSuchElementException;

import lahija.papelprenshija.diario.factory.template.components.BackgroundTemplate;
import lahija.papelprenshija.diario.factory.template.components.TextSection;
import lahija.papelprenshija.factory.template.INewspaperTemplate;

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

   /* (non-Javadoc)
    * @see lahija.papelprenshija.diario.factory.template.INewspaperTemplate#hasImageCaption()
    */
   @Override
   public boolean hasImageCaption() {
      return this.imageCaption != null;
   }
   /* (non-Javadoc)
    * @see lahija.papelprenshija.diario.factory.template.INewspaperTemplate#getBackgroundTemplate()
    */
   @Override
   public BackgroundTemplate getBackgroundTemplate() {
      return this.backgroundTemplate;
   }

   /* (non-Javadoc)
    * @see lahija.papelprenshija.diario.factory.template.INewspaperTemplate#getTitleSection()
    */
   @Override
   public TextSection getTitleSection() {
      return this.titleSection;
   }

   /* (non-Javadoc)
    * @see lahija.papelprenshija.diario.factory.template.INewspaperTemplate#getSubtitleSection()
    */
   @Override
   public TextSection getSubtitleSection() {
      return this.subtitleSection;
   }

   /* (non-Javadoc)
    * @see lahija.papelprenshija.diario.factory.template.INewspaperTemplate#getImageCaption()
    */
   @Override
   public TextSection getImageCaption() {
      if (this.hasImageCaption()) {
         return this.imageCaption;
      } else {
         throw new NoSuchElementException("Newspaper doesn't have image caption. Please check is before requesting it.");
      }
   }


}
