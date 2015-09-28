package lahija.papelprenshija.service;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import lahija.papelprenshija.model.exception.RequestParametersValidationException;
import lahija.papelprenshija.service.params.FrontPageRequestParams;

import org.junit.Test;

public class PapelPrenshijaServiceTest {

   @Test public void testPrintFrontPage() {
      final String tile = "Lorem ipsum";
      final String subtitle = "Lorem ipsum et sit amet";
      final String featureImagePath = "integration-test/resources/Avant1.jpg";
      final String caption = "Image caption";
      final String templateName = "La Posta";

      final FrontPageRequestParams requestParams = new FrontPageRequestParams(tile, subtitle, featureImagePath, caption, templateName);
      PapelPrenshijaService.printFrontPage(requestParams);
   }

   @Test public void testGetFrontPageNames() {
      final List<String> expectedNames = Arrays.asList("Clarin", "La Nacion", "La Posta", "Los Andes");
      final List<String> names = PapelPrenshijaService.getFrontPageNames();

      for (final String name : expectedNames) {
         names.contains(name);
      }
   }

   @Test public void testPrintFrontPageWithEmptyCaption() {
      final String tile = "Titular";
      final String subtitle = "Lorem ipsum et sit amet";
      final String featureImagePath = "integration-test/resources/lahija.jpg";
      final String caption = "";

      FrontPageRequestParams requestParams = new FrontPageRequestParams(tile, subtitle, featureImagePath, caption, "Clarin");
      PapelPrenshijaService.printFrontPage(requestParams);

      requestParams = new FrontPageRequestParams(tile, subtitle, featureImagePath, caption, "La Posta");
      try {
         PapelPrenshijaService.printFrontPage(requestParams);
         fail("Should throw RequestParametersValidationException");
      } catch (final RequestParametersValidationException e) {
      }
   }

   @Test public void testPrintAllFrontPage() {
      final String tile = "Lorem ipsum";
      final String subtitle = "Lorem ipsum et sit amet";
      final String featureImagePath = "integration-test/resources/Avant1.jpg";
      final String caption = "Image caption";

      final List<String> names = PapelPrenshijaService.getFrontPageNames();

      for (final String name : names) {
         final FrontPageRequestParams requestParams = new FrontPageRequestParams(tile, subtitle, featureImagePath, caption, name);
         PapelPrenshijaService.printFrontPage(requestParams);
      }

   }
}
