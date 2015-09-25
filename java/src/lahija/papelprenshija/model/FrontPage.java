package lahija.papelprenshija.model;

import java.io.IOException;

import lahija.papelprenshija.model.params.FrontPageInstanceParams;
import lahija.papelprenshija.model.template.INewspaperTemplate;

/**
 * Front page model. Holds template info plus instance parameter
 * @author rsilva
 *
 */
public class FrontPage {
   private final INewspaperTemplate newspaperTemplate;
   private final FrontPageInstanceParams instanceParams;

   /**
    * @param imageRepresentation
    * @param newspaperTemplate
    * @param instanceParams
    * @throws IOException
    */
   public FrontPage(final INewspaperTemplate newspaperTemplate, final FrontPageInstanceParams instanceParams) {
      this.newspaperTemplate = newspaperTemplate;
      this.instanceParams = instanceParams;
   }

   /**
    * @return the newspaperTemplate
    */
   public INewspaperTemplate getNewspaperTemplate() {
      return this.newspaperTemplate;
   }

   /**
    * @return the instanceParams
    */
   public FrontPageInstanceParams getInstanceParams() {
      return this.instanceParams;
   }
}
