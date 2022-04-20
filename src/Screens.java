import java.awt.event.*;

public class Screens {
  public Screens(Order order) {
    AppFrame app = new AppFrame(order);
    app.setVisible(true);

    app.checkout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        app.setVisible(false);

        ReceiptFrame receipt = new ReceiptFrame(order);
        receipt.setVisible(true);
      }});
  }
}
