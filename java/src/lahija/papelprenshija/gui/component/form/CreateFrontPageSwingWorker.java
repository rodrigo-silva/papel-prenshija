package lahija.papelprenshija.gui.component.form;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import lahija.papelprenshija.model.exception.RequestParametersValidationException;
import lahija.papelprenshija.model.exception.SystemException;
import lahija.papelprenshija.service.PapelPrenshijaService;
import lahija.papelprenshija.service.params.FrontPageRequestParams;

/**
 * Swing worker that creates the front page in background. Responsible of close progress dialog when done
 * @author rsilva
 *
 */
public class CreateFrontPageSwingWorker extends SwingWorker<Void, Void> {

   private final FrontPageRequestParams frontPageRequestParams;
   private final ProgressDialog dialog;
   private final FormPanel formPanel;

   /**
    *
    * @param formPanel to paint alert messages
    * @param dialog Progress dialog to close
    * @param frontPageRequestParams user request parameters to create front page with
    */
   public CreateFrontPageSwingWorker(final FormPanel formPanel, final ProgressDialog dialog,
            final FrontPageRequestParams frontPageRequestParams) {
      this.formPanel = formPanel;
      this.dialog = dialog;
      this.frontPageRequestParams = frontPageRequestParams;
   }

   @Override
   protected Void doInBackground() throws Exception {
      try {
         PapelPrenshijaService.printFrontPage(this.frontPageRequestParams);
         JOptionPane.showMessageDialog(this.formPanel, "Busca la tapa en tu Escritorio", "Listo!",
                  JOptionPane.INFORMATION_MESSAGE);
      } catch (final RequestParametersValidationException e) {
         JOptionPane.showMessageDialog(this.formPanel, e.getMessage(), "Problemita de validacion", JOptionPane.WARNING_MESSAGE);

      } catch (final SystemException e) {
         JOptionPane.showMessageDialog(this.formPanel, e.getMessage(), "Todo mal!!!", JOptionPane.ERROR_MESSAGE);
      } catch (final Exception e) {
         JOptionPane.showMessageDialog(this.formPanel, "Mierda! Un error fatal! Lapapa estas despedido!!", "Fatal Error",
                  JOptionPane.ERROR_MESSAGE);
         System.exit(1);
      }

      return null;
   }

   @Override
   protected void done() {
      this.dialog.dispose();
   }

}
