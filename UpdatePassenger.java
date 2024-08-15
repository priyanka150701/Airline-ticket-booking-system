package Airline_Ticket_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.spec.ECField;
import java.sql.*;

public class UpdatePassenger extends JFrame implements ActionListener {

    Choice ch;

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JButton bt1, bt2;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10;

    JFrame ft;

    UpdatePassenger() {
        ft = new JFrame("Update Passenger");
        ft.setBackground(Color.WHITE);
        ft.setLayout(null);

        // f = new Font("Arial", Font.BOLD, 25);
        //f1 = new Font("Arial", Font.BOLD, 18);
        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/img3.jpg"));
        Image img1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        l1.setIcon(ic1);

        ch = new Choice();

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select username from passenger";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch.add(rest.getString("username"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //   l2 = new JLabel("Update Passenger Details");
        l2 = new JLabel("Username");
        l2.setBounds(50, 150, 150, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        ft.add(l1);
        ch.setBounds(200, 150, 150, 30);
        ch.setForeground(Color.BLACK);
        l1.add(ch);

        l3 = new JLabel("Update Passenger Details");
        l3.setBounds(250, 30, 550, 50);
        l3.setFont(new Font("Arial", Font.BOLD, 30));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        l4 = new JLabel("Name");
        l4.setBounds(450, 150, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf2 = new JTextField();
        tf2.setBounds(600, 150, 150, 30);
        l1.add(tf2);

        l5 = new JLabel("Age");
        l5.setBounds(50, 200, 150, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);

        tf3 = new JTextField();
        tf3.setBounds(200, 200, 150, 30);
        l1.add(tf3);

        l6 = new JLabel("Date of Birth");
        l6.setBounds(450, 200, 200, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.BLACK);
        l1.add(l6);

        tf4 = new JTextField();
        tf4.setBounds(600, 200, 150, 30);
        l1.add(tf4);

        l7 = new JLabel("Address");
        l7.setBounds(50, 250, 200, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setForeground(Color.BLACK);
        l1.add(l7);

        tf5 = new JTextField();
        tf5.setBounds(200, 250, 150, 30);
        l1.add(tf5);

        l8 = new JLabel("Phone");
        l8.setBounds(450, 250, 200, 30);
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setForeground(Color.BLACK);
        l1.add(l8);

        tf6 = new JTextField();
        tf6.setBounds(600, 250, 150, 30);
        l1.add(tf6);

        l9 = new JLabel("Email id");
        l9.setBounds(50, 300, 200, 30);
        l9.setFont(new Font("Arial", Font.BOLD, 20));
        l9.setForeground(Color.BLACK);
        l1.add(l9);

        tf7 = new JTextField();
        tf7.setBounds(200, 300, 150, 30);
        l1.add(tf7);

        l10 = new JLabel("Nationality");
        l10.setBounds(450, 300, 120, 30);
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setForeground(Color.BLACK);
        l1.add(l10);

        tf8 = new JTextField();
        tf8.setBounds(600, 300, 150, 30);
        l1.add(tf8);

        l11 = new JLabel("Gender");
        l11.setBounds(50, 350, 100, 30);
        l11.setFont(new Font("Arial", Font.BOLD, 20));
        l11.setForeground(Color.BLACK);
        l1.add(l11);

        tf9 = new JTextField();
        tf9.setBounds(200, 350, 150, 30);
        l1.add(tf9);

        l12 = new JLabel("Passport");
        l12.setBounds(450, 350, 120, 30);
        l12.setFont(new Font("Arial", Font.BOLD, 20));
        l12.setForeground(Color.BLACK);
        l1.add(l12);

        tf10 = new JTextField();
        tf10.setBounds(600, 350, 150, 30);
        l1.add(tf10);

        bt1 = new JButton("Update Passenger");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(250, 500, 150, 40);
        bt1.addActionListener(this);
        l1.add(bt1);

        bt2 = new JButton("Back");
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(450, 500, 150, 40);
        bt2.addActionListener(this);
        l1.add(bt2);

        //l1.setHorizontalAlignment(JLabel.CENTER);
        ft.setVisible(true);
        ft.setSize(900, 600);
        ft.setLocation(300, 100);

        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj2 = new ConnectionClass();
                    String username = ch.getSelectedItem();
                    String q1 = "select * from passenger where username='" + username + "'";

                    ResultSet rest1 = obj2.stm.executeQuery(q1);
                    while (rest1.next()) {
                        tf2.setText(rest1.getString("name"));
                        tf3.setText(rest1.getString("age"));
                        tf4.setText(rest1.getString("dob"));
                        tf5.setText(rest1.getString("address"));
                        tf6.setText(rest1.getString("phone"));
                        tf7.setText(rest1.getString("email"));
                        tf8.setText(rest1.getString("nationality"));
                        tf9.setText(rest1.getString("gender"));
                        tf10.setText(rest1.getString("Passport"));

                    }
                } catch (Exception exx) {
                    exx.printStackTrace();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt2) {
            ft.setVisible(false);
        }
        if (e.getSource() == bt1) {
            String username = ch.getSelectedItem();
             String name = tf2.getText();
            String age = tf3.getText();
            String dob = tf4.getText();
            String address = tf5.getText();
            String phone = tf6.getText();
            String email = tf7.getText();
            String nationality = tf8.getText();
            String gender = tf9.getText();
            String passport = tf10.getText();
           

            try {
                ConnectionClass obj3 = new ConnectionClass();
                String q1 = "update passenger set name='" + name + "',age='" + age + "',dob='" + dob + "',address='" + address + "',phone='" + phone + "',email='" + email + "',nationality='" + nationality + "',gender='" + gender + "',passport='" + passport + "'where username='" + username + "'";
                int aa = obj3.stm.executeUpdate(q1);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Your data successfully Updated");
                    ft.setVisible(false);
                     new viewPassenger().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please, Fill all details carefully");
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new UpdatePassenger().setVisible(true);

    }
}
