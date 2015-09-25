package lahija.papelprenshija.model.exception;

/**
 * Represents any error that cannot be handled by user. You may want to shutdown the application for instance.
 *
 * @author rsilva
 *
 */
@SuppressWarnings("serial")
public class SystemException extends RuntimeException {

   public SystemException(final String message, final Throwable cause) {
      super(message, cause);
   }

   public SystemException(final String message) {
      super(message);
   }

}
