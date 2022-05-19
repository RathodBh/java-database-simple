
package db_1;
import java.sql.*;
import java.util.*; // for Scanner class

import java.util.logging.Level;
import java.util.logging.Logger;

public class Db_1 {
    //create main class => selected
    public static void main(String[] args) throws SQLException {
     
        try {
            Connection con;
            PreparedStatement ps;
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bh_test", "bhavesh", "bhavesh");
            
            Scanner sc = new Scanner(System.in);
            
            //Getting user information
            System.out.println("Enter Id: ");
            int id = sc.nextInt();
            
            System.out.println("Enter Name:");
            String nm = sc.next(); // or sc.nextLine()
            
            System.out.println("Enter Department: ");
            String dept = sc.next(); // or sc.nextLine()
            
            
            //Insert Query
            ps = con.prepareStatement("INSERT INTO student(id, name, dept) VALUES(?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, nm);
            ps.setString(3,dept);
            
            ps.executeUpdate();
            
            
            System.out.println("Insertition success");
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Db_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

/*
Step 1 : import java.sql.*;
Step 2: Add JAR file
Step 3: Create database in MYSQL WORKBENCH

    database name: bh_test
    Table name: student
    Columns : id, name, dept

Step 4: write this code in main() method

*/