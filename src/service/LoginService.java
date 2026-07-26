package service;

import java.util.Scanner;

import model.Admin;

public class LoginService
{
	
	private Scanner sc;

	private Admin admin;
	
	
	
	public LoginService(Scanner sc)
	{
	    this.sc = sc;
	    admin = new Admin(1, "admin" , "admin123");
	}
	
	public boolean login()
	{
		
		System.out.println("\n==========================================");
		System.out.println("            ADMIN LOGIN");
		System.out.println("==========================================");
		
		int attempts = 3;
		
		while(attempts > 0)
		{
			System.out.print("\nUsername : ");
			String username = sc.nextLine();
			
			System.out.print("\nPassword : ");
			String password = sc.nextLine();
			
			if(username.equals(admin.getUsername()) && 
					admin.validatePassword(password))
			{
				return true;
			}
			
			else
			{
				attempts--;
				System.out.println("\nInvalid Username or Password.");
				System.out.println("Attempts Left : " + attempts);
				
			}
		}
		return false;
	}
	
	public void changePassword()
	{
		
	}	
}