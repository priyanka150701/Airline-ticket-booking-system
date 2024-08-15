package Airline_Ticket_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AdminHomePage extends JFrame implements ActionListener{
    JLabel l1,l2;
    Font f,f1,f2;
    AdminHomePage(){
        super("Admin Home Page");
        setLocation(0,0);
        setSize(1550,800);

        f= new Font("Lucid Fax",Font.BOLD,20);
        f2=new Font("Gadi",Font.BOLD,35);
        f1=new Font("MS UI Gothic",Font.BOLD,15);

        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Icons/img1.jpg"));
        Image img=ic.getImage().getScaledInstance(1550,800,Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);

        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu ("Add Flight");
        m1.add(men1);
        JMenu men2=new JMenu("Change Flight Route");
       
        m1.add(men2);

        

        JMenu men5=new JMenu("Cancel Flight");
        
        m1.add(men5);

        JMenu men6=new JMenu("Check Seat");
       
        m1.add(men6);

        JMenu men8=new JMenu("Logout");
        JMenuItem ment14=new JMenuItem("Exit");
        men8.add(ment14);
        m1.add(men8);

        men1.setFont(f);
       men2.setFont(f);
        men5.setFont(f);
        men6.setFont(f);
        men8.setFont(f);


       
        ment14.setFont(f1);

        m1.setBackground(new java.awt.Color(4,1,46));

        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
        
        men5.setForeground(Color.GRAY);
        men6.setForeground(Color.GRAY);
        men8.setForeground(Color.RED);

        
        ment14.setForeground(Color.BLACK);

        
        ment14.setForeground(Color.RED);

       men1.addActionListener(this);
       men2.addActionListener(this);
       men5.addActionListener(this);
       men6.addActionListener(this);
        ment14.addActionListener(this);

        setJMenuBar(m1);
        add(l1);
    }
    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        if(cmd.equals("Add Flight")){
            new AddFlight().setVisible(true);
        }else if(cmd.equals("Change Flight Route")){
          // new ChangeFlightRoute().setVisible(true);
        }
        
        else if(cmd.equals("Cancel Flight")){
          // new CancelFlight().setVisible(true);
        }
        else if(cmd.equals("Check Seat")){
            //new CheckSeat();
        }
        else if(cmd.equals("Exit")){
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new AdminHomePage().setVisible(true);
    }
}
