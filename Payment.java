package Airline_Ticket_Booking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Payment extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField tf1;
    JButton b1, b2;
    String flightId;
    double flightPrice;

    // Prices for different classes
    static final double ECONOMY_PRICE = 12000;
    static final double BUSINESS_PRICE = 15000;

    Payment(String flightId) {
        super("Payment");
        this.flightId = flightId;
        setSize(400, 300);
        setLocation(500, 280);
        setLayout(null);

        l1 = new JLabel("Flight ID: " + flightId);
        l1.setBounds(30, 30, 300, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        add(l1);

        l2 = new JLabel("Enter Payment Details:");
        l2.setBounds(30, 80, 300, 30);
        l2.setFont(new Font("Arial", Font.PLAIN, 18));
        add(l2);

        tf1 = new JTextField();
        tf1.setBounds(30, 120, 300, 30);
        add(tf1);

        b1 = new JButton("Pay");
        b1.setBounds(30, 170, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(150, 170, 100, 30);
        b2.addActionListener(this);
        add(b2);

        // Fetch flight price from database
        fetchFlightPrice();
    }

    private void fetchFlightPrice() {
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT class_name FROM addflight WHERE flight_id = ?";
            PreparedStatement pstmt = obj.con.prepareStatement(query);
            pstmt.setString(1, flightId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String className = rs.getString("class_name");
                flightPrice = "Business".equals(className) ? BUSINESS_PRICE : ECONOMY_PRICE;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                double enteredAmount = Double.parseDouble(tf1.getText());
                if (enteredAmount < flightPrice) {
                    JOptionPane.showMessageDialog(null, "Payment failed! Amount is less than the flight price. Try again.");
                } else if (enteredAmount > flightPrice) {
                    double extraAmount = enteredAmount - flightPrice;
                    JOptionPane.showMessageDialog(null, "Payment Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Payment Successful!");
                }
                setVisible(false);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid amount entered. Please enter a valid number.");
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Payment("FL001").setVisible(true);
    }
}
