import java.util.ArrayList;
import java.util.List;

public class Order {
  private String orderId;
  private List<Item> itemList;
  private Discount discount;
//  private int quantity;
  private double totalPrice;
  private double totalDiscount;

  public Order() {
    this.orderId = "";
    this.itemList = new ArrayList<Item>();
    this.discount = null;
//    this.quantity = 0;
    this.totalPrice = 0.0;
    this.totalDiscount = 0.0;
  }

  public Item[] getCurrentItems () {
    return this.itemList.toArray( new Item[itemList.size()] );
  }

  public void addItem (Item item) {
    this.itemList.add(item);

    updatePrice();
  }

  public void removeItem (Item item) {
    this.itemList.remove(item);

    updatePrice();
  }

  public void setDiscount (Discount discount) {
    this.discount = discount;

    updatePrice();
  }

//  public int getQuantity () {
//    return this.quantity;
//  }

  public Discount getDiscount () {
    return this.discount;
  }

  public double getTotalPrice () {
    return this.totalPrice;
  }

  public double getTotalDiscount () {
    return this.totalDiscount;
  }

  public void updatePrice () {
    this.totalPrice = 0.0;
    this.totalDiscount = 0.0;

    if(discount != null) {
      if(discount.getDiscountType().equals("Food")) {
        for (int i = 0; i < itemList.size(); i++) {
          if(itemList.get(i).getType().equals("Food")) {
            this.totalDiscount += itemList.get(i).getPrice() - (itemList.get(i).getPrice() * (discount.getDiscountPercForFood() / 100));
          }else {
            this.totalDiscount += itemList.get(i).getPrice();
          }

          this.totalPrice += itemList.get(i).getPrice();
        }
      }else if(discount.getDiscountType().equals("Drink")) {
        for (int i = 0; i < itemList.size(); i++) {
          if(itemList.get(i).getType().equals("Drink")) {
            this.totalDiscount += itemList.get(i).getPrice() - (itemList.get(i).getPrice() * (discount.getDiscountPercForDrink() / 100));
          }else {
            this.totalDiscount += itemList.get(i).getPrice();
          }

          this.totalPrice += itemList.get(i).getPrice();
        }
      }else if(discount.getDiscountType().equals("Bundled")) {
        for (int i = 0; i < itemList.size(); i++) {
          if(itemList.get(i).getType().equals("Drink")) {
            this.totalDiscount += itemList.get(i).getPrice() - (itemList.get(i).getPrice() * (discount.getDiscountPercForDrink() / 100)) ;
          } else if(itemList.get(i).getType().equals("Food")) {
            this.totalDiscount += itemList.get(i).getPrice() - (itemList.get(i).getPrice() * (discount.getDiscountPercForFood() / 100)) ;
          }

          this.totalPrice += itemList.get(i).getPrice();
        }
      }
    }else {
      for (Item item : this.itemList) {
        this.totalPrice += item.getPrice();
        this.totalDiscount += item.getPrice();
      }
    }
  }
}
