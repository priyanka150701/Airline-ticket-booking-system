/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Airline_Ticket_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3;

    JButton b1, b2;

    Index() {

        f = new JFrame("Admin or passenger");
        f.setBackground(Color.green);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 500, 270);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/img3.jpg"));
        Image img1 = img.getImage().getScaledInstance(700, 370, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        l1.setIcon(ic1);
        f.add(l1);

       /* l2 = new JLabel("Source");
        l2.setVisible(true);
        l2.setBounds(40, 60, 150, 30);
        l2.setForeground(Color.WHITE);
        Font F1 = new Font("Airal", Font.BOLD, 21);
        l2.setFont(F1);
        l1.add(l2);
        f.add(l1);
        */

          b1 = new JButton("Admin");
            b1.setBounds(50, 100, 150, 30);
            b1.addActionListener(this);
            l1.add(b1);
             f.add(l1);
              l2=new JLabel("or");
        l2.setVisible(true);
        l2.setBounds(220,100,30,30);
        l2.setForeground(Color.BLACK);
        Font F1=new Font("Airal",Font.BOLD,21);
        l2.setFont(F1);
        l1.add(l2);

            b2 = new JButton("User");
            b2.setBounds(260, 100, 150, 30);
            b2.addActionListener(this);
           
            l1.add(b2);
        f.setSize(500, 270);
        f.setLocation(450, 250);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            f.setVisible(false);
            new Login();
        }
        if (ae.getSource() == b1) {
            f.setVisible(false);
           new AdminLogin();
        }
    }

    public static void main(String[] args) {
        new Index().setVisible(true);
    }
}
