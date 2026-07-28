package menu;

import java.util.Scanner;

import service.InventoryService;

import service.SupplierService;

import service.LoginService;

public class Menu
{
	
	private Scanner sc;
	
	private LoginService loginService;
	
	private SupplierService supplierService;
	
	private static final String DOUBLE_LINE = "================================================================================================================";
	
	private static final String SINGLE_LINE = "----------------------------------------------------------------------------------------------------------------";
	
	private InventoryService inventoryService;
	
	
	/**===========================================================================
	 * 
	 * UI  HELPERS
	 * 
	 * ===========================================================================
	 * */
	
	
	
	private void printHeader(String title)
	{
	    System.out.println("\n"+SINGLE_LINE);
	    System.out.printf("      %s%n", title);
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
	
	
	private void waitForEnter()
	{
	    System.out.print("\nPress Enter to continue...");
	    sc.nextLine();
	}
	
	
	
	private int getChoice()
	{
	    System.out.print("\nEnter Choice : ");

	    try
	    {
	        return Integer.parseInt(sc.nextLine());
	    }
	    catch(NumberFormatException e)
	    {
	    	printStatus("ERROR", "Please enter a valid number.");
	    	
	        return -1;
	    }
	}
	
	
	
	public Menu(Scanner sc)
	{
		this.sc = sc;
		
		loginService = new LoginService(sc);
		
		inventoryService = new InventoryService(sc); 
		
		supplierService = new SupplierService(sc);
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
	    	
	    	
	    	try
	    	{
	    		int userChoice = getChoice();;
	    		
	    		if(userChoice == -1)
	    		{
	    		    waitForEnter();
	    		    continue;
	    		}
	    		
	    		switch(userChoice)
	    		{
	    		
	    		case 1:									 //Login
	    			if(loginService.login())
	    			{
	    				System.out.println();
	    				printStatus("SUCCESS", "Login Successful");
	    				
	    				adminDashboard();
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
	    	
	    	
	    	catch(Exception e)
	    	{
	    		System.out.println();
	    	    printStatus("ERROR", "Unexpected Error : " + e.getMessage());
	    	}
	    	
	    }
	}
	
	private void adminDashboard()
	{
		
		boolean loggedIn = true;
		
		while(loggedIn)
		{
			printHeader("ADMIN DASHBOARD");
			
			 System.out.println("1. Product Management");
		     System.out.println("2. Supplier Management");
		     System.out.println("3. Inventory Management");
		     System.out.println("4. Reports");
		     System.out.println("5. Change Password");
		     System.out.println("6. Logout");
			
			printFooter();
			
			
			try
			{
				int choice = getChoice();
				
				if(choice == -1)
				{
				    waitForEnter();
				    continue;
				}
				
				switch(choice)
				{
				
				case 1:
					productMenu();
					break;
					
				case 2:
					supplierMenu();
					waitForEnter();
                    break;

                case 3:
                    inventoryMenu();
                    waitForEnter();
                    break;

                case 4:
                    reportsMenu();
                    waitForEnter();
                    break;

                case 5:
                	loginService.changePassword();
                    waitForEnter();
                    break;

                case 6:
                    printStatus("LOGOUT",
                            "Logged Out Successfully.");

                    loggedIn = false;
                    break;

                default:
                    printStatus("ERROR",
                            "Invalid Menu Choice.");
				
				}
			}
			
			catch(NumberFormatException e)
			{
				printStatus("ERROR", "Please enter a valid number.");
			}
			
		}
	}
	
	
	private void productMenu()
	{
		boolean running = true;
		
		while(running)
		{
			printHeader("PRODUCT MANAGEMENT");
			
			System.out.println("1. Add Product");
			System.out.println("2. View Products");
			System.out.println("3. Search Product");
			System.out.println("4. Update Product");
			System.out.println("5. Delete Product");
			System.out.println("6. Back");
			
			printFooter();
			
			try
			{
				int choice = getChoice();
				
				if(choice == -1)
				{
				    waitForEnter();
				    continue;
				}
				
				switch(choice)
				{
				case 1:
					inventoryService.addProduct();
					waitForEnter();
					break;
					
				case 2:
                    inventoryService.viewProducts();
                    waitForEnter();
                    break;

                case 3:
                    inventoryService.searchProduct();
                    waitForEnter();
                    break;

                case 4:
                    inventoryService.updateProduct();
                    waitForEnter();
                    break;

                case 5:
                    inventoryService.deleteProduct();
                    waitForEnter();
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    printStatus("ERROR", "Invalid Menu Choice.");
                    waitForEnter();
				}
			}
			catch(Exception e)
			{
				printStatus("ERROR", "Unexpected Error : " + e.getMessage());
				waitForEnter();
			}
			
		}
	}
	
	private void supplierMenu()
	{
		boolean running = true;
		
		while(running)
		{
			printHeader("SUPPLIER MANAGEMENT");
			
			System.out.println("1. Add Supplier");
			System.out.println("2. View Suppliers");
			System.out.println("3. Search Supplier");
			System.out.println("4. Update Supplier");
			System.out.println("5. Delete Supplier");
			System.out.println("6. Back");
			
			printFooter();
			
			try
			{
				int choice = getChoice();
				
				if(choice == -1)
				{
				    waitForEnter();
				    continue;
				}
				
				switch(choice)
				{
				case 1:
					supplierService.addSupplier();
					waitForEnter();
					break;
					
				case 2:
					supplierService.viewSuppliers();
                    waitForEnter();
                    break;

                case 3:
                	supplierService.searchSupplier();
                    waitForEnter();
                    break;

                case 4:
                	supplierService.updateSupplier();
                    waitForEnter();
                    break;

                case 5:
                	supplierService.deleteSupplier();
                    waitForEnter();
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    printStatus("ERROR", "Invalid Menu Choice.");
                    waitForEnter();
				}
			}
			catch(Exception e)
			{
				printStatus("ERROR", "Unexpected Error : " + e.getMessage());
				waitForEnter();
			}
			
		}
	}
	
	
	
	private void inventoryMenu()
	{
	    boolean running = true;

	    while(running)
	    {
	        printHeader("INVENTORY MANAGEMENT");

	        System.out.println("1. Stock In");
	        System.out.println("2. Stock Out");
	        System.out.println("3. Low Stock Report");
	        System.out.println("4. Back");

	        printFooter();

	        try
	        {
	            int choice = getChoice();

	            if(choice == -1)
	            {
	                waitForEnter();
	                continue;
	            }

	            switch(choice)
	            {
	            case 1:
	                inventoryService.stockIn();
	                waitForEnter();
	                break;

	            case 2:
	                inventoryService.stockOut();
	                waitForEnter();
	                break;

	            case 3:
	                inventoryService.lowStockReport();
	                waitForEnter();
	                break;

	            case 4:
	                running = false;
	                break;

	            default:
	                printStatus("ERROR", "Invalid Menu Choice.");
	                waitForEnter();
	            }
	        }
	        catch(Exception e)
	        {
	            printStatus("ERROR", e.getMessage());
	            waitForEnter();
	        }
	    }
	}
	
	private void reportsMenu()
	{
	    boolean running = true;

	    while(running)
	    {
	        printHeader("REPORTS");

	        System.out.println("1. Total Products");
	        System.out.println("2. Low Stock Report");
	        System.out.println("3. Back");

	        printFooter();

	        try
	        {
	            int choice = getChoice();

	            if(choice == -1)
	            {
	                waitForEnter();
	                continue;
	            }

	            switch(choice)
	            {
	                case 1:
	                    inventoryService.totalProducts();
	                    waitForEnter();
	                    break;

	                case 2:
	                    inventoryService.lowStockReport();
	                    waitForEnter();
	                    break;

	                case 3:
	                    running = false;
	                    break;

	                default:
	                    printStatus("ERROR", "Invalid Menu Choice.");
	                    waitForEnter();
	            }
	        }
	        catch(Exception e)
	        {
	            printStatus("ERROR", e.getMessage());
	            waitForEnter();
	        }
	    }
	}
	
}