package lahija.papelprenshija.model.params;

import java.awt.image.BufferedImage;


/**
 * This class represents user parameters to build a front page newspaper. It does not include, indicate the newspaper type.
 *
 * @author rsilva
 *
 */
public class FrontPageInstanceParams {
   private final String tile;
   private final String subtitle;
   private final BufferedImage featureImage;
   private final String caption;

   /**
    * @param tile
    * @param subtitle
    * @param featureImage
    * @param caption
    */
   public FrontPageInstanceParams(final String tile, final String subtitle, final BufferedImage featureImage, final String caption) {
      this.tile = tile;
      this.subtitle = subtitle;
      this.featureImage = featureImage;
      this.caption = caption;
   }

   /**
    * @return the tile
    */
   public String getTile() {
      return this.tile;
   }

   /**
    * @return the subtitle
    */
   public String getSubtitle() {
      return this.subtitle;
   }

   /**
    * @return the image
    */
   public BufferedImage getImage() {
      return this.featureImage;
   }

   /**
    * @return the caption
    */
   public String getCaption() {
      return this.caption;
   }
}