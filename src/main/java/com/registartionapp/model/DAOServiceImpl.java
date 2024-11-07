package com.registartionapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
   private Connection con;
   private Statement stmnt;
	@Override
	public void connectDB() {
      try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cust_reg_db","root","1234");
		stmnt = con.createStatement();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
		    return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
           	try {
				stmnt.executeUpdate("insert into registartion values('"+name+"','"+city+"','"+email+"','"+mobile+"')")	;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public ResultSet listAllReg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registartion");
		  return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
       		
	}

	@Override
	public void deleteByEmail(String email) {
     try {
		stmnt.executeUpdate("delete from registartion where email='"+email+"'");
	} catch (SQLException e) {
		e.printStackTrace();
	}		
	}

	@Override
	public void updateRegistartion(String email, String mobile) {
      try {
		stmnt.executeUpdate("update registartion set mobile='"+mobile+"' where email='"+email+"'")	;
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	}

}
