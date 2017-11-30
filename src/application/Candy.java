package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Candy extends Snack {
	
	public static  Global_Inventory_Management inventory = new Global_Inventory_Management();
	static Product Kisses = null;
	static Product payDay = null;
	// copy Constructor for candy
	public Candy(Candy c) {
		super(c);
	}
	
	// Constructor for candy
	public Candy() {
		super();
	}
	
	// Constructor for candy as a subclass of snack  and product
	public Candy(String name, int productID, float price, int stock) {
		super(name, productID, price, stock);
	}
	
	// toString method 
	public String toString() {
		return "Candies";
	}
	
	
	//Creating a screen to display available candies 
    public  static VBox CandyScreen()
    {
    		VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        Text title = new Text("Please choose your candy ");
    		title.setFill(Color.web("YELLOW"));
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
        vBox.getChildren().add(title);
        
        //Assigning a button to candy payday
        Button payday = new Button("Pay Day");
        //aDDING an image of payday candy to the button
        Image imagepayday = new Image("./application/images/payday.jpg");
		ImageView imageViewpayday = new ImageView(imagepayday);
		imageViewpayday.setFitHeight(100);
		imageViewpayday.setFitWidth(100);
		payday.setGraphic(imageViewpayday);
		payday.setMaxWidth(200);
		payday.setText("PayDay"+"\n Calories: 120" + "\n Price: 2.90" );
		payday.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		//Setting an event handler on button click to add a candy for check out
		payday.setOnMouseClicked(new EventHandler<MouseEvent>() {
		
			@Override
			public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				if(button==MouseButton.PRIMARY){
					if(inventory.CandyPayday.getStock() > 0)
					{
						// Creating object of new candy payday
					    payDay = new Candy();
						payDay.name = "PayDay";
						payDay.setPrice(1.67f);
						Main.stacklist.push(payDay);
						//Calling the stock method of Inventory class to decrease the stock of candy payday by 1
						inventory.stock(payDay);
					}
					else
					{
						//Alerting the user if the payday candy is out of stock
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Important Information");				
						alert.setContentText("Candy Pay Day is Out of Stock");
						alert.showAndWait();
					}			   
                }
				//Adding second event handler; changing the background color of button to yellow on double click
				else if(button==MouseButton.SECONDARY){
            		payday.setStyle("-fx-background-color: yellow");
                }
				
			}
			
		});
		// creating new button for kisses candy
		Button kisses = new Button("Kisses");
        //Adding an image to the kisses candy button
        Image imagekisses = new Image("./application/images/kisses.jpg");//getting image path
		ImageView imageViewkisses = new ImageView(imagekisses);// setting image view 
		imageViewkisses.setFitHeight(100);// setting image view height
		imageViewkisses.setFitWidth(100);// setting image view width
		kisses.setGraphic(imageViewkisses);// setting image in a button 
		kisses.setMaxWidth(200);// button width
		kisses.setText(" Kisses"+"\n Calories: 120" + "\n Price: 2.59" );// displaying price, name and clories 
		kisses.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));// setting fonts
		
		// creating event handler for the button click
		kisses.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				if(button==MouseButton.PRIMARY){
					if(inventory.CandyKisses.getStock() > 0)
					{
					// TODO Auto-generated method stub
					Kisses = new Candy();// creating object of new candy kisses
					Kisses.name = "Kisses";
					Kisses.setPrice(2.59f);
					Main.stacklist.push(Kisses);
					inventory.stock(Kisses);//Calling the stock method of Inventory class to decrease the stock of candy kisses by 1
					}
					
					else // creating a alert box for out of stock
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Important Information");
						
						alert.setContentText("Candy Kisses is Out of Stock");
		
						alert.showAndWait();
					}  
                }
				//Adding second eventhandler; changing the background color of button to yellow on double click
            		if(button==MouseButton.SECONDARY){
            		kisses.setStyle("-fx-background-color: yellow");
                }
				
				}
			});
			
	    // creating a new button back
		final Button button = new Button("Back");
        button.setMaxWidth(100);// setting button width
        
		// creating event handler for the button click
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                button.getScene().setRoot(SnacksScreen());// will take back to snack screen             
            }
        });
        
        // creating a new button cancel 
        final Button buttonCancel = new Button("Cancel");
        buttonCancel.setMaxWidth(100);// setting button width
        
        // creating event handler for the button click
        buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                
            	Product product = Main.stacklist.pop();
            	//checking if the item to be removed is instance of Candy Class
            	if(product instanceof Candy)
            	{
            		if(product.getName() == "Kisses")
            		{
            			inventory.cancelItem(Kisses);
            		}
            		else if(product.getName() == "PayDay")
            		{
            			inventory.cancelItem(payDay);
            		}
            	}
            }
        });
       
        // creating a checkout button
        final Button checkOut = new Button("Check Out");
        checkOut.setMaxWidth(100);// setting button width
        
        // creating a event handler for the button
        checkOut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                checkOut.getScene().setRoot(Dispenser.checkOut());  // will go to checkout screen when button clocked 
            	
            }
        });
       
        vBox.getChildren().addAll(payday, kisses, button, buttonCancel, checkOut);// adding all the child to vbox 
        vBox.setStyle("-fx-background-color: purple;");
        return vBox;
    }
    

}
 