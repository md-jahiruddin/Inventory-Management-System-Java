package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Supplier;

public class SupplierService {
	private Scanner sc;

    private ArrayList<Supplier> suppliers;
    
    private static final String DOUBLE_LINE = "================================================================================================================";

    private static final String SINGLE_LINE = "----------------------------------------------------------------------------------------------------------------";

    
    
    public SupplierService(Scanner sc)
    {
        this.sc = sc;
        suppliers = new ArrayList<>();
    }
    
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
	
	private Supplier findSupplierById(int supplierId)
	{
	    for(Supplier supplier : suppliers)
	    {
	        if(supplier.getSupplierId() == supplierId)
	        {
	            return supplier;
	        }
	    }

	    return null;
	}
	
	
		
	
	public void addSupplier()
	{
		printHeader("ADDING NEW SUPPLIER");
		
		System.out.print("Supplier ID : ");
		int SupplierId = Integer.parseInt(sc.nextLine());
		
		Supplier supplier = findSupplierById(SupplierId);
		
		if(supplier != null)
	    {
	            printStatus("ERROR", "Supplier ID already exists.");
	            return;
	    }
		
		System.out.print("Supplier Name : ");
		String supplierName = sc.nextLine();

		System.out.print("Phone : ");
		String phone = sc.nextLine();

		System.out.print("Email : ");
		String email = sc.nextLine();

		System.out.print("Address : ");
		String address = sc.nextLine();

		System.out.print("GST Number : ");
		String gstNumber = sc.nextLine();

		Supplier supplier1 = new Supplier(
		        SupplierId,
		        supplierName,
		        phone,
		        email,
		        address,
		        gstNumber);

		suppliers.add(supplier1);

		printStatus("SUCCESS", "Supplier Added Successfully.");
	}

	public void viewSuppliers()
	{
		printHeader("VIEW SUPPLIERS");
		
		if(suppliers.isEmpty())
		{
		    printStatus("INFO", "No Suppliers available.");
		    return;
		}
		
		System.out.printf(
		        "%-8s %-25s %-15s %-30s %-25s %-20s%n",
		        "ID",
		        "NAME",
		        "PHONE",
		        "EMAIL",
		        "ADDRESS",
		        "GST NO");
		
		printFooter();
		
		for(Supplier supplier : suppliers)
		{
			System.out.printf(
				    "%-8d %-25s %-15s %-30s %-25s %-20s%n",
				    supplier.getSupplierId(),
				    supplier.getSupplierName(),
				    supplier.getPhone(),
				    supplier.getEmail(),
				    supplier.getAddress(),
				    supplier.getGstNumber());
		}
		
		printFooter();
	}

	public void searchSupplier()
	{
		try
	    {
	        printHeader("SEARCH Supplier");

	        System.out.print("Supplier ID : ");
	        int SupplierId = Integer.parseInt(sc.nextLine());

	        Supplier Supplier = findSupplierById(SupplierId);

	        if(Supplier == null)
	        {
	            printStatus("ERROR", "Supplier Not Found.");
	            return;
	        }

	        printStatus("SUCCESS", "Supplier Found.");

	        System.out.printf(
			        "%-8s %-25s %-15s %-30s %-25s %-20s%n",
			        "ID",
			        "NAME",
			        "PHONE",
			        "EMAIL",
			        "ADDRESS",
			        "GST NO");

	        printFooter();
	        for(Supplier supplier : suppliers)
			{
	        	System.out.printf(
	        		    "%-8d %-25s %-15s %-30s %-25s %-20s%n",
	        		    supplier.getSupplierId(),
	        		    supplier.getSupplierName(),
	        		    supplier.getPhone(),
	        		    supplier.getEmail(),
	        		    supplier.getAddress(),
	        		    supplier.getGstNumber());
			}
	        
	        printFooter();
	    }
	    catch(Exception e)
	    {
	        printStatus("ERROR", e.getMessage());
	    }  
	}

	public void updateSupplier()
	{
		try
		{
			printHeader("UPDATE Supplier");
			
			System.out.print("Supplier ID : ");
			int SupplierId = Integer.parseInt(sc.nextLine());

			Supplier supplier = findSupplierById(SupplierId);

			if(supplier == null)
			{
			    printStatus("ERROR", "Supplier Not Found.");
			    return;
			}
			
			System.out.print("Supplier Name : ");
			String supplierName = sc.nextLine();

			System.out.print("Phone : ");
			String phone = sc.nextLine();

			System.out.print("Email : ");
			String email = sc.nextLine();

			System.out.print("Address : ");
			String address = sc.nextLine();

			System.out.print("GST Number : ");
			String gstNumber = sc.nextLine();
			
			supplier.setSupplierId(SupplierId);
	        supplier.setSupplierName(supplierName);
	        supplier.setPhone(phone);
	        supplier.setEmail(email);
	        supplier.setAddress(address);
	        supplier.setGstNumber(gstNumber);
			
			printStatus("SUCCESS", "Supplier Updated Successfully.");
		}
		catch(Exception e)
		{
		    printStatus("ERROR", e.getMessage());
		}
	}

	public void deleteSupplier()
	{
		 try
		 {
			 printHeader("DELETE Supplier");
			 
			 System.out.print("Supplier ID : ");
			 int supplierId = Integer.parseInt(sc.nextLine());

			 Supplier supplier = findSupplierById(supplierId);

			 if(supplier == null)
			 {
			     printStatus("ERROR", "Supplier Not Found.");
			     return;
			 }
			 
			 System.out.print("\nAre you sure you want to delete this Supplier? (Y/N) : ");

			 char choice = sc.nextLine().toUpperCase().charAt(0);
			 
			 if(choice == 'Y')
			 {
			     suppliers.remove(supplier);

			     printStatus("SUCCESS", "Supplier Deleted Successfully.");
			 }
			 else
			 {
			     printStatus("INFO", "Delete Operation Cancelled.");
			 }
		 }
		 catch(Exception e)
		 {
		     printStatus("ERROR", e.getMessage());
		 }

	}
	
}
