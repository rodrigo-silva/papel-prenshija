package lahija.papelprenshija.gui.component.form;

import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import lahija.papelprenshija.gui.event.IFormEventsMediator;
import lahija.papelprenshija.gui.event.listener.CloseListener;
import lahija.papelprenshija.gui.event.listener.CreateFrontPageListener;
import lahija.papelprenshija.gui.event.listener.FileChooserListener;
import lahija.papelprenshija.gui.event.listener.SelectTemplateListener;
import lahija.papelprenshija.service.PapelPrenshijaService;
import lahija.papelprenshija.service.params.FrontPageRequestParams;
import net.miginfocom.swing.MigLayout;

/**
 * Form panel and form elements event mediator. It acts as a regular JPanel and also implements Mediator interface to handle messages
 * between components.
 *
 * @author rsilva
 *
 */
@SuppressWarnings("serial")
public class FormPanel extends JPanel implements IFormEventsMediator {

   private final JTextField titleInput;
   private final JTextField subtitleInput;
   private final JTextField captionInput;
   private final JTextField filePathInput;
   private final JComboBox<TemplateComboBoxItem> frontPageComboBox;
   private final TemplatePreviewPanel templatePreviewPanel;

   public FormPanel() {
      super(new MigLayout("wrap 2", "[right][left]"));

      //inputs
      final int textWidth = 40;
      this.titleInput = new JTextField(textWidth);
      this.subtitleInput = new JTextField(textWidth);
      this.captionInput = new JTextField(textWidth);
      this.filePathInput = new JTextField(textWidth);
      this.filePathInput.setEditable(false);
      this.frontPageComboBox = this.createComboBox();
      this.templatePreviewPanel = this.createTemplatePreviewPanel();

      //buttons
      final JButton browseBtn = this.createBrowseFilesButton();
      final JButton createFrontPageBtn = this.createCreateFrontPageButton();
      final JButton closeBtn = this.createExitButton();

      this.add(new JLabel("Titulo(*)"));
      this.add(this.titleInput);
      this.add(new JLabel("Subtitulo(*)"));
      this.add(this.subtitleInput);
      this.add(new JLabel("Texto Imagen[opcional]"));
      this.add(this.captionInput);
      this.add(new JLabel("Foto(*)"));
      this.add(this.filePathInput);
      this.add(browseBtn, "skip");
      this.add(new JLabel("Tapa"));
      this.add(this.frontPageComboBox, "growx");
      this.add(createFrontPageBtn, "skip, split2");
      this.add(closeBtn);

      this.add(this.templatePreviewPanel, String.format("east, gap 20px,  width %dpx, height %dpx",
               this.templatePreviewPanel.getPreviewWidth(), this.templatePreviewPanel.getPreviewHeight()));
   }

   @Override
   public void onPictureFileChosen(final String filepath) {
      this.filePathInput.setText(filepath);
   }

   @Override
   public void onCreateFrontPageButtonClick() {
      final TemplateComboBoxItem selectedItem = this.frontPageComboBox.getItemAt(this.frontPageComboBox.getSelectedIndex());
      final FrontPageRequestParams frontPageRequestParams =
               new FrontPageRequestParams(this.titleInput.getText(), this.subtitleInput.getText(), this.filePathInput.getText(),
                        this.captionInput.getText(), selectedItem.getDisplayName());
      final ProgressDialog dialog =
               new ProgressDialog((JFrame) this.getRootPane().getParent(), "Creando la tapa, aguanta un toque...");
      final SwingWorker<Void, Void> worker = new CreateFrontPageSwingWorker(this, dialog, frontPageRequestParams);
      worker.execute();
      dialog.setVisible(true);
   }

   @Override
   public void onFrontPageTemplateSelect(final TemplateComboBoxItem item) {
      this.templatePreviewPanel.rePaintImage(item.getPathToBackgroudTemplate());
   }

   /**
    *
    * @return
    */
   private JButton createCreateFrontPageButton() {
      final JButton button = new JButton("Crear Tapa");
      button.addActionListener(new CreateFrontPageListener(this));

      return button;
   }

   /**
    * @return
    */
   private JButton createExitButton() {
      final JButton closeButton = new JButton("Chau!");
      closeButton.addActionListener(new CloseListener());

      return closeButton;
   }

   /**
    * Creates browse files button.
    *
    * @return
    */
   private JButton createBrowseFilesButton() {
      final JButton browseBtn = new JButton("Browse...");
      browseBtn.addActionListener(new FileChooserListener(this));
      return browseBtn;
   }

   /**
    * Creates front page combobox.
    *
    * @return JComboBox
    */
   private JComboBox<TemplateComboBoxItem> createComboBox() {
      final JComboBox<TemplateComboBoxItem> jComboBox = new JComboBox<TemplateComboBoxItem>();

      final Map<String, String> namesAndPaths = PapelPrenshijaService.getFrontPageNamesAndBackgroundTemplatePreviewPath();
      for (final Entry<String, String> entry : namesAndPaths.entrySet()) {
         jComboBox.addItem(new TemplateComboBoxItem(entry.getKey(), entry.getValue()));
      }
      //VERY IMPORTANT ADD LISTENER AT THE END. IF YOU ADD PREVIOS TO ADD ITEMS. ADDING ITEMS FIRES SELECT EVENTS :S
      jComboBox.addItemListener(new SelectTemplateListener(this));

      return jComboBox;
   }

   /**
    * @return
    */
   private TemplatePreviewPanel createTemplatePreviewPanel() {
      final TemplateComboBoxItem selectedItem = this.frontPageComboBox.getItemAt(this.frontPageComboBox.getSelectedIndex());

      return new TemplatePreviewPanel(selectedItem.getPathToBackgroudTemplate());
   }

}
