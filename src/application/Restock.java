package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Restock 
{
	public Product p = null;
	public Global_Inventory_Management inventory = new Global_Inventory_Management();
	//GUI For Multiple vending Machines
	public  static GridPane VendingMachines()// making new function for inventory display 
	{
	   //making a new grid for inventory display
	    GridPane VendingMachines = new GridPane();
	    VendingMachines.setHgap(40);//setting horizontal gap 
	    VendingMachines.setVgap(7);// setting vertical gap
	    VendingMachines.setPadding(new Insets(0,20,7,20));//setting padding
	    VendingMachines.setAlignment(Pos.CENTER);// setting alignment to gridpane
	    
	    int j = 0;
	    for(int i =0;i<2;i++)
	    {
	    			Label newlable = new Label("Vending Machine " + (i+1) );
		    		newlable.setTextFill(Color.web("BLACK"));// giving color to text 
		    		newlable.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
		    		
		    		//getting the CSV filename to be read
		    		Label getpath = new Label("Please write the name of your input file");
		    		getpath.setTextFill(Color.web("BLACK"));// giving color to text 
		    		getpath.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));// setting fonts
		    		
		    		
		    		TextField textField = new TextField ();
		    	    
		    		Button manage  = new Button("Manage");
		    		manage.setTextFill(Color.web("BLACK"));// giving color to text 
		    		manage.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
		    		manage.setMaxHeight(20);
		    		manage.setMaxWidth(200);
				
		    		
		    		manage.setOnAction(new EventHandler<ActionEvent>() {

		    	        @Override
		    	        public void handle(ActionEvent arg0) {
		    	        	if(textField.getText().isEmpty())
		    	        	{
		    	        		Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Important Information");				
						alert.setContentText("Please enter the name of text file with inventory information");
						alert.showAndWait();
		    	        	}
		    	        	else
		    	        	{
		    	        		manage.getScene().setRoot(getStockValues(newlable.getText(), textField.getText()+".txt" ));
		    	        	}
		    	        	
		    	        }
		    	    });
		    		VendingMachines.add(newlable, 0, j+1);
		    		VendingMachines.add(getpath, 0, j+2);
		    		VendingMachines.add(textField,1, j+2);
		    		VendingMachines.add(manage, 0, j+3);		    		
	    			j += 3;
	    }
	    final Button Back = new Button("Back");
		Back.setMaxWidth(200);
		Back.setMaxHeight(60);
		Back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));

		Back.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent arg0) {
	        	   
	        	Back.getScene().setRoot(Main.root);
	        }
	    });
		VendingMachines.add(Back, 0, 15);
	    return VendingMachines;
	}

	
	public  static GridPane getStockValues(String vendingMachine, String path)// making new function for inventory display 
	{
		//making a new grid for inventory display
	    GridPane getStockValues = new GridPane();
	    getStockValues.setHgap(40);//setting horizontal gap 
	    getStockValues.setVgap(7);// setting vertical gap
	    getStockValues.setPadding(new Insets(0,20,7,20));//setting padding
	    getStockValues.setAlignment(Pos.CENTER);// setting alignment to gridpane
	    
	    Global_Inventory_Management inventory = new Global_Inventory_Management();
	    
	    Product [] p = inventory.create_products(inventory.products, path);
	    
	    Label vendingMachineName = new Label(vendingMachine);
	    vendingMachineName.setTextFill(Color.web("BLACK"));// giving color to text 
	    vendingMachineName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
	    
	    getStockValues.add(vendingMachineName, 0, 0);
	    for(int i=0; i< p.length; i++)
	    {
			
	    		Label newlable = new Label(p[i].getName());
	    		newlable.setTextFill(Color.web("BLACK"));// giving color to text 
	    		newlable.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
	    		
	    		Label newlabel2  = new Label(Integer.toString(p[i].getStock()));
	    		newlabel2.setTextFill(Color.web("BLACK"));// giving color to text 
	    		newlabel2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
	    		
			
	    		getStockValues.add(newlable, 0, i+1);
	    		getStockValues.add(newlabel2, 1, i+1);
	    }
	    //Button for generating the order
	    final Button generateOrder = new Button("Generate Order");
	    generateOrder.setMaxWidth(200);
	    generateOrder.setMinWidth(50);
	    generateOrder.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
	    generateOrder.setOnAction(new EventHandler<ActionEvent>() {
	    	
	    	@Override
		    public void handle(ActionEvent arg0) {
		    		
		    	}
	    });
	    
	    getStockValues.add(generateOrder, 0, 12);
	    final Button Back = new Button("Back");
		Back.setMaxWidth(200);
		Back.setMaxHeight(60);
		Back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));

		Back.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent arg0) {
	        	   
	        	Back.getScene().setRoot(VendingMachines());
	        }
	    });
		getStockValues.add(Back, 0, 15);
	    return getStockValues;
	}
}
