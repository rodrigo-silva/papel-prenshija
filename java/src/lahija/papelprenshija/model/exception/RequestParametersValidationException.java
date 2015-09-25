package lahija.papelprenshija.model.exception;

/**
 * Exception when request parameters validation fails.
 *
 * @author rsilva
 *
 */
@SuppressWarnings("serial")
public class RequestParametersValidationException extends RuntimeException {

   public RequestParametersValidationException(final String message, final Throwable cause) {
      super(message, cause);
   }

   public RequestParametersValidationException(final String message) {
      super(message);
   }
}
