package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Gum extends Snack
{
	
	public static Global_Inventory_Management inventory = new Global_Inventory_Management();
	static Product hubbabubba = null;
	static Product Strips = null;
	static Product peppermint = null;
	static Product trident = null;
	/*
	 * Constructor for gum
	 */
	public Gum(Gum g) {
		super(g);
	}
	
	/*
	 * Constructor for gum
	 */
	public Gum() {
		super();
	}
	
	/*
	 * Constructor for gum as a subclass of snack and product
	 */
	public Gum(String name, int productID, float price, int stock) {
		super(name, productID, price, stock);
	}
	
	/*
	 * toString method 
	 */
	public String toString() {
		return "Gums";
	}
	
	
	public  static GridPane GumScreen()
    {
        GridPane gridGum = new GridPane();
        gridGum.setHgap(40);
        gridGum.setVgap(20);
        gridGum.setPadding(new Insets(20,50,10,50));
        gridGum.setAlignment(Pos.CENTER);
        
        Text title = new Text("Please choose your Gum");
    		title.setFill(Color.web("YELLOW"));
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
        

        
        
        final Button button = new Button("Back");
        button.setMaxWidth(60);
        button.setMaxHeight(60);
        button.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
            	
                button.getScene().setRoot(SnacksScreen());             
            }
        });
        
        final Button buttonCancel = new Button("Cancel");
        buttonCancel.setMaxWidth(60);
        buttonCancel.setMaxHeight(60);
        buttonCancel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
        
        buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
            	
            	Product product = Main.stacklist.pop();
            	//checking if the item to be removed is instance of Gum Class
            	if(product instanceof Gum)
            	{
            		if(product.name == "HubbaBubba")
                	{
                		inventory.cancelItem(hubbabubba);
                	}
                	else if(product.name == "Strips")
                	{
                		inventory.cancelItem(Strips);
                	}
                	else if(product.name == "Peppermint")
                	{
                		inventory.cancelItem(peppermint);
                	}
                	else if(product.name == "Trident")
                	{
                		inventory.cancelItem(trident);
                	}
            	}
            	
            	else
            	{
            		Main.stacklist.push(product);
            	}          
            }
        });
        
        final Button checkOut = new Button("Check Out");
        checkOut.setMaxWidth(60);
        checkOut.setMaxHeight(60);
        checkOut.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
        
        checkOut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
            	checkOut.getScene().setRoot(Dispenser.checkOut());             
            }
        });
        
        Image imagehubba = new Image("./application/images/Hubba Bubba.jpg");
		ImageView imageViewhubba = new ImageView(imagehubba);
		imageViewhubba.setFitHeight(85);
		imageViewhubba.setFitWidth(85);
				
		Button hubba = new Button();
		//hubba.setGraphic(imageViewhubba);
		hubba.setMaxWidth(300);
		hubba.setMaxHeight(300);
		hubba.setText(" Hubba Bubba" +"\n Calories: 120" + "\n Price: $1.59" );
		hubba.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		hubba.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				if(button==MouseButton.PRIMARY){
					if( inventory.GumHubba.getStock() > 0)
					{
					// TODO Auto-generated method stub
						hubbabubba = new Gum();
						hubbabubba.name = "HubbaBubba";
						hubbabubba.setPrice(1.59f);
					Main.stacklist.push(hubbabubba);
					inventory.stock(hubbabubba);
					}
					else
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Important Information");
						
						alert.setContentText("Gum Hubba Bubba is Out of Stock");

						alert.showAndWait();
					}
                }
				//Adding second eventhandler; changing the background color of button to yellow on double click

				else if(button==MouseButton.SECONDARY){
            		hubba.setStyle("-fx-background-color: yellow");
                }
				
			}
			
		});

		
		Image imagegum = new Image("./application/images/Gum.jpg");
		ImageView imageViewgum = new ImageView(imagegum);
		imageViewgum.setFitHeight(85);
		imageViewgum.setFitWidth(85);
		
		Button gum = new Button();
		gum.setGraphic(imageViewgum);
		gum.setMaxWidth(300);
		gum.setMaxHeight(300);
		gum.setText(" Strips" +"\n Calories: 120" + "\n Price: $2.59" );
		gum.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		gum.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				if(button==MouseButton.PRIMARY){
					if(inventory.GumStrips.getStock() > 0)
					{
						Strips = new Gum();
						Strips.name = "Strips";
						Strips.setPrice(2.59f);
					Main.stacklist.push(Strips);
					inventory.stock(Strips);
					
					}
					else
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Important Information");
						
						alert.setContentText("Gum strips is Out of Stock");

						alert.showAndWait();
						
					}
                }
				//Adding second eventhandler; changing the background color of button to yellow on double click

            	if(button==MouseButton.SECONDARY){
            		gum.setStyle("-fx-background-color: yellow");
                }
				
			}
			
		});


		
		Image imagePeppermint = new Image("./application/images/Peppermint.jpg");
		ImageView imageViewPeppermint = new ImageView(imagePeppermint);
		imageViewPeppermint.setFitHeight(85);
		imageViewPeppermint.setFitWidth(85);
		
		Button Peppermint = new Button();
		Peppermint.setGraphic(imageViewPeppermint);
		Peppermint.setMaxWidth(300);
		Peppermint.setMaxHeight(300);
		Peppermint.setText(" Peppermint" +"\n Calories: 120" + "\n Price: $3.59" );
		Peppermint.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		Peppermint.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				if(button==MouseButton.PRIMARY){
					if(inventory.Peppermint.getStock() > 0)
					{
						peppermint = new Gum();
						peppermint.name = "Peppermint";
						peppermint.setPrice(3.59f);
					Main.stacklist.push(peppermint);
					inventory.stock(peppermint);
					}
					else
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Important Information");
						
						alert.setContentText("Gum Peppermint is Out of Stock");

						alert.showAndWait();
					} 
                }
				//Adding second eventhandler; changing the background color of button to yellow on double click

            	if(button==MouseButton.SECONDARY){
            		Peppermint.setStyle("-fx-background-color: yellow");
                }
				
				
			}
			
		});


		
		Image imageTrident = new Image("./application/images/Trident.jpg");
		ImageView imageViewTrident = new ImageView(imageTrident);
		imageViewTrident.setFitHeight(85);
		imageViewTrident.setFitWidth(85);
		
		Button Trident = new Button();
		Trident.setGraphic(imageViewTrident);
		Trident.setMaxWidth(300);
		Trident.setMaxHeight(300);
		Trident.setText("Trident" +"\n Calories: 120" + "\n Price: $4.59" );
		Trident.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		Trident.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				if(button==MouseButton.PRIMARY){
					if(inventory.Trident.getStock() > 0)
					{
						trident = new Gum();
						trident.name = "Trident";
						trident.setPrice(4.59f);
					Main.stacklist.push(trident);
					inventory.stock(trident);
					}
					else
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Important Information");
						
						alert.setContentText("Gum Trident is Out of Stock");

						alert.showAndWait();
					}   
                }
				//Adding second eventhandler; changing the background color of button to yellow on double click

				else if(button==MouseButton.SECONDARY){
            		Trident.setStyle("-fx-background-color: yellow");
                }
				
			}
			
		});



		
        checkOut.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
        checkOut.setMaxWidth(100);
        checkOut.setMaxHeight(60);
        gridGum.setStyle("-fx-background-color: purple;");
        gridGum.add(title, 0, 0);
        gridGum.add(hubba, 0, 1);
        gridGum.add(gum, 1, 1);
        gridGum.add(Peppermint, 0, 2);
        gridGum.add(Trident, 1, 2);
        gridGum.add( button,0,3);
        gridGum.add(checkOut, 1, 3);
        gridGum.add(buttonCancel, 0, 4);
        
        
        
        return gridGum;
    }

}
