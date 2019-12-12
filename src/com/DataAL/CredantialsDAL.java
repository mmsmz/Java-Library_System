package com.DataAL;

import com.PresentationL.MenuUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CredantialsDAL {
	 // Your connection string to connect IBM DB2 Database 
   Connection conn;
	
	public CredantialsDAL(){
		 try
         {
             DBConnection dbObj = new DBConnection();
             conn = dbObj.getConnection();
         }
         catch (Exception ex)
         {
             JOptionPane.showMessageDialog(null, "Can't Open Connection!! " + ex.getMessage());
         }
	}
    // Region Check user Exist
    public void getAuthentication(String userID, String password) {
	}
  
}
