import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ReceiptFrame extends JFrame {
  public ReceiptFrame(Order order) {
    setTitle("Receipt");
    setLayout(new BorderLayout());
    System.out.println("yo");

    JPanel headerPanel = new JPanel();
    JPanel tablePanel = new JPanel();
    JPanel summaryPanel = new JPanel();
    JPanel billPanel = new JPanel();
    JPanel billInfo = new JPanel();

    JLabel headerLabel = new JLabel("Receipt");
    JLabel subtotalLabel = new JLabel("Subtotal");
    JLabel subTotalValue = new JLabel(NumberFormat.getCurrencyInstance().format(order.getTotalPrice()));
    JLabel discountLabel = new JLabel("Discount");
    JLabel discountValue;
    if(order.getDiscount() != null) {
      discountValue = new JLabel((String) order.getDiscount().getDiscountName());
    } else {
      discountValue = new JLabel("N/A");
    }
    JLabel totaLabel = new JLabel("Total");
    JLabel totalValue = new JLabel(NumberFormat.getCurrencyInstance().format(order.getTotalDiscount()));

    String[] columns = {"Item Name", "Price"};
    Object [][] data = new Object[order.getCurrentItems().length][2];

    for (int i = 0; i < order.getCurrentItems().length; i++) {
      data[i][0] = order.getCurrentItems()[i].getName();
      data[i][1] = NumberFormat.getCurrencyInstance().format(order.getCurrentItems()[i].getPrice());
    }

    JTable table = new JTable(data, columns);
    table.setFillsViewportHeight(true);
    table.setFont(new Font("Inter", Font.PLAIN, 14));
    JScrollPane scrollpane = new JScrollPane(table);

    tablePanel.setLayout(new BorderLayout());
    tablePanel.add(scrollpane, BorderLayout.CENTER);

    billInfo.setLayout(new GridLayout(3,2));
    billInfo.add(subtotalLabel);
    billInfo.add(subTotalValue);
    billInfo.add(discountLabel);
    billInfo.add(discountValue);
    billInfo.add(totaLabel);
    billInfo.add(totalValue);

    headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
    headerPanel.add(headerLabel);

    billPanel.setLayout(new BorderLayout());
    billPanel.add(billInfo, BorderLayout.NORTH);

    summaryPanel.setLayout(new GridLayout(1,1));
    summaryPanel.add(billPanel);

    this.add(headerPanel, BorderLayout.NORTH);
    this.add(tablePanel, BorderLayout.CENTER);
    this.add(summaryPanel, BorderLayout.SOUTH);

    setResizable(false);
    setSize(1000,800);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
