package lahija.papelprenshija;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lahija.papelprenshija.gui.component.LogoPanel;
import lahija.papelprenshija.gui.component.form.FormPanel;
import net.miginfocom.swing.MigLayout;

public class PapelPrenshija {

   public static void main(final String[] args) throws InterruptedException {
      final JFrame frame = new JFrame("Papel Prenshija");
      frame.setLayout(new MigLayout("wrap 1"));

      final JPanel logoPanel = new LogoPanel();
      frame.add(logoPanel, "align center");

      final JPanel formPanel = new FormPanel();
      frame.add(formPanel);

      //config the frame
      frame.setIconImage(Toolkit.getDefaultToolkit().createImage("support/icon_bar.jpg"));
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(250, 100);
      frame.pack();
      Thread.sleep(2000);

      frame.setVisible(true);
   }

}
