package Airline_Ticket_Booking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightZone extends JFrame {
    
    private JTable table;
    private JTextField t;
    Choice ch1;
    public static void main(String[] args) {
        new FlightZone().setVisible(true);
    }
    FlightZone()
    {
        getContentPane().setBackground(new java.awt.Color(77,157,227));
        getContentPane().setFont(new Font("Arial",Font.BOLD,18));
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(860,523);
        setLayout(null);
        setVisible(true);
        
        
        JLabel flightcode=new JLabel("Flight Code");
        flightcode.setFont(new Font("Arial",Font.BOLD,18));
        flightcode.setBounds(100, 100, 150, 30);
        flightcode.setForeground(new Color(15,11,1));
        add(flightcode);
        
        JLabel flightinfo=new JLabel("Flight Information");
        flightinfo.setFont(new Font("Arial",Font.BOLD,33));
        flightinfo.setBounds(300, 20, 570, 35);
        flightinfo.setForeground(new Color(15,11,1));
        add(flightinfo);

        JButton bt=new JButton("Show Details");
        bt.setFont(new Font("Arial",Font.BOLD,18));
        bt.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        try
                        {
                            String code=ch1.getSelectedItem();
                            ConnectionClass obj = new ConnectionClass();
                            String q = "select * from flight where f_code='"+code+"' ";
                            ResultSet rs = obj.stm.executeQuery(q);
                            table.setModel(DbUtils.resultSetToTableModel(rs));
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                });
        bt.setBounds(560, 100, 220, 30);
        add(bt);
        
        table=new JTable();
        table.setFont(new Font("Arial",Font.BOLD,14));
        table.setBounds(23, 250, 800, 300);
        add(table);
        
        ch1=new Choice();
        ch1.setFont(new Font("Arial",Font.BOLD,18));
        ch1.setBounds(250, 103, 200, 35);
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q = "select distinct f_code from flight";
            ResultSet rs = obj.stm.executeQuery(q);
            while(rs.next())
            {
                ch1.add(rs.getString("f_code"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        add(ch1);
        
        JLabel fcode=new JLabel("Flight Code");
        fcode.setFont(new Font("Arial",Font.BOLD,14));
        fcode.setBounds(33, 220, 126, 16);
        fcode.setForeground(new Color(15,11,1));
        add(fcode);
        
        JLabel fname=new JLabel("Flight Code");
        fname.setFont(new Font("Arial",Font.BOLD,14));
        fname.setBounds(155, 220, 126, 16);
        fname.setForeground(new Color(15,11,1));
        add(fname);
        
        JLabel source=new JLabel("Flight Code");
        source.setFont(new Font("Arial",Font.BOLD,14));
        source.setBounds(275, 220, 126, 16);
        source.setForeground(new Color(15,11,1));
        add(source);
        
        JLabel des=new JLabel("Flight Code");
        des.setFont(new Font("Arial",Font.BOLD,14));
        des.setBounds(380, 220, 126, 16);
        des.setForeground(new Color(15,11,1));
        add(des);
        
        JLabel cap=new JLabel("Flight Code");
        cap.setFont(new Font("Arial",Font.BOLD,14));
        cap.setBounds(497, 220, 126, 16);
        cap.setForeground(new Color(15,11,1));
        add(cap);
        
        JLabel cls=new JLabel("Flight Code");
        cls.setFont(new Font("Arial",Font.BOLD,14));
        cls.setBounds(610, 220, 126, 16);
        cls.setForeground(new Color(15,11,1));
        add(cls);
        
        JLabel pri=new JLabel("Flight Code");
        pri.setFont(new Font("Arial",Font.BOLD,14));
        pri.setBounds(740, 220, 126, 16);
        pri.setForeground(new Color(15,11,1));
        add(pri);
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900,650);
        setVisible(true);
        setLocation(100,50);
        
    }
    }

