package Airline_Ticket_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookedFlight extends JFrame implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3;
    JTextField tf1;
    JButton b, b2;
    Choice ch1;

    BookedFlight() {

        f = new JFrame("Select Flight ID");
        f.setBackground(Color.green);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 500, 270);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/img3.jpg"));
        Image img1 = img.getImage().getScaledInstance(700, 370, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        l1.setIcon(ic1);

        l2 = new JLabel("Flight ID");
        l2.setVisible(true);
        l2.setBounds(40, 60, 150, 30);
        l2.setForeground(Color.WHITE);
        Font F1 = new Font("Arial", Font.BOLD, 21);
        l2.setFont(F1);
        l1.add(l2);
        f.add(l1);

        ch1 = new Choice();
        ch1.setBounds(240, 60, 190, 25);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select distinct flight_code from addflight";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch1.add(rest.getString("flight_code"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        l1.add(ch1);
        ch1.setFont(F1);

        l3 = new JLabel("Username");
        l3.setVisible(true);
        l3.setBounds(40, 120, 150, 30);
        l3.setForeground(Color.WHITE);
        l3.setFont(F1);
        l1.add(l3);

        tf1 = new JTextField();
        tf1.setBounds(240, 120, 190, 25);
        l1.add(tf1);

        b = new JButton("Book");
        b.setBounds(240, 200, 100, 30);
        b.addActionListener(this);
        l1.add(b);

        b2 = new JButton("Close");
        b2.setBounds(350, 200, 100, 30);
        b2.addActionListener(this);
        b2.setBackground(Color.red);
        b2.setForeground(Color.WHITE);
        l1.add(b2);

        f.setSize(500, 310);
        f.setLocation(450, 250);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            f.setVisible(false);
        }
        if (ae.getSource() == b) {
            String flightCode = ch1.getSelectedItem();
            String username = tf1.getText();
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username cannot be empty!");
                return;
            }
            bookFlight(flightCode, username);
            f.setVisible(false);
            new Payment(flightCode).setVisible(true);
        }
    }

    private void bookFlight(String flightCode, String username) {
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM addflight WHERE flight_code = '" + flightCode + "'";
            ResultSet rs = obj.stm.executeQuery(q);
            if (rs.next()) {
                String source = rs.getString("departure");
                String destination = rs.getString("arrival");
                String className = rs.getString("class_name");
                double price = rs.getDouble("price");
                String fname = rs.getString("flight_name");
                Date journeyDate = rs.getDate("date");
                Time journeyTime = rs.getTime("departure_time");

                String insertQuery = "INSERT INTO bookedflight (fcode, source, destination, class_name, price, fname, Journey_date, journey_time, username, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = obj.con.prepareStatement(insertQuery);
                pst.setString(1, flightCode);
                pst.setString(2, source);
                pst.setString(3, destination);
                pst.setString(4, className);
                pst.setDouble(5, price);
                pst.setString(6, fname);
                pst.setDate(7, journeyDate);
                pst.setTime(8, journeyTime);
                pst.setString(9, username);
                pst.setString(10, "Booked");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Flight booked successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error booking flight.");
        }
    }

    public static void main(String[] args) {
        new BookedFlight().setVisible(true);
    }
}
