import java.util.ArrayList;
import java.util.List;

public class ItemList {
  public static List <Item> itemList = new ArrayList<Item>();

  public ItemList() {
    ReadfileInstance myObj = new ReadfileInstance("item.txt");
    Object[][] tempObj = myObj.getData();
    for (int i = 0; i < tempObj.length; i++) {
      String itemId = (String) tempObj[i][0];
      String itemName = (String) tempObj[i][1];
      String itemType =  (String) tempObj[i][2];
      Double itemPrice = Double.parseDouble((String) tempObj[i][3]);
      Item item = new Item.Item_Builder(itemId, itemName, itemType, itemPrice).buildItem();
      itemList.add(item);
    }
  }

  public static Item[] getItems() {
    return itemList.toArray(new Item[itemList.size()]);
  }
}
