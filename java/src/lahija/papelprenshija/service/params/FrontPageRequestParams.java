package lahija.papelprenshija.service.params;

/**
 * UI incoming request. In a way it is just a DTO.
 *
 * @author rsilva
 *
 */
public class FrontPageRequestParams {
   private final String tile;
   private final String subtitle;
   private final String featureImagePath;
   private final String caption;
   private final String templateName;

   /**
    * Full constructor
    *
    * @param tile
    * @param subtitle
    * @param featureImagePath
    * @param caption
    * @param templateName
    */
   public FrontPageRequestParams(final String tile, final String subtitle, final String featureImagePath, final String caption,
            final String templateName) {
      this.tile = tile;
      this.subtitle = subtitle;
      this.featureImagePath = featureImagePath;
      this.caption = caption;
      this.templateName = templateName;
   }

   /**
    * @return the tile
    */
   public String getTitle() {
      return this.tile;
   }

   /**
    * @return the subtitle
    */
   public String getSubtitle() {
      return this.subtitle;
   }

   /**
    * @return the featureImagePath
    */
   public String getFeatureImagePath() {
      return this.featureImagePath;
   }

   /**
    * @return the caption
    */
   public String getCaption() {
      return this.caption;
   }

   /**
    * @return the templateId
    */
   public String getTemplateName() {
      return this.templateName;
   }



}
