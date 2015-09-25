package lahija.papelprenshija.diario.factory.template.components.abstractions;

/**
 * Simple class representing x and y values, could be coordinates or width+height values.
 *
 * @author rsilva
 *
 */
public class TwoDimensionsValues {

   private final Integer x;
   private final Integer y;

   /**
    * convenient contructor
    * @param x
    * @param y
    */
   public TwoDimensionsValues(final Integer x, final Integer y) {
      this.x = x;
      this.y = y;
   }

   /**
    * @return the x
    */
   public Integer getX() {
      return this.x;
   }

   /**
    * @return the y
    */
   public Integer getY() {
      return this.y;
   }
}
