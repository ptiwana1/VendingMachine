
package application;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;



public class Main extends Application {
	
	
	public static BorderPane root = new BorderPane();
	
	public static Stack<Product> stacklist = new Stack<Product>();// making stack of products using product class
	
	
	Candy candy = new Candy();
	
	Drink drink = new Drink();
	
	
	
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
		Scene scene = new Scene(root,500,500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		root.setStyle("-fx-background-color: purple");
		primaryStage.setTitle("My vending machine");
		
		// setting center image
		Image image = new Image("./application/images/VendingUML.JPG");
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(250);
		imageView.setFitHeight(250);
		BorderPane.setAlignment(imageView, Pos.CENTER);
		root.setCenter(imageView);
		
		// Giving title to front page
		Text text = new Text("Please choose from snack or drink ");
		text.setFill(Color.web("YELLOW"));// setting color
		text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 24));// setting fonts
		BorderPane.setAlignment(text, Pos.CENTER);// setting position for the borderpane
		root.setTop(text);// setting position to title
		
		Button login = new Button("Admin Login");
		login.setStyle("-fx-background-color: white");
		login.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		root.setBottom(login);

        login.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				
				if(button==MouseButton.PRIMARY){
					login.getScene().setRoot(Global_Inventory_Management.InventoryInfo());  
                }
				else if(button==MouseButton.SECONDARY){
                	login.setStyle("-fx-background-color: yellow");
                }
            }
        });
        
        Button viewAllVending = new Button("View All Vending Machines");
        viewAllVending.setStyle("-fx-background-color: white");
        viewAllVending.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		root.setTop(viewAllVending);

		viewAllVending.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				
				if(button==MouseButton.PRIMARY){
					login.getScene().setRoot(Restock.VendingMachines());  
                }
				else if(button==MouseButton.SECONDARY){
                	login.setStyle("-fx-background-color: yellow");
                }
            }
        });
		
		// creating vbox
		 VBox vBox = new VBox();
	        vBox.setAlignment(Pos.CENTER_LEFT);// setting vbox to center left side
	       
	        vBox.setSpacing(30);// giving space between buttons
	        
	        
	        // creating button for snack class
	        final Button Snack = new Button("Snack");
	        Snack.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));// setting fonts for the button
	        Image imageSnack = new Image("./application/images/Snack.jpg");// making new image and giving  image path
			ImageView imageViewSnack = new ImageView(imageSnack);// setting up image view 
			imageViewSnack.setFitHeight(50);// setting up image height
			imageViewSnack.setFitWidth(50);// setting up image width
			Snack.setGraphic(imageViewSnack);// setting up image in a button
			// creating a button click handler 
	        Snack.setOnMouseClicked(new EventHandler<MouseEvent>() {
	        
	        	@Override
	        	public void handle(MouseEvent mouseEvent) {
					MouseButton button = mouseEvent.getButton();
					
					if(button==MouseButton.PRIMARY){
						Snack.getScene().setRoot(candy.SnacksScreen()); // will go to next screen(snack screen) when clicked
	                }else if(button==MouseButton.SECONDARY){
	                	Snack.setStyle("-fx-background-color: yellow");
	        		
	                }
	        	      
	            }
	        });
	        
	        // creating button for drink class
	        final Button Drink = new Button("Drink");
	        Drink.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));// setting fonts for the button
	        Image imageDrink = new Image("./application/images/Drink.jpg");// making new image and giving  image path
			ImageView imageViewDrink = new ImageView(imageDrink);// setting up image view
			imageViewDrink.setFitHeight(50);// setting up image height
			imageViewDrink.setFitWidth(50);// setting up image width
	        
	        Drink.setGraphic(imageViewDrink);// setting up image in a button
	        
	        
			// creating a button click handler 
	        Drink.setOnMouseClicked(new EventHandler<MouseEvent>() {

	            @Override
	            public void handle(MouseEvent mouseEvent) {
					MouseButton button = mouseEvent.getButton();
					
					if(button==MouseButton.PRIMARY){
	                    Drink.getScene().setRoot(drink.DrinkScreen());
	                }else if(button==MouseButton.SECONDARY){
	                	Drink.setStyle("-fx-background-color: yellow");
	                }
	            	
	                             
	            }
	        });
	        
	        //stage = primaryStage;	        
	        vBox.getChildren().addAll( Snack, Drink);
	        root.setLeft(vBox);

        
    }

    public static void main(String[] args) {
        launch(args);
    }

    
    
}