package com.BusinessAL;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.DataAL.CredantialsDAL;
import com.DataAL.NewUserDAL;

public class NewUserBAL {
	
	String username;
	String password;
	String userType;
	
	public NewUserBAL(String username, String password, String userType) {
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public static NewUserBAL userValidation(String uname, String password, String userType) {

        NewUserDAL obj = new NewUserDAL();
        String p = password.toString();
        String s1 = uname.toString();
        String uT = userType.toString();
        
        int length = s1.length();
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        // Now create matcher object.
        Matcher m = r.matcher(p);

        if ((length > 18) || (length >25) ){
            JOptionPane.showMessageDialog(null, "User Name should have" +
                            " minimum of 8", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (m.find( )) {

         //  return obj.getAuthentication(uname, password);

        }
            return null;

    }
	
	

}
