package com.DataAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	  private String username; 
	  private String password;
	  
      public Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
         // Register the Mysql Jdbc Driver Here
      	Class.forName("com.mysql.jdbc.Driver").newInstance();

      	String URL = "jdbc:mysql://db4free.net:3306/librarysystem_db?autoReconnect=true&useSSL=false";
  	    Connection conn = null;
  	    username="un_24917239"; //    username="unaux_24917239";
	    password="lfum9wsngnqfp";
	      try {
	          //Established Connection Object
			  conn = DriverManager.getConnection(URL,username, password);
	      } catch (SQLException e) {
	          throw new RuntimeException("Cannot connect the database!", e);
	      }
	      return conn;
}

//public void addvalue(String SQL)throws Exception{
//  Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:3306/librarysystem_db?user=root&password=123");
//  Statement st=conn.createStatement();
//  st.executeUpdate(SQL);
//  conn.close();
//}

}
