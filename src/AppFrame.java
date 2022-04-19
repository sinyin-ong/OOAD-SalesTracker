import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Graphics;

public class AppFrame extends JFrame{

    private int totalFood = 0;
    private int totalDrink = 0;
//    private int totalItem = ItemList.getItems().length;

    public AppFrame(Order myOrder){

        JPanel menuPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel orderTitlePanel = new JPanel();
        JPanel foodPanel = new JPanel();
        JPanel drinkPanel = new JPanel();

        JPanel orderWrapper = new JPanel();
        JPanel orderPanel = new JPanel();

        JPanel orderList = new JPanel();
        JPanel couponPanel = new JPanel();
        JPanel billPanel = new JPanel();
        JPanel billInfo = new JPanel();

        JTabbedPane tab = new JTabbedPane();

        JTextField couponCode = new JTextField("Enter coupon code");


        JButton checkout = new JButton("Checkout");
        JButton applyCoupon = new JButton("Apply Coupon");

        JLabel topBar = new JLabel("Menu");
        JLabel orderTitle = new JLabel("Your Order");

        for (int i=0; i<ItemList.getItems().length; i++)
        {
            String currentItemType = ItemList.getItems()[i].getType();

            if(currentItemType.equals("Food")) {
                totalFood++;
            }
            else if(currentItemType.equals("Drink")) {
                totalDrink++;
            }
        }

        //System.out.println(totalFood);

        JPanel[] foodList = new JPanel[totalFood];

        JLabel[] foodName = new JLabel[totalFood];
        JLabel[] foodPrice = new JLabel[totalFood];
        JLabel[] drinkName = new JLabel[totalDrink];
        JLabel[] drinkPrice = new JLabel[totalDrink];

//        JButton[] addFood = new JButton[totalFood];
//        JButton[] addDrink = new JButton[totalDrink];
        JLabel subTotalLabel = new JLabel("Subtotal");
        JLabel subTotalValue = new JLabel("RM 0.00");

        JLabel discountLabel = new JLabel("Discount");
        JLabel discountValue = new JLabel("0%");

        JLabel totalLabel = new JLabel("Total Bill");
        JLabel totalValue = new JLabel("RM 0.00");

        for (int i=0; i<ItemList.getItems().length; i++)
        {
            JPanel tempPanel = new JPanel();
            JPanel tempOrderPanel = new JPanel();
            JButton addButton = new JButton("Add");
            String currentItemType = ItemList.getItems()[i].getType();
            int foodCount=0;
            int drinkCount=0;
            final Integer count = i;

            if(currentItemType.equals("Food")) {
                foodName[foodCount] = new JLabel(ItemList.getItems()[i].getName());
                foodPrice[foodCount] = new JLabel("RM"+String.valueOf(ItemList.getItems()[i].getPrice()));
                JLabel orderFood = new JLabel(ItemList.getItems()[i].getName());
                JLabel orderPrice = new JLabel("RM"+String.valueOf(ItemList.getItems()[i].getPrice()));
                String currentFood = ItemList.getItems()[i].getName();

//                tempPanel.setLayout(new FlowLayout());
                tempPanel.add(foodName[foodCount]);
                tempPanel.add(foodPrice[foodCount]);
                tempPanel.add(addButton);
                foodPanel.add(tempPanel);

                foodPanel.revalidate();
                foodPanel.repaint();

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tempOrderPanel.add(orderFood);
                        tempOrderPanel.add(orderPrice);
                        orderPanel.add(tempOrderPanel);
                        orderPanel.revalidate();
                        orderPanel.repaint();

                        myOrder.addItem(ItemList.getItems()[count]);
                        subTotalValue.setText("RM "+String.valueOf(myOrder.getTotalPrice()));
                        totalValue.setText("RM "+String.valueOf(myOrder.getTotalPrice()));
                    }
                });

                foodCount++;
            }
            else if(currentItemType.equals("Drink")) {
                drinkName[drinkCount] = new JLabel(ItemList.getItems()[i].getName());
                drinkPrice[drinkCount] = new JLabel("RM"+String.valueOf(ItemList.getItems()[i].getPrice()));
                JLabel orderDrink = new JLabel(ItemList.getItems()[i].getName());
                JLabel orderPrice = new JLabel("RM"+String.valueOf(ItemList.getItems()[i].getPrice()));
//                JLabel orderQuantity= new JLabel("0");

                tempPanel.add(drinkName[drinkCount]);
                tempPanel.add(drinkPrice[drinkCount]);
                tempPanel.add(addButton);
                drinkPanel.add(tempPanel);

                drinkPanel.revalidate();
                drinkPanel.repaint();

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tempOrderPanel.add(orderDrink);
                        tempOrderPanel.add(orderPrice);
//                        tempOrderPanel.add(orderQuantity);
                        orderPanel.add(tempOrderPanel);
                        orderPanel.revalidate();
                        orderPanel.repaint();

                        myOrder.addItem(ItemList.getItems()[count]);
                        subTotalValue.setText("RM "+String.valueOf(myOrder.getTotalPrice()));
                        totalValue.setText("RM "+String.valueOf(myOrder.getTotalPrice()));
                    }
                });

                drinkCount++;
            }
        }

        applyCoupon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = couponCode.getText();
                Boolean couponFound = Discount.checkDiscount(code);

                System.out.println("couponFound: "+couponFound);
                if(couponFound){

                    System.out.println("Yes hi");
//                    discountValue.setText(Discount.get);
                    Discount newDisc = Discount.createNewDiscount(code);
                    myOrder.setDiscount(newDisc);
                    myOrder.updatePrice();


                    totalValue.setText("RM "+String.valueOf(myOrder.getTotalPrice()));

                    if(newDisc.getDiscountType().equals("Food")) {
                        discountValue.setText(String.valueOf(newDisc.getDiscountPercForFood()+"% (Food only)"));
                    }
                    else if(newDisc.getDiscountType().equals("Drink")) {
                        discountValue.setText(String.valueOf(newDisc.getDiscountPercForDrink()+"% (Drink only)"));
                    }
                    else if(newDisc.getDiscountType().equals("Bundled")) {
                        discountValue.setText(String.valueOf(newDisc.getDiscountPercForFood()+"% + "+newDisc.getDiscountPercForDrink()+"% (Bundled)"));
                    }
//                    for(int i = 0; i<myOrder.getCurrentItems().length; i++)
//                    {
//                        String currentItemType = myOrder.getCurrentItems()[0].getType();
//
//                        if(currentItemType.equals("Food")) {
//
//                        }
//
//
//                        System.out.println();
//                    }
                }
                else if(!couponFound)
                {
                    System.out.println("Coupon not found!");
                }






                //myOrder.setDiscount();
                //discountValue.setText(Discount.);
            }
        });



//        for (int i=0; i<totalFood; i++)
//        {
//            foodList[i].add(foodName[i]);
//            foodPanel.add(foodList[i]);
//
//            foodList[i].revalidate();
//            foodList[i].repaint();
//            foodPanel.revalidate();
//            foodPanel.repaint();
//        }



        setResizable(false);
        setSize(1000,800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(topPanel,BorderLayout.NORTH);
        this.add(menuPanel,BorderLayout.CENTER);
//        this.add(tab,BorderLayout.WEST);
//        this.add(orderPanel,BorderLayout.EAST);

        menuPanel.setBackground(Color.WHITE);
//        jp.add(menuPanel);

        menuPanel.setLayout(new GridLayout(1,2));
        menuPanel.add(tab);
        menuPanel.add(orderWrapper);

        topPanel.add(topBar);
        topPanel.setBackground(Color.CYAN);

        tab.setBounds(50,50,200,200);
        tab.add("Food", foodPanel);
        tab.add("Drink", drinkPanel);

        foodPanel.setLayout(new BoxLayout(foodPanel, BoxLayout.Y_AXIS));
        drinkPanel.setLayout(new BoxLayout(drinkPanel, BoxLayout.Y_AXIS));
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));

//        foodName.setText("Fried Chicken");
//        foodPrice.setText("RM 20.00");


//        foodList.setLayout(new GridBagLayout());
//
//        GridBagConstraints gbc = new GridBagConstraints();
//
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 3;
//        gbc.gridheight = 1;
//        foodList.add(foodName,gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;
//        foodList.add(foodPrice,gbc);
//
//        gbc.gridx = 2;
//        gbc.gridy = 0;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 1;
//        foodList.add(addOrder,gbc);

//        foodList.add(foodName);
//        foodList.add(foodPrice);
        //foodList.add(addOrder);

        orderWrapper.setLayout(new BorderLayout());
        orderWrapper.add(orderTitlePanel, BorderLayout.NORTH);
        orderWrapper.add(orderPanel, BorderLayout.CENTER);
        orderWrapper.add(billPanel, BorderLayout.SOUTH);




        orderTitlePanel.add(orderTitle);
        orderPanel.add(orderList);

        billPanel.setLayout(new BorderLayout());

        billPanel.add(couponPanel,BorderLayout.NORTH);
        billPanel.add(billInfo,BorderLayout.CENTER);
        billPanel.add(checkout,BorderLayout.SOUTH);

        couponPanel.add(couponCode);
        couponPanel.add(applyCoupon);

        billInfo.setLayout(new GridLayout(3,2));
        billInfo.add(subTotalLabel);
        billInfo.add(subTotalValue);
        billInfo.add(discountLabel);
        billInfo.add(discountValue);
        billInfo.add(totalLabel);
        billInfo.add(totalValue);

        //Prevent override
//        orderList.add(foodName);
//        orderList.add(foodPrice);
//        orderList.add(addOrder);










    }
}