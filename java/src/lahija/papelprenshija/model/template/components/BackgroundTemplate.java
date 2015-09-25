package lahija.papelprenshija.model.template.components;

import lahija.papelprenshija.model.template.components.abstractions.TwoDimensionsValues;

/**
 * Represent the background image template and it's picture coordinates and picture scale.
 *
 * @author rsilva
 *
 */
public class BackgroundTemplate {

   private final String templateBackgroundPath;
   private final TwoDimensionsValues pictureScale;
   private final TwoDimensionsValues pictureCoordinates;

   /**
    * @param templateBackgroundPath path to background image
    * @param pictureScale inner picture scale, height & width sizes
    * @param pictureCoordinates (0,0) picture coordinates
    */
   public BackgroundTemplate(final String templateBackgroundPath, final TwoDimensionsValues pictureScale,
            final TwoDimensionsValues pictureCoordinates) {
      this.templateBackgroundPath = templateBackgroundPath;
      this.pictureScale = pictureScale;
      this.pictureCoordinates = pictureCoordinates;
   }

   /**
    * @return the templateBackgroundPath
    */
   public String getPath() {
      return this.templateBackgroundPath;
   }

   /**
    * @return the pictureScale
    */
   public TwoDimensionsValues getPictureScale() {
      return this.pictureScale;
   }

   /**
    * @return the pictureCoordinates
    */
   public TwoDimensionsValues getPictureCoordinates() {
      return this.pictureCoordinates;
   }
}
