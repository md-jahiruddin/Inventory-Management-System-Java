package menu;

import java.util.Scanner;

import service.LoginService;

public class Menu
{
	
	private Scanner sc;
	
	private LoginService loginService;
	
	private static final String DOUBLE_LINE = "================================================";
	
	private static final String SINGLE_LINE = "------------------------------------------------";
	
	
	
	/**===========================================================================
	 * 
	 * UI  HELPERS
	 * 
	 * ===========================================================================
	 * */
	
	
	
	private void printHeader(String title)
	{
	    System.out.println("\n"+SINGLE_LINE);
	    System.out.printf("                    %s%n", title);
	    System.out.println(SINGLE_LINE);
	}
	
	
	
	/**-------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------
	*/
	
	
	
	private void printFooter()
	{
	    System.out.println(SINGLE_LINE);
	}
	
	
	
	/**-------------------------------------------------------------------------------------------------------------------------------------
	----------------------------------------------------------------------------------------------------------------------------------------
	*/
	
	
	
	
	
	private void printStatus(String type, String message)
	{
	    System.out.println("\n"+DOUBLE_LINE);
	    System.out.println();
	    System.out.printf("%-10s : %s%n", type, message);
	    System.out.println();
	    System.out.println(DOUBLE_LINE);
	}
	
	
	
	public Menu(Scanner sc)
	{
		this.sc = sc;
		
		loginService = new LoginService(sc);
	}
	
	
	
	/*
	 * ===============================================
	 * MENU LOOP
	 * ===============================================
	 */
	
	
	
	public void start()
	{
	    boolean running = true;
	    
	    while(running)
	    {
	    	
	    	printHeader("INVENTORY MANAGEMENT SYSTEM");
	    	
	    	System.out.println("1. Login");
	    	System.out.println("2. Exit");

	    	printFooter();
	    	
	    	System.out.print("\nEnter Choice : ");
	    	
	    	try
	    	{
	    		int userChoice = Integer.parseInt(sc.nextLine());
	    		
	    		switch(userChoice)
	    		{
	    		
	    		case 1:									 //Login
	    			if(loginService.login())
	    			{
	    				System.out.println();
	    				printStatus("SUCCESS", "Login Successful");
	    			}
	    			
	    			else
	    			{
	    				System.out.println();	    				
	    				printStatus("ERROR", "Invalid Username or Password");
	    				
	    			}
	    			
	    			break;
	    			
	    			
	    		case 2:
	    			System.out.println();
	    			printStatus("EXIT", "Thank you for using Inventory Management System.");
	    			running = false;
	    			break;
	    			
	    			
	    			default:
	    				System.out.println();
	    				printStatus("ERROR", "Invalid Menu Choice.");
	    		}
	    	}
	    	
	    	catch(NumberFormatException e)
	    	{
	    		System.out.println();
	    	    printStatus("ERROR", "Please enter a valid number.");
	    	}
	    	
	    	catch(Exception e)
	    	{
	    		System.out.println();
	    	    printStatus("ERROR", "Unexpected Error : " + e.getMessage());
	    	}
	    	
	    }
	}
	
}