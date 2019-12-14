package com.DataAL;

import java.util.ArrayList;

public interface DataAccess {
	
	//int add(String add);
	int update(int update);
	int delete(int delete);
	ArrayList<Object> getAll(); // to display all the data 
	int add(Object adding);
	
	 
	
	
}
