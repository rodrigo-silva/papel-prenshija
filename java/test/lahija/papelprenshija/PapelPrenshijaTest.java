package lahija.papelprenshija;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lahija.papelprenshija.diario.Clarin;
import lahija.papelprenshija.diario.Diario;
import lahija.papelprenshija.diario.LaNacion;
import lahija.papelprenshija.diario.LaPosta;
import lahija.papelprenshija.diario.LosAndes;

public class PapelPrenshijaTest {

   /**
    * @param args
    * @throws Exception
    */
   public static void main(final String[] args) throws Exception {
      final BufferedImage photo = ImageIO.read(new File("Imagen").listFiles()[0]);

      final String choice = "clarin";
      final String title = "Lozonos se cago encima esta maniana";
      final String subtitle = "Se dice por ahi que lozonos la cago, como Kesito. "
          + "Que hay detras de este Lozonos sin igual que dice que no se cago."
          + "Acusan a Lahija, pero es mentira";
      final String caption = "Extasis de Azucar";

      Diario diario;

      if ("andes".equals(choice)) {
        diario = new LosAndes(photo, title, subtitle, caption);
     } else if ("nacion".equals(choice)) {
        diario = new LaNacion(photo, title, subtitle, caption);
     } else if ("clarin".equals(choice)) {
        diario = new Clarin(photo, title, subtitle, caption);
     } else if ("laposta".equals(choice)) {
       diario = new LaPosta(photo, title, subtitle, caption);
     } else {
        throw new IllegalArgumentException("Elegi un diario bien");
     }

      final BufferedImage tapa = diario.crearTapa();

      try {
         ImageIO.write(tapa, "jpg", new File("diario.jpg"));
      } catch (final IOException e) {
         e.printStackTrace();
      }

   }

}
