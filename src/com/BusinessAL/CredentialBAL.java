package com.BusinessAL;

import com.DataAL.CredantialsDAL;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CredentialBAL {
    static ResultSet rs;
    static Statement st;

    public static CredentialVal passwordVal(Optional<String> uname, Optional<String> password) {

        CredantialsDAL obj = new CredantialsDAL();
        String p = password.toString();
        String s1 = uname.toString();
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

           return obj.getAuthentication(uname, password);

        }
            return null;

    }

}
