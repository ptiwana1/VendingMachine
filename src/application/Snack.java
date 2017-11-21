package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public abstract class Snack extends Product implements Comparable<Product>
{
	
	/*
	 * Constructor for snack class
	 */
	public Snack() {
		super();
	}
	
	/*
	 * Constructors
	 * @param name productID price stock
	 */
	public Snack(String name, int productID, float price, int stock) {
		super(name, productID, price, stock);
	}
	/*
	 * Copy Constructor 
	 * @param s
	 */
	public Snack(Snack s) {
		this(s.getName(), s.getProductID(), s.getPrice(), s.getStock());
	}
	
	/*
	 * toString method
	 */
	public String toString() {
		return super.toString();
	}
	
	static Gum  gum = new Gum();
	static Candy candy = new Candy();
	static Chips chips = new Chips();
	
	public static VBox SnacksScreen()// making new function for snack screen  
    {
    	VBox vBox = new VBox();// creating a new vbox for candy screen
        vBox.setAlignment(Pos.CENTER);// setting alignment
        vBox.setSpacing(20);// setting vertical gap
        
        Text title = new Text("Please choose your snacks");// giving title to snack screen
    		title.setFill(Color.web("YELLOW"));// giving color to title 
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));// setting fonts 
        vBox.getChildren().add(title);// adding title to vbox 
        
        
        final Button Chips = new Button("Chips");//making new button chips 
        Chips.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));// fonts setting 
        Image imageChips = new Image("./application/images/Chips.png");// image path
		ImageView imageViewChips = new ImageView(imageChips);// setting new iage view 
		imageViewChips.setFitHeight(50);// setting height
		imageViewChips.setFitWidth(50);// setting width
		Chips.setGraphic(imageViewChips);// adding image view to button
		
		// creating a new event handler for chips button 
        Chips.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent  mouseEvent) {
            	if(mouseEvent.getClickCount() == 1){
            		Chips.getScene().setRoot(chips.ChipsScreen());   // will take to chips screen when chips button is clicked    
                }
            	if(mouseEvent.getClickCount() == 2){
            		Chips.setStyle("-fx-background-color: yellow");
                }
                //       
            }
        });
        
        final Button Gum = new Button("Gum");// creating new button gum
        Gum.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));// setting fonts 
        Image imageGum = new Image("./application/images/Gum.jpg");// getting image path
		ImageView imageViewGum = new ImageView(imageGum);// making new image view 
		imageViewGum.setFitHeight(50);// creating image view height
		imageViewGum.setFitWidth(50);// creating image view width
		Gum.setGraphic(imageViewGum);// adding image view to button
		
		// creating new event handler for gum button
        Gum.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent  mouseEvent) {
            	if(mouseEvent.getClickCount() == 1){
            		Gum.getScene().setRoot(gum.GumScreen());// will take to gun screen when gum button is clicked   
                }
            	if(mouseEvent.getClickCount() == 2){
            		Gum.setStyle("-fx-background-color: yellow");
                }
                           
            }
        });
       
        final Button Candy = new Button("Candy");// creating new button candy 
        Candy.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));// setting fonts 
        Image imageCandy = new Image("./application/images/Candy.png");// getting image path
		ImageView imageViewCandy = new ImageView(imageCandy);// creating new image view 
		imageViewCandy.setFitHeight(50);// setting image view height
		imageViewCandy.setFitWidth(50);// setting image view width
		Candy.setGraphic(imageViewCandy);// adding image view to button
        
		// creating new event handler for candy button 
        Candy.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
            	if(mouseEvent.getClickCount() == 1){
            		Candy.getScene().setRoot(candy.CandyScreen());// will take to candy screen when candy button is clicked   
                }
            	if(mouseEvent.getClickCount() == 2){
            		Candy.setStyle("-fx-background-color: yellow");
                }
                             
            }
        });
        
        final Button button = new Button("Back");// creating new back button
        button.setMaxWidth(100);// setting button width
        
		// creating new event handler for back button 
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                button.getScene().setRoot(Main.root); // will take to front (main) screen when back button is clicked             
            }
        });
        
        //adding all button to vbox 
        vBox.getChildren().addAll(Chips,Gum , Candy, button);
        vBox.setStyle("-fx-background-color: purple;");// setting background color to purple
        return vBox;// returning vbox 
        
    }

    


}
