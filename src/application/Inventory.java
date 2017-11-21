package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Inventory {

public int stockCandyPayday;
public int stockCandyKisses;
public int StockChipsLays;
public int stockChipsCheetos;
public int stockGumHubba;
public int stockGumStrips;
public int stockGumPeppermint;
public int stockGumTrident;
public int stockDrinkCoke;
public int stockDrinkSprite; 

//Constructor for Inventory class
public Inventory() {
	
	this.stockCandyPayday = 5;
	this.stockCandyKisses = 5;
	this.StockChipsLays = 5;
	this.stockChipsCheetos = 5;
	this.stockGumHubba = 5;
	this.stockGumStrips = 5;
	this.stockGumPeppermint = 5;
	this.stockGumTrident = 5;
	this.stockDrinkCoke = 5;
	this.stockDrinkSprite = 5;
}

//Removing the items from inventory
public  void  stock(String item) {
	
	switch(item) {
	case "payday": this.stockCandyPayday--;
	break;
	case"kisses": this.stockCandyKisses--;
	break;
	case "lays": this.StockChipsLays--;
	break;
	case "cheetos": this.stockChipsCheetos--;
	break;
	case "hubba": this.stockGumHubba--;
	break;
	case "strips": this.stockGumStrips--;
	break;
	case "peppermint": this.stockGumPeppermint--;
	break;
	case "trident": this.stockGumTrident--;
	break;
	case "cook": this.stockDrinkCoke--;
	break;
	case "sprite": this.stockDrinkSprite--;
	break;
	
	}
}
//Putting the items back into inventory if the user presses cancel button
public void cancelItem(String item)
{
	switch(item)
	{
	case "Pay Day":this.stockCandyPayday++;
	break;
	case "Kisses":this.stockCandyKisses++;
	break;
	case "coke": this.stockDrinkCoke++;
	break;
	case "sprite": this.stockDrinkSprite++;
	break;
	case "lays": this.StockChipsLays++;
	break;
	case "cheetos": this.stockChipsCheetos++;
	break;
	case "hubba": this.stockGumHubba++;
	break;
	case "strips": this.stockGumStrips++;
	break;
	case"trident": this.stockGumTrident++;
	break;
	case"peppermint": this.stockGumPeppermint++;
	
	
	
	
	}
}


public GridPane InventoryInfo()// making new fuction for inventory display 
{
    //making a new grid for inventory display
    GridPane inventoryinfo = new GridPane();
    inventoryinfo.setHgap(40);//setting horizontal gap 
    inventoryinfo.setVgap(7);// setting vertical gap
    inventoryinfo.setPadding(new Insets(0,20,7,20));//setting padding
    inventoryinfo.setAlignment(Pos.CENTER);// setting alignment to gridpane
    
    Text title = new Text("Inventory Report");// giving title
	title.setFill(Color.web("YELLOW"));// giving color to text 
    title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));// setting fonts
    
    
    Label candies = new Label("Candies");// new lable candies 
    candies.setTextFill(Color.web("BLACK"));// giving color to text 
	candies.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
    
    inventoryinfo.add(candies,0,0);// adding label giving coordinates 
    
    Label candyPayday =  new Label("Payday Candies");// creating a new label for payday candy
    candyPayday.setTextFill(Color.web("BLACK"));// giving color to a text
    candyPayday.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));// setting fonts

    inventoryinfo.add(candyPayday,0,1);// adding and giving coordinates 
    
    String payday_quantity = Integer.toString(Main.inventory.stockCandyPayday);//creating a new variable and stornig the total inventory for payday candy
    Label PaydayQuantity =  new Label(payday_quantity);// creating a label
    PaydayQuantity.setTextFill(Color.web("BLACK"));// giving color 
    PaydayQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
    inventoryinfo.add(PaydayQuantity, 1, 1);
    
    Label candykisses =  new Label("Kisses Candies");
    candykisses.setTextFill(Color.web("BLACK"));
    candykisses.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));

    inventoryinfo.add(candykisses,0,2);
    
    String kisses_quantity = Integer.toString(Main.inventory.stockCandyKisses);
    Label kissesQuantity =  new Label(kisses_quantity);
    kissesQuantity.setTextFill(Color.web("BLACK"));
    kissesQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
    inventoryinfo.add(kissesQuantity, 1, 2);
    
    Label chips = new Label("Chips");
    chips.setTextFill(Color.web("BLACK"));
	chips.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
	inventoryinfo.add(chips, 0, 3);
	
	
	 Label lays =  new Label("Lays ");
     lays.setTextFill(Color.web("BLACK"));
     lays.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
     inventoryinfo.add(lays, 0, 4);
     
     String lays_quantity = Integer.toString(Main.inventory.StockChipsLays);
     Label laysQuantity =  new Label(lays_quantity);
     laysQuantity.setTextFill(Color.web("BLACK"));
     laysQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
     inventoryinfo.add(laysQuantity, 1, 4);

     
     Label Cheetos =  new Label("Cheetos");
     Cheetos.setTextFill(Color.web("BLACK"));
     Cheetos.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
     inventoryinfo.add(Cheetos, 0, 5);
     
     String cheetos_quantity = Integer.toString(Main.inventory.stockChipsCheetos);
     Label cheetosQuantity =  new Label(cheetos_quantity);
     cheetosQuantity.setTextFill(Color.web("BLACK"));
     cheetosQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
     inventoryinfo.add(cheetosQuantity, 1, 5);

     
     Label drinks = new Label("Drinks");
     drinks.setTextFill(Color.web("BLACK"));
 	 drinks.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
 	inventoryinfo.add(drinks, 0, 6);
 	
 	
 	 Label Coke =  new Label("Coke");
      Coke.setTextFill(Color.web("BLACK"));
      Coke.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
      inventoryinfo.add(Coke, 0, 7);
      
      String coke_quantity = Integer.toString(Main.inventory.stockDrinkCoke);
      Label cokeQuantity =  new Label(coke_quantity);
      cokeQuantity.setTextFill(Color.web("BLACK"));
      cokeQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
      inventoryinfo.add(cokeQuantity, 1, 7);

      Label Sprite =  new Label("Sprite");
      Sprite.setTextFill(Color.web("BLACK"));
      Sprite.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
      inventoryinfo.add(Sprite, 0, 8);
      
      String sprite_quantity = Integer.toString(Main.inventory.stockDrinkSprite);
      Label spriteQuantity =  new Label(sprite_quantity);
      spriteQuantity.setTextFill(Color.web("BLACK"));
      spriteQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
      inventoryinfo.add(spriteQuantity, 1, 8);

      Label Gums = new Label("Gums");                                                     
      Gums.setTextFill(Color.web("BLACK"));                                                 
      Gums.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
      inventoryinfo.add(Gums, 0, 9);                                                                                
                                                                                              
      Label HubbaBubba =  new Label("Hubba Bubba");                                                        
      HubbaBubba.setTextFill(Color.web("BLACK"));                                                  
      HubbaBubba.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));  
      inventoryinfo.add(HubbaBubba, 0, 10);
      
      String hubba_quantity = Integer.toString(Main.inventory.stockGumHubba);
      Label hubbabubbaQuantity =  new Label(hubba_quantity);
      hubbabubbaQuantity.setTextFill(Color.web("BLACK"));
      hubbabubbaQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
      inventoryinfo.add(hubbabubbaQuantity, 1, 10);

                                                                                              
       Label Strips =  new Label("Strips");                                                   
       Strips.setTextFill(Color.web("BLACK"));                                                
       Strips.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
       inventoryinfo.add(Strips, 0, 11);
       
       String strips_quantity = Integer.toString(Main.inventory.stockGumStrips);
       Label stripsQuantity =  new Label(strips_quantity);
       stripsQuantity.setTextFill(Color.web("BLACK"));
       stripsQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
       inventoryinfo.add(stripsQuantity, 1, 11);

       
       Label Peppermint =  new Label("Peppermint");                                                        
       Peppermint.setTextFill(Color.web("BLACK"));                                                  
       Peppermint.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));  
       inventoryinfo.add(Peppermint, 0, 12);
       
       String peppermint_quantity = Integer.toString(Main.inventory.stockGumPeppermint);
       Label peppermintQuantity =  new Label(peppermint_quantity);
       peppermintQuantity.setTextFill(Color.web("BLACK"));
       peppermintQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
       inventoryinfo.add(peppermintQuantity, 1, 12);

                                                                                               
        Label Trident =  new Label("Trident");                                                   
        Trident.setTextFill(Color.web("BLACK"));                                                
        Trident.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
        inventoryinfo.add(Trident, 0, 13);
        
        String trident_quantity = Integer.toString(Main.inventory.stockGumTrident);
        Label tridentQuantity =  new Label(trident_quantity);
        tridentQuantity.setTextFill(Color.web("BLACK"));
        tridentQuantity.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14));
        inventoryinfo.add(tridentQuantity, 1, 13);

    
    final Button button = new Button("Back");
    button.setMaxWidth(60);
    button.setMaxHeight(60);
    button.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));

    button.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            button.getScene().setRoot(Main.root);             
        }
    });

    inventoryinfo.add(button,0,14);
    return inventoryinfo;
}
}
