package com.registartionapp.model;

import java.sql.ResultSet;

//Abstraction
public interface DAOService {
    public void connectDB();
    public boolean verifyCredentials(String email,String password);
	public void saveRegistration(String name, String city, String email, String mobile);
	public ResultSet listAllReg();
	public void deleteByEmail(String email);
	public void updateRegistartion(String email, String mobile);
}
