public class Main {
  public static void main(String[] args){
    ItemList myObj = new ItemList();

    Item[] items = myObj.getItems();
    for (int i = 0; i < items.length; i++) {
      System.out.println(items[i].getName());
    }

//    Discount discount = new Discount("001", "10% off on food", "10OFF", "Drink", 0.0, 10.0, "10% off on food");

    Order myOrder = new Order();

    AppFrame app = new AppFrame(myOrder);
    app.setVisible(true);

//    myOrder.setDiscount(discount);
//    myOrder.addItem(items[0]);
//    myOrder.addItem(items[2]);
//    System.out.println(myOrder.getTotalPrice());

    // System.out.println(Discount.checkDiscount("HARIRAYA"));
    

  }
}
