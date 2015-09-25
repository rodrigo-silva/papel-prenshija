package lahija.papelprenshija.diario;

import java.awt.image.BufferedImage;


/**
 * This class represents user parameters to build a front page newspaper. It does not include, indicate the newspaper type.
 *
 * @author rsilva
 *
 */
public class FrontPageParams {
   private final String tile;
   private final String subtitle;
   private final BufferedImage image;
   private final String caption;

   /**
    * @param tile
    * @param subtitle
    * @param image
    * @param caption
    */
   public FrontPageParams(final String tile, final String subtitle, final BufferedImage image, final String caption) {
      this.tile = tile;
      this.subtitle = subtitle;
      this.image = image;
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
      return this.image;
   }

   /**
    * @return the caption
    */
   public String getCaption() {
      return this.caption;
   }
}