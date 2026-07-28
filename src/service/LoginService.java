package service;

import java.util.Scanner;

import model.Admin;

public class LoginService
{
	
	private Scanner sc;

	private Admin admin;
	
	private static final String DOUBLE_LINE = "================================================================================================================";

	private static final String SINGLE_LINE = "----------------------------------------------------------------------------------------------------------------";
	
	
	
	
	private void printHeader(String title)
	{
	    System.out.println("\n" + SINGLE_LINE);
	    System.out.printf("      %s%n", title);
	    System.out.println(SINGLE_LINE);
	}

	private void printFooter()
	{
	    System.out.println(SINGLE_LINE);
	}

	private void printStatus(String type, String message)
	{
	    System.out.println("\n" + DOUBLE_LINE);
	    System.out.println();
	    System.out.printf("%-10s : %s%n", type, message);
	    System.out.println();
	    System.out.println(DOUBLE_LINE);
	}
	
	
	
	public LoginService(Scanner sc)
	{
	    this.sc = sc;
	    admin = new Admin(1, "admin" , "admin123");
	}
	
	public boolean login()
	{
	    printHeader("ADMIN LOGIN");

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

	            printStatus("ERROR",
	                    "Invalid Username or Password. Attempts Left : " + attempts);
	        }
	    }

	    return false;
	}
	
	public void changePassword()
	{
	    try
	    {
	    	printHeader("CHANGE PASSWORD");

	        System.out.print("Enter Current Password : ");
	        String currentPassword = sc.nextLine();

	        if(!admin.validatePassword(currentPassword))
	        {
	        	printStatus("ERROR", "Invalid Current Password.");
	            return;
	        }

	        System.out.print("Enter New Password : ");
	        String newPassword = sc.nextLine();

	        System.out.print("Confirm New Password : ");
	        String confirmPassword = sc.nextLine();

	        if(!newPassword.equals(confirmPassword))
	        {
	        	printStatus("ERROR", "Passwords do not match.");
	            return;
	        }
	        
	        if(newPassword.length() < 6)
	        {
	        	printStatus("ERROR", "Password should contain at least 6 characters.");
	            return;
	        }

	        admin.setPassword(newPassword);

	        printStatus("SUCCESS", "Password Changed Successfully.");
	    }
	    catch(Exception e)
	    {
	    	printStatus("ERROR", "Unexpected Error : " + e.getMessage());
	    }
	}	
}