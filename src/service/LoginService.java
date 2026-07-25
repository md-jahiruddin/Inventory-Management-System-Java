package service;

import java.util.Scanner;

import model.Admin;

public class LoginService
{
	
	private Scanner sc;

	private Admin admin = new Admin(1, "admin" , "admin123");
	
	
	
	public LoginService(Scanner sc)
	{
	    this.sc = sc;
	}
	
	public boolean login()
	{
		return false;
	}
	
	public void changePassword()
	{
		
	}	
}