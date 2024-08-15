package Airline_Ticket_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddFlight extends JFrame implements ActionListener {

    JButton bt1, bt2;

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12;
    JFrame f;

    AddFlight() {
        f = new JFrame("Add Flight");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/img2.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1.setIcon(img2);

        l2 = new JLabel("Flight ID");
        l2.setBounds(50, 150, 150, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);

        l3 = new JLabel("Add Flights");
        l3.setBounds(350, 30, 550, 50);
        l3.setFont(new Font("Arial", Font.BOLD, 30));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        tf1 = new JTextField();
        tf1.setBounds(200, 150, 150, 30);
        l1.add(tf1);

        l4 = new JLabel("Flight Time");
        l4.setBounds(250, 250, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf2 = new JTextField();
        tf2.setBounds(450, 250, 150, 30);
        l1.add(tf2);
        
        l7 = new JLabel("Flight Date");
        l7.setBounds(450, 150, 200, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setForeground(Color.BLACK);
        l1.add(l7);

        tf4= new JTextField();
        tf4.setBounds(600, 150, 150, 30);
        l1.add(tf4);

        l5 = new JLabel("Departure");
        l5.setBounds(50, 200, 150, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);

        tf3 = new JTextField();
        tf3.setBounds(200, 200, 150, 30);
        l1.add(tf3);

        l6 = new JLabel("Arrival");
        l6.setBounds(450, 200, 200, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.BLACK);
        l1.add(l6);

        tf5 = new JTextField();
        tf5.setBounds(600, 200, 150, 30);
        l1.add(tf5);

    

        bt1 = new JButton("Save");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(250, 500, 150, 40);
        bt1.addActionListener(this);
        l1.add(bt1);

        bt2 = new JButton("Close");
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(450, 500, 150, 40);
        bt2.addActionListener(this);
        l1.add(bt2);

        f.setVisible(true);
        f.setSize(900, 600);
        f.setLocation(300, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt2) {
            JOptionPane.showMessageDialog(null, "Are you sure to cancle?");
            f.setVisible(false);

        }

        if (e.getSource() == bt1) {
            String flightid= tf1.getText();
            String  flighttime= tf2.getText();
            String flightdate=tf4.getText();
            String departure = tf3.getText();
            String arrival = tf5.getText();
            

            try {
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into addflight values('" + flightid + "', '" +flighttime + "','"+flightdate+"', '" + departure+ "', '" + arrival+ "')";
                obj.stm.executeUpdate(q);

                JOptionPane.showMessageDialog(null, "Details Successfully Inserted");

                f.setVisible(false);

                new AdminHomePage().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AddFlight();
    }
}
