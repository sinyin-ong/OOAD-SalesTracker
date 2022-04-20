public class Discount {
  private final String discountId;
  private final String discountName;
  private final String discountCode;
  private final String discountType;
  private final Double discountPercForFood;
  private final Double discountPercForDrink;
  private final String discountDescription;

  public Discount(Discount_Builder builder) {
    this.discountId = builder.discountId;
    this.discountName = builder.discountName;
    this.discountCode = builder.discountCode;
    this.discountType = builder.discountType;
    this.discountPercForFood = builder.discountPercForFood;
    this.discountPercForDrink = builder.discountPercForDrink;
    this.discountDescription = builder.discountDescription;
  }

  public Double getDiscountPercForFood() {
    return discountPercForFood;
  }

  public Double getDiscountPercForDrink() {
    return discountPercForDrink;
  }

  public String getDiscountType() {
    return discountType;
  }

  public String getDiscountName() {
    return discountName;
  }

  @Override
  public String toString() {
    return discountCode;
  }

  public static Boolean checkDiscount(String discountCode) {
    ReadfileInstance myObj = new ReadfileInstance("discount.txt");
    Object[][] tempObj = myObj.getData();
    for (int i = 0; i < tempObj.length; i++) {
      String temp = (String) tempObj[i][2];
      if (temp.equals(discountCode)) {
        return true;
      }
    }
    return false;
  }

  public static Discount createNewDiscount(String discountCode) {
    ReadfileInstance myObj = new ReadfileInstance("discount.txt");
    Object[][] tempObj = myObj.getData();
    for (int i = 0; i < tempObj.length; i++) {
      String temp = (String) tempObj[i][2];
      if (temp.equals(discountCode)) {
        return new Discount.Discount_Builder((String) tempObj[i][0], (String) tempObj[i][1], (String) tempObj[i][2], (String) tempObj[i][3], Double.valueOf((String) tempObj[i][4]), Double.valueOf((String) tempObj[i][5]), (String) tempObj[i][6]).buildDiscount();
      }
    }

    return null;
  }

  public static class Discount_Builder {
    private final String discountId;
    private final String discountName;
    private final String discountCode;
    private final String discountType;
    private final Double discountPercForFood;
    private final Double discountPercForDrink;
    private final String discountDescription;
    public Discount_Builder(String discountId, String discountName, String discountCode, String discountType, Double discountPercForFood, Double discountPercForDrink, String discountDescription)
    {
      this.discountId = discountId;
      this.discountName = discountName;
      this.discountCode = discountCode;
      this.discountType = discountType;
      this.discountPercForFood = discountPercForFood;
      this.discountPercForDrink = discountPercForDrink;
      this.discountDescription = discountDescription;
    }

    public Discount buildDiscount() {
      return new Discount(this);
    }
  }
}
