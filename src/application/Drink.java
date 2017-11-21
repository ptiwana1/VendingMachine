package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Drink extends Product implements Comparable<Product>
{

	private int numberOfOunces;
	
	/*
	 * Constructor for drink
	 */
	public Drink(Drink d) {
		this(d.getName(), d.getProductID(), d.getPrice(), d.getStock());
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Constructor for drink
	 */
	public Drink() {
		super();
	}
	
	/*
	 * Constructor for drink as a subclass of snack and product
	 */
	public Drink(String name, int productID, float price, int stock) {
		super(name, productID, price, stock);
	}
	
	/*
	 * toString method 
	 */
	public String toString() {
		
		return super.toString();
	}
	
	/*
	 * get method for numberOfOunces
	 */
	public int getNumberOfOunces() {
		return numberOfOunces;
	}
	
	/*
	 * set method for numberOfOunces
	 */
	public void setNumberOfOunces(int numberOfOunces) {
		
	}
	
	
public VBox DrinkScreen()// making new fuction drinkscreen for drink class
    
    {
    	// creating new vbox for drink class
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);// setting alignment for vbox
        vBox.setSpacing(20);// setting vertical gap
        Text text = new Text("Please choose your drinks ");// setting a title for drink class
        text.setFill(Color.web("YELLOW"));// giving color to title text
		text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 24));// setting fonts 
		vBox.getChildren().add(text);// addind text to vbox 
		

        // creating new button coke
        Button Coke = new Button("Coke");
        
        Image imageCoke = new Image("./application/images/Drink.jpg");// getting image path
		ImageView imageViewCoke = new ImageView(imageCoke);// creating new image view 
		imageViewCoke.setFitHeight(100);// setting height
		imageViewCoke.setFitWidth(100);// setting width
		Coke.setGraphic(imageViewCoke);// adding image view to button
		Coke.setMaxWidth(200);// setting width to button coke 
		Coke.setText(" Coke"+"\n Calories: 320" + "\n Price: $0.99" );// adding name, calories and perice 
		
		Coke.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));// settinf fonts 
		
		// creating new event handler 
		Coke.setOnMouseClicked(new EventHandler<MouseEvent>(){
			
				@Override
				public void handle(MouseEvent mouseEvent) {
					if(mouseEvent.getClickCount() == 1){
						if(Main.inventory.stockDrinkCoke > 0) {
							// TODO Auto-generated method stub
							Drink coke = new Drink();// creating object of new drink coke
							coke.name = "Coke";
							coke.setPrice(0.99f);// setting coke price
							Main.stacklist.push(coke);// pushing coke in stack
							Main.inventory.stock("coke");//Calling the stock method of Inventory class to decrease the stock of drink coke by 1
						}
						else
						{   // creating a alert for out of stock 
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Important Information");
							
							alert.setContentText("Drink cook is Out of Stock");

							alert.showAndWait();
						} 
	                }
	            	if(mouseEvent.getClickCount() == 2){
	            		Coke.setStyle("-fx-background-color: yellow");
	                }
					
			}
		});
    
			
			
		
		Button Sprite = new Button("Sprite");
        
        Image imageSprite = new Image("./application/images/Sprite.jpg");
		ImageView imageViewSprite = new ImageView(imageSprite);
		imageViewSprite.setFitHeight(100);
		imageViewSprite.setFitWidth(100);
		Sprite.setGraphic(imageViewSprite);
		Sprite.setMaxWidth(200);
		Sprite.setText(" Sprite"+"\n Calories: 320" + "\n Price: $0.99" );
		Sprite.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		Sprite.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent mouseEvent) {
				if(mouseEvent.getClickCount() == 1){
					if(Main.inventory.stockDrinkSprite > 0)
					{
					// TODO Auto-generated method stub
					Drink sprite = new Drink();
					sprite.name = "Sprite";
					sprite.setPrice(0.99f);
					Main.stacklist.push(sprite);
					Main.inventory.stock("sprite");
					}
					else
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Important Information");
						
						alert.setContentText("Drink Sprite is Out of Stock");

						alert.showAndWait();
					}
                }
            	if(mouseEvent.getClickCount() == 2){
            		Sprite.setStyle("-fx-background-color: yellow");
                }
				
			}
			
		});
		
		final Button button = new Button("Back");
		button.setMaxWidth(100);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                button.getScene().setRoot(Main.root);             
            }
        });
        
        
        final Button buttonCancel = new Button("Cancel");
        buttonCancel.setMaxWidth(100);
        buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
            	Product product = Main.stacklist.pop();
            	if(product instanceof Drink)
            	{
            		if(product.name == "Coke")
                	{
                		Main.inventory.cancelItem("coke");
                	}
                	else if(product.name == "Sprite")
                	{
                		Main.inventory.cancelItem("sprite");
                	}
            	}         	
            	else
            	{
            		Main.stacklist.push(product);
            	}
            	            
            }
        });
        
        final Button checkOut = new Button("Check Out");
        checkOut.setMaxWidth(100);
        checkOut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                checkOut.getScene().setRoot(Main.checkOut());             
            }
        });
        vBox.getChildren().addAll(Coke,Sprite, button, buttonCancel, checkOut);
        vBox.setStyle("-fx-background-color: purple;");
        return vBox;
    }
    
	

}