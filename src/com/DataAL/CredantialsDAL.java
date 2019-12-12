package com.DataAL;

import com.BusinessAL.CredentialVal;
import com.PresentationL.MenuUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

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
    public CredentialVal getAuthentication(Optional<String> userID, Optional<String> password) {


        String select ="Select type from login_tabl where username=? and password=?";
        try {

            PreparedStatement pst =conn.prepareStatement(select);
            pst.setString(1, userID.get());
            pst.setString(2, password.get());
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                String name = rs.getString("type");

                if (name.equals("administration")) {

                    JOptionPane.showMessageDialog(null,"Access Permitted", "Access Permitted", JOptionPane.INFORMATION_MESSAGE);
                    MenuUI admin = new MenuUI();
                    admin.setVisible(true);
                }
                else if (name.equals("MANAGER")){
                    JOptionPane.showMessageDialog(null,"Access Permitted", "Access Permitted", JOptionPane.INFORMATION_MESSAGE);

                }
                //conn.close();
            }
            else {
                JOptionPane.showMessageDialog(null, "Access Denied");
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Access Permitted", "Access Permitted", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }
  
}
