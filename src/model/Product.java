package model;

public class Product
{
	
	private int productId;
	
	private String productName;
	
	private String category;
	
	private int quantity;
	
	private double price;
	
	private int supplierId;
	
	
	public Product()
	{
		
	}
	
	public Product(int productId, String productName, 
			String category, int quantity, double price, int supplierId)
	{
		
		this.productId = productId;
		
		this.productName = productName;
		
		this.category = category;
		
		this.quantity = quantity;
		
		this.price = price;
		
		this.supplierId = supplierId;
		
	}
	
	 public int getProductId() {
	        return productId;
	    }

	    public void setProductId(int productId) {
	        this.productId = productId;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public int getSupplierId() {
	        return supplierId;
	    }

	    public void setSupplierId(int supplierId) {
	        this.supplierId = supplierId;
	    }

	    @Override
	    public String toString() {
	        return "\n=============================="
	                + "\nProduct ID   : " + productId
	                + "\nName         : " + productName
	                + "\nCategory     : " + category
	                + "\nQuantity     : " + quantity
	                + "\nPrice        : ₹" + String.format("%.2f", price)
	                + "\nSupplier ID  : " + supplierId
	                + "\n==============================";
	    }
	
}