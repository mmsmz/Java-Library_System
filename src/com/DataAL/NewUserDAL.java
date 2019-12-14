package com.DataAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.BusinessAL.NewUserBAL;

public class NewUserDAL implements DataAccess{
	
	private static final NewUserBAL NewUserBAL = null;
	Connection conn;
	
	public NewUserDAL(){
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

	public int add(Object adding) {
		  int result=0;
		  
		  	NewUserBAL lg = (NewUserBAL) adding;

	        String insert="insert into login_tabl(username,password,type) values(?,?,?)";
	        try{
	            PreparedStatement ps=conn.prepareStatement(insert);
	            ps.setString(1, lg.getUsername());
	            ps.setString(2, lg.getPassword());           
	            ps.setString(3, lg.getUserType());            
	            result=ps.executeUpdate();
	            ps.close();
	            return result;
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, e.getMessage());
	            return result;
	        }
	}

	@Override
	public int update(int update) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int delete) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
