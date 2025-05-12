package bank.management.systems;

import java.sql.*;

public class Conn {

    Connection con;
    Statement stmt;
    
    public Conn(){
        
        
       try {

             // STEP 1: REGISTER THE DRIVER
	     //Class.forName(com.mysql.cj.jdbc.Driver);

	     // STEP 2: GET THE CONNECTION
	     con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystems","root","satish2233");

	     // STEP 3: CREATE THE STATEMENT OBJECT
	     stmt = con.createStatement();

	     // STEP 4: EXECUTE THE QUERIES
	     //stmt.executeUpdate("");

	     // STEP 5: CLOSE THE CONNECTION
	     //con.close();

		} catch (Exception e) {
			System.err.println(e);
		}
    }
    
}
