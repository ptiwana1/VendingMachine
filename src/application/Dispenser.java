package application;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.Arrays;


public class Dispenser {

	private float cashInput;
	private static boolean paymentAccepted;
	private static boolean paymentTypeIsCash;
	private float change;
	static Scanner keyboard = new Scanner(System.in);
	private Product[] products = new Product[10];
	
	
	/*
	 * Main method 
	 * @param String[] args
	 */
	public static void main(String[] args) {
		Dispenser d = new Dispenser();
		//String product = keyboard.nextLine();
		//display the products for the user to select
		// Display welcome screen, product selection and checkout
		
	}
	
	/**
	 * Displaying the checkout questions
	 * @return paymentTypeIsCash
	 */
	public boolean displayCheckout()
	{
		while (paymentAccepted != true) {
			System.out.println(" Payment cash or card? ");
			String paymentType = keyboard.nextLine();
				if (paymentType.equalsIgnoreCase("cash")) {
					paymentTypeIsCash = true;
			paymentAccepted = true;
			System.out.println("Insert cash now");
		}
		
				else if (paymentType.equalsIgnoreCase("card")) {
					paymentTypeIsCash = false;
			paymentAccepted = true;
			System.out.println("Insert card now");
		}
		
				else {
			paymentAccepted = false;
			System.out.println("Invalid type, must be cash or card");
		}
		}
		return paymentTypeIsCash;
	}
	
	
	/*
	 * Set the cash input to dispenser
	 */
	public void setPayment(double cashInput)
	{
		
	}
	
	/*
	 * Get payment from customer
	 */
	public void getPayment(Product p) {
		if (paymentTypeIsCash = true) {
			System.out.println("How much cash are you putting in?");
			Float cashInput = keyboard.nextFloat();
			if (cashInput > p.getPrice()) {
				
			}
		}
		else if (paymentTypeIsCash = false) {
			paymentAccepted = true;
		}
	}
	
	/*
	 * Dispenser constructor method default
	 */
	public Dispenser() {
		this.cashInput = cashInput;
		this.change = change;
		this.paymentAccepted = paymentAccepted;
		this.paymentTypeIsCash = paymentTypeIsCash;
	}
	
	//Checkout Screen
	public static GridPane checkOut()
    {
    	GridPane checkout = new GridPane();
        checkout.setAlignment(Pos.CENTER);
        checkout.setVgap(10);
        checkout.setHgap(100);
        
        Label items = new Label("Items for checkout");
        items.setTextFill(Color.web("WHITE"));
    	items.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        checkout.add(items, 0, 0);
        
        Label price = new Label("Price");
        price.setTextFill(Color.web("WHITE"));
    	price.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        checkout.add(price, 1, 0);
        
        float total_price = 0f;
        for(int i=0;i<Main.stacklist.size();i++)// using for loop to get list of selected products 
        {
        	Label label = new Label(Main.stacklist.get(i).name);
        	label.setTextFill(Color.web("WHITE"));
        	label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
        	checkout.add(label, 0, i+1);
        	
        	total_price += Main.stacklist.get(i).getPrice();
        	Label labelprice = new Label("$"+Float.toString(Main.stacklist.get(i).getPrice()));
        	
        	labelprice.setTextFill(Color.web("RED"));
        	labelprice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
        	checkout.add(labelprice, 1, i+1);
        }
        Label total = new Label("Total");
        total.setTextFill(Color.web("WHITE"));
    	total.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 24));
        checkout.add(total, 0, Main.stacklist.size()+1);
        
        total_price = Math.round(total_price * 100.0f)/100.0f;// rounding upto 2 points 
        Label totalPrice = new Label("$"+Float.toString(total_price));// converting back to string
        totalPrice.setTextFill(Color.web("RED"));
        totalPrice.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        checkout.add(totalPrice, 1, Main.stacklist.size()+1);
        
        final Button button = new Button("Done");// creating done button 
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
            	Main.stacklist.clear();
            	button.getScene().setRoot(Main.root);  // when done button is clicked will go to front of  the application        
            }
        });
        checkout.setStyle("-fx-background-color: purple;");
        checkout.add(button, 1, Main.stacklist.size() + 3);
       return checkout;
   }
	/*
	 * Get price
	 */
	public float getPrice(Product product) {
		return product.getPrice();
	}
	
	/*
	 * Print receipt
	 */
	public void printReceipt() {
		
	}
	
	/*
	 * Set change amount
	 */
	public void setChange(float change) {
		
	}
	
	/*
	 * Get the change amount
	 */
	public void getChange() {
		
	}
	
	/*
	 * 
	 */
	public void dispenseChange() {
		
	}
	
	/*
	 * 
	 */
	public void dispenseProduct() {
		
	}

	
}
