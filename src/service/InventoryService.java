package service;

import java.util.ArrayList;
import java.util.Scanner;

import model.Product;

public class InventoryService {

	private Scanner sc;
	
	private ArrayList<Product> products;
	
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
	
	
	public InventoryService(Scanner sc)
	{
		this.sc = sc;
		
		products = new ArrayList<>();
	}
	
	
	
	private Product findProductById(int productId)
	{
		for(Product p : products)
	    {
	        if(p.getProductId() == productId)
	        {
	            return p;
	        }
	    }
		
		return null;
	}
	
	
	public void addProduct()
	{
		printHeader("ADDING NEW PRODUCT");
		
		System.out.print("Product ID : ");
		int productId = Integer.parseInt(sc.nextLine());
		
		Product product = findProductById(productId);
		
		if(product != null)
	    {
	            printStatus("ERROR", "Product ID already exists.");
	            return;
	    }
		
		System.out.print("Product Name : ");
	    String productName = sc.nextLine();

	    System.out.print("Category : ");
	    String category = sc.nextLine();

	    System.out.print("Quantity : ");
	    int quantity = Integer.parseInt(sc.nextLine());

	    System.out.print("Price : ");
	    double price = Double.parseDouble(sc.nextLine());

	    System.out.print("Supplier ID : ");
	    int supplierId = Integer.parseInt(sc.nextLine());
	      
	    Product product1 = new Product(
	            productId,
	            productName,
	            category,
	            quantity,
	            price,
	            supplierId);
	    
	    products.add(product1);
	    
	    printStatus("SUCCESS", "Product Added Successfully.");
	}

	public void viewProducts()
	{
		printHeader("VIEW PRODUCTS");
		
		if(products.isEmpty())
		{
		    printStatus("INFO", "No products available.");
		    return;
		}
		
		System.out.printf("%-8s %-25s %-20s %-10s %-15s %-12s%n",
		        "ID",
		        "NAME",
		        "CATEGORY",
		        "QTY",
		        "PRICE",
		        "SUPPLIER ID");
		
		printFooter();
		
		for(Product product : products)
		{
			System.out.printf("%-8d %-25s %-20s %-10d ₹%-14.2f %-12d%n",
			        product.getProductId(),
			        product.getProductName(),
			        product.getCategory(),
			        product.getQuantity(),
			        product.getPrice(),
			        product.getSupplierId());
		}
		
		printFooter();
	}

	public void searchProduct()
	{
		try
	    {
	        printHeader("SEARCH PRODUCT");

	        System.out.print("Product ID : ");
	        int productId = Integer.parseInt(sc.nextLine());

	        Product product = findProductById(productId);

	        if(product == null)
	        {
	            printStatus("ERROR", "Product Not Found.");
	            return;
	        }

	        printStatus("SUCCESS", "Product Found.");

	        System.out.printf("%-8s %-20s %-18s %-8s %-15s %-10s%n",
	                "ID",
	                "NAME",
	                "CATEGORY",
	                "QTY",
	                "PRICE",
	                "SUPPLIER ID");

	        printFooter();

	        System.out.printf("%-8d %-20s %-18s %-8d ₹%-14.2f %-10d%n",
	                product.getProductId(),
	                product.getProductName(),
	                product.getCategory(),
	                product.getQuantity(),
	                product.getPrice(),
	                product.getSupplierId());
	        
	        printFooter();
	    }
	    catch(Exception e)
	    {
	        printStatus("ERROR", e.getMessage());
	    }  
	}

	public void updateProduct()
	{
		try
		{
			printHeader("UPDATE PRODUCT");
			
			System.out.print("Product ID : ");
			int productId = Integer.parseInt(sc.nextLine());

			Product product = findProductById(productId);

			if(product == null)
			{
			    printStatus("ERROR", "Product Not Found.");
			    return;
			}
			
			System.out.print("New Product Name : ");
			String productName = sc.nextLine();

			System.out.print("New Category : ");
			String category = sc.nextLine();

			System.out.print("New Quantity : ");
			int quantity = Integer.parseInt(sc.nextLine());

			System.out.print("New Price : ");
			double price = Double.parseDouble(sc.nextLine());

			System.out.print("New Supplier ID : ");
			int supplierId = Integer.parseInt(sc.nextLine());
			
			product.setProductName(productName);
			product.setCategory(category);
			product.setQuantity(quantity);
			product.setPrice(price);
			product.setSupplierId(supplierId);
			
			printStatus("SUCCESS", "Product Updated Successfully.");
		}
		catch(Exception e)
		{
		    printStatus("ERROR", e.getMessage());
		}
	}

	public void deleteProduct()
	{
		 try
		 {
			 printHeader("DELETE PRODUCT");
			 
			 System.out.print("Product ID : ");
			 int productId = Integer.parseInt(sc.nextLine());

			 Product product = findProductById(productId);

			 if(product == null)
			 {
			     printStatus("ERROR", "Product Not Found.");
			     return;
			 }
			 
			 System.out.print("\nAre you sure you want to delete this product? (Y/N) : ");

			 char choice = sc.nextLine().toUpperCase().charAt(0);
			 
			 if(choice == 'Y')
			 {
			     products.remove(product);

			     printStatus("SUCCESS", "Product Deleted Successfully.");
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
	
	
	
	
	public void stockIn()
	{
		try
		{
			printHeader("STOCK IN");
			
			System.out.print("Product ID : ");
			int productId = Integer.parseInt(sc.nextLine());
			
			Product product = findProductById(productId);
			
			if(product == null)
			{
				printStatus("ERROR", "Product Not Found.");
				return;
			}
			
			System.out.print("Quantity to Add : ");
	        int quantity = Integer.parseInt(sc.nextLine());

	        product.setQuantity(product.getQuantity() + quantity);

	        printStatus("SUCCESS", "Stock Updated Successfully.");
	    }
	    catch(Exception e)
	    {
	        printStatus("ERROR", e.getMessage());
	    }
			
			
	}

	public void stockOut()
	{
	    try
	    {
	        printHeader("STOCK OUT");

	        System.out.print("Product ID : ");
	        int productId = Integer.parseInt(sc.nextLine());

	        Product product = findProductById(productId);

	        if(product == null)
	        {
	            printStatus("ERROR", "Product Not Found.");
	            return;
	        }

	        System.out.print("Quantity to Remove : ");
	        int quantity = Integer.parseInt(sc.nextLine());

	        if(quantity > product.getQuantity())
	        {
	            printStatus("ERROR", "Insufficient Stock.");
	            return;
	        }

	        product.setQuantity(product.getQuantity() - quantity);

	        printStatus("SUCCESS", "Stock Updated Successfully.");
	    }
	    catch(Exception e)
	    {
	        printStatus("ERROR", e.getMessage());
	    }
	}

	public void lowStockReport()
	{
	    printHeader("LOW STOCK REPORT");

	    if(products.isEmpty())
	    {
	        printStatus("INFO", "No products available.");
	        return;
	    }

	    System.out.printf("%-8s %-25s %-20s %-10s %-15s %-12s%n",
	            "ID",
	            "NAME",
	            "CATEGORY",
	            "QTY",
	            "PRICE",
	            "SUPPLIER ID");

	    printFooter();

	    boolean found = false;

	    for(Product product : products)
	    {
	        if(product.getQuantity() < 10)
	        {
	            System.out.printf("%-8d %-25s %-20s %-10d ₹%-14.2f %-12d%n",
	                    product.getProductId(),
	                    product.getProductName(),
	                    product.getCategory(),
	                    product.getQuantity(),
	                    product.getPrice(),
	                    product.getSupplierId());

	            found = true;
	        }
	    }

	    if(!found)
	    {
	        printStatus("INFO", "No Low Stock Products.");
	    }
	    else
	    {
	        printFooter();
	    }
	}
	
	
	public void totalProducts()
	{
	    printHeader("TOTAL PRODUCTS");

	    printStatus("INFO",
	            "Total Products : " + products.size());
	}
	
	
}
