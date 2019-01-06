/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Krzysiek
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.print("he");
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection conn = null;
        try {
            // db parameters
            String url       = "jdbc:oracle:thin:@155.158.112.45:1521:oltpstud";
            String user      = "msbd21";
            String password  = "haslo2018";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt=conn.createStatement();  
  
//step4 execute query  
ResultSet rs=stmt.executeQuery("select * from employees");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
  
//step5 close the connection object  
conn.close();  
        } catch(SQLException e) {
           System.out.println(e.getMessage());
        } finally {
         try{
                   if(conn != null)
                     conn.close();
         }catch(SQLException ex){
                   System.out.println(ex.getMessage());
         }
        }
    }
    
}
