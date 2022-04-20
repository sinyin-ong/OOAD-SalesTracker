import java.awt.event.*;
import java.nio.charset.MalformedInputException;

public class Main{
  ItemList item = new ItemList();
  Order myOrder = new Order();
  AppFrame app = new AppFrame(myOrder);
  Main(){

    app.setVisible(true);
    app.checkout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        app.setVisible(false);

        ReceiptFrame receipt = new ReceiptFrame(myOrder);
        receipt.setVisible(true);
      }});
  }
  public static void main(String[] args){
    new Main();
  }
}
