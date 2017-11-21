package application;

import java.text.DecimalFormat;

public abstract class Product implements Comparable<Product>{
	protected String name;
	private int productID;
	private float price;
	private int stock;
	protected final String errorMessage = "There is an error. Contact an administrator.";
	
	/*
	 * setter for price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/*
	 * getter for price
	 */
	public float getPrice() {
		return price;
	}

	/*
	 * setter for stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/*
	 * getter for stock
	 */
	public int getStock() {
		return stock;
	}

	/*
	 * setter for product id
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/*
	 * getter for product id
	 */
	public int getProductID() {
		return productID;
	}

	/*
	 * constructor for product
	 */
	public Product() {
		
	}

	/*
	 * Copy constructor for product
	 */
	public Product(String name, int productID, float price, int stock) {
		this.name = name;
		this.price = price;
		this.productID = productID;
		this.stock = stock;

	}

	/*
	 * Product constructor overridden
	 */
	public Product(Product p) {
		this(p.getName(), p.getProductID(), p.getPrice(), p.getStock());
	}

	/*
	 * to string method
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return this.name + " - $" + df.format(this.price);
	}

	/*
	 * Setter for name
	 */
	public void setName(String name) {

	}

	/*
	 * Getter for name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * compare to method to compare the names and sort by them.
	 */
	public int compareTo(Product p) {
		
		int value = this.name.compareToIgnoreCase(p.name);
		return value;
	}
}

