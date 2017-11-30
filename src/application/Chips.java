package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Chips extends Snack {

	
	public static Global_Inventory_Management inventory = new Global_Inventory_Management();
	//Initializing different objects to null
	static Product Lays = null;
	static Product Cheetos = null;
	/*
	 * Constructor for chips
	 */
	public Chips(Chips c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Constructor for chips
	 */
	public Chips() {
		super();
	}
	
	/*
	 * Constructor for chips as a subclass of snack and product
	 */
	public Chips(String name, int productID, float price, int stock) {
		super(name, productID, price, stock);
	}
	
	/*
	 * toString method 
	 */
	public String toString() {
		return "Chips";
	}
	
	//Setting up screen for chips selection
	public  static VBox ChipsScreen()
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        Text title = new Text("Please choose your chips");
        title.setFill(Color.web("YELLOW"));
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
        vBox.getChildren().add(title);

        
        //Setting up button Lays
        Button lays = new Button("Lays");
       //Giving Image and other text to the label 
        Image imagelays = new Image("./application/images/Chips.png");
		ImageView imageViewlays = new ImageView(imagelays);
		imageViewlays.setFitHeight(100);
		imageViewlays.setFitWidth(100);
		lays.setGraphic(imageViewlays);
		lays.setMaxWidth(200);
		lays.setText(" Lays"+"\n Calories: 120" + "\n Price: $3.59" );
		lays.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		lays.setOnMouseClicked(new EventHandler<MouseEvent>(){

			//Selecting the chips when the user presses the button
			@Override
			public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				if(button==MouseButton.PRIMARY){
					if(inventory.ChipsLays.getStock() > 0)
						// TODO Auto-generated method stub
						{
						Lays = new Chips();
						Lays.name = "Lays";
						Lays.setPrice(3.59f);
						Main.stacklist.push(Lays);
						inventory.stock(Lays);
						
						}
						else
						{
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Important Information");
							
							alert.setContentText("Chips Lays is Out of Stock");

							alert.showAndWait();
						}   
                }
				//Adding second eventhandler; changing the background color of button to yellow on double click
				else if(button==MouseButton.SECONDARY){
            		lays.setStyle("-fx-background-color: yellow");
                }
				
				
			}
			
		});
		//Setting button for selecting cheetos
		Button cheetos = new Button("Cheetos");
        
		//Giving graphics to the button
        Image imagecheetos = new Image("./application/images/Snack.jpg");
		ImageView imageViewcheetos = new ImageView(imagecheetos);
		imageViewcheetos.setFitHeight(100);
		imageViewcheetos.setFitWidth(100);
		cheetos.setGraphic(imageViewcheetos);
		cheetos.setMaxWidth(200);
		cheetos.setText(" Cheetos" +"\n Calories: 120" + "\n Price: $2.59" );
		cheetos.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
		
		cheetos.setOnMouseClicked(new EventHandler<MouseEvent>(){
			//Selecting Cheetos on pressing button
			@Override
			public void handle(MouseEvent mouseEvent) {
				MouseButton button = mouseEvent.getButton();
				
				if(button == MouseButton.PRIMARY){
					if(inventory.ChipsCheetos.getStock() > 0)
					{
						Cheetos = new Chips();
						Cheetos.name = "Cheetos";
						Cheetos.setPrice(2.59f);
						Main.stacklist.push(Cheetos);
						inventory.stock(Cheetos);
					}
					else
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Important Information");
						
						alert.setContentText("Chips Cheetos is Out of Stock");

						alert.showAndWait();
					}
                }
				else if(button==MouseButton.SECONDARY){
                		cheetos.setStyle("-fx-background-color: yellow");                  
				}   
				
			}
			
		});
		
        //Going back to snack screen
		final Button button = new Button("Back");
		button.setMaxWidth(100);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                button.getScene().setRoot(SnacksScreen());             
            }
        });
        
        //Cancelling all the selections made on that screen
        final Button buttonCancel = new Button("Cancel");
		buttonCancel.setMaxWidth(100);
        buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
            	Product product = Main.stacklist.pop();
            	//checking if the item to be removed is instance of Chips Class
            	if(product instanceof Chips)
            	{
            		if(product.name == "Lays")
                	{
                		inventory.cancelItem(Lays);
                	}
                	else if(product.name == "Cheetos")
                	{
                		inventory.cancelItem(Cheetos);
                	}
            	}    
            	else
            	{
            		Main.stacklist.push(product);
            	}       
            }
        });
        //Proceeding to checkout
        final Button checkOut = new Button("Check Out");
        checkOut.setMaxWidth(100);
        checkOut.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                checkOut.getScene().setRoot(Dispenser.checkOut());             
            }
        });
        vBox.getChildren().addAll(lays,cheetos, button, buttonCancel, checkOut);
        vBox.setStyle("-fx-background-color: purple;");
        return vBox;
    }

}
