package productDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductDBConnection {
	
//            public static void main(String[] args) {
//	        ProductDBConnection.getConnection();
//	    }
	

public static Connection getConnection() {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productDB","root","Pr@tikshamysql26");
//			System.out.println("database connected successfully");
		}catch(Exception e)
		{
//			System.out.println("failed to connect database");
			e.printStackTrace();
		}
		return con;
	}

}


 

