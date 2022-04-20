public class Discount {
  private String discountId;
  private String discountName;
  private String discountCode;
  private String discountType;
  private Double discountPercForFood;
  private Double discountPercForDrink;
  private String discountDescription;

  public Discount(String discountId, String discountName, String discountCode, String discountType, Double discountPercForFood, Double discountPercForDrink, String discountDescription) {
    this.discountId = discountId;
    this.discountName = discountName;
    this.discountCode = discountCode;
    this.discountType = discountType;
    this.discountPercForFood = discountPercForFood;
    this.discountPercForDrink = discountPercForDrink;
    this.discountDescription = discountDescription;
  }

  public Double getDiscountPercForFood() {
    return discountPercForFood;
  }

  public Double getDiscountPercForDrink() {
    return discountPercForDrink;
  }

  public String getDiscountType () {
    return discountType;
  }

  public String getDiscountName () {
    return discountName;
  }

  @Override
  public String toString() {
    return discountCode;
  }

  public static Boolean checkDiscount (String discountCode) {
    ReadfileInstance myObj = new ReadfileInstance("discount.txt");
    Object[][] tempObj = myObj.getData();
    for (int i = 0; i < tempObj.length; i++) {
      String temp = (String) tempObj[i][2];
      if(temp.equals(discountCode)) {
        return true;
      }
    }
    return false;
  }

  public static Discount createNewDiscount (String discountCode) {
    ReadfileInstance myObj = new ReadfileInstance("discount.txt");
    Object[][] tempObj = myObj.getData();
    for (int i = 0; i < tempObj.length; i++) {
      String temp = (String) tempObj[i][2];
      if(temp.equals(discountCode)) {
        return new Discount((String) tempObj[i][0],(String) tempObj[i][1],(String) tempObj[i][2],(String) tempObj[i][3], Double.valueOf((String) tempObj[i][4]) ,Double.valueOf((String) tempObj[i][5]),(String) tempObj[i][6]);
      }
    }

    return null;
  }
}
