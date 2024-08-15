package Airline_Ticket_Booking;

import java.sql.*;

public class ConnectionClass
{
    Connection con;

    Statement stm;

    ConnectionClass()
    {
        try
        {
            Class.forName( "com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/airline","root","1234");

            stm=con.createStatement();
            System.out.println("Conection is sucressfull");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
        
    }
    public static void main(String[] args)
    {
        new ConnectionClass();
    }

}