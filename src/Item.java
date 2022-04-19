public class Item {
  private final String itemName;
  private final String itemType;
  private final Double itemPrice;
  private final String itemId;

  private Item(Item_Builder builder) {
    this.itemName = builder.itemName;
    this.itemType = builder.itemType;
    this.itemPrice = builder.itemPrice;
    this.itemId = builder.itemId;
  }

  public String getName() {
    return itemName;
  }

  public String getType() {
    return itemType;
  }

  public Double getPrice() {
    return itemPrice;
  }

  public String getId() {
    return itemId;
  }

  @Override
  public String toString() {
    return "Item{" +
            "itemName='" + itemName;
  }

  public static class Item_Builder {
    private final String itemName;
    private final String itemType;
    private final Double itemPrice;
    private final String itemId;

    public Item_Builder (String itemId,String itemName, String itemType,  Double itemPrice){
      this.itemName = itemName;
      this.itemType = itemType;
      this.itemPrice = itemPrice;
      this.itemId = itemId;
    }

    public Item buildItem() {
      return new Item(this);
    }
  }
}