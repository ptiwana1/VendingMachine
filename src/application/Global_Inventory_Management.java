package application;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Global_Inventory_Management {

public Product CandyPayday = new Candy();
public Product CandyKisses = new Candy();
public Product ChipsLays = new Chips();
public Product ChipsCheetos = new Chips();
public Product GumHubba = new Gum();
public Product GumStrips = new Gum();
public Product Peppermint = new Gum();
public Product Trident = new Gum();
public Product DrinkCoke = new Drink();
public Product DrinkSprite = new Drink();

Product [] products = {CandyPayday, CandyKisses, ChipsLays, ChipsCheetos, GumHubba, GumStrips, Peppermint, Trident, DrinkCoke, DrinkSprite};
//Constructor for Inventory class
public Global_Inventory_Management() {
	
	
}

//Reading the products from the .CSV file and putting into the array defined above

public Product[] create_products(Product [] arr, String path)	
{	
	String line = "";
	int count = 0;
	try
	{
		Scanner scanner = new Scanner(new File(path));
        
        while(scanner.hasNext()){
        		line = scanner.next();
        		
            String [] properties = line.split(",");
            
            Product p = products[count];
            p.setName(properties[0]);
            p.setStock(Integer.parseInt(properties[1]));
            count++;   
        }
        scanner.close();
		
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
	//sort(arr, 0, arr.length);	
	return arr;
}


//public static void main(String [] args)
//{
//	Global_Inventory_Management inventory = new Global_Inventory_Management();
//	//array of products
//	
//	Product[] arr = inventory.create_products(inventory.products);
//	inventory.sortByStock(arr, 0, arr.length-1);
//	for(Product p :arr)
//	{
//		System.out.println(p.getName() + " " + p.getStock());
//		
//	}
//	
//	
//}

//Searching for the item in array of Products by Name
public String Search(Product[] p, String Target, int length)
{
	
	if(length == 0)
	{
		return "Product not Found";
	}
	else if(p[length -1].getName().toLowerCase().equals(Target))
	{
		return Target + " is found in " + p[length -1 ].toString() + " with " + p[length-1].getStock() + " Quantity";
	}
	else
	{
		return Search(p, Target, length - 1);
	}
}
public void mergeByName(Product arr[], int l, int m, int r)
{
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    Product L[] = new Product [n1];
    Product R[] = new Product [n2];

    /*Copy data to temp arrays*/
    for (int i=0; i<n1; ++i)
        L[i] = arr[l + i];
    for (int j=0; j<n2; ++j)
        R[j] = arr[m + 1+ j];


    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarry array
    int k = l;
    while (i < n1 && j < n2)
    {
        if (R[j].getName().compareTo(L[i].getName()) < 0)    
        {
            arr[k] = R[j];
            j++;
        }
        else
        {
            arr[k] = L[i];
            i++;
        }
        k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1)
    {
        arr[k] = L[i];
        i++;
        k++;
    }
    /* Copy remaining elements of R[] if any */
    while (j < n2)
    {
        arr[k] = R[j];
        j++;
        k++;
    }
}

//Sorting the array of Products Recursively
public void sortByName(Product arr[], int l, int r)
	{
	    if (l < r)
	    {
	        // Find the middle point
	        int m = (l+r)/2;
	
	        // Sort first and second halves
	        sortByName(arr, l, m);
	        sortByName(arr , m+1, r);
	
	        // Merge the sorted halves
	        mergeByName(arr, l, m, r);
	    }
	}

//Removing the items from inventory when cancel button is clicked
public  void  stock(Product p) {
		
		switch(p.getName()) {
		case "PayDay": this.CandyPayday.setStock(CandyPayday.getStock() - 1);;
		break;
		case"Kisses": this.CandyKisses.setStock(CandyKisses.getStock() - 1);
		break;
		case "Lays": this.ChipsLays.setStock(ChipsLays.getStock() - 1);;
		break;
		case "Cheetos": this.ChipsCheetos.setStock(ChipsCheetos.getStock() - 1);;
		break;
		case "HubbaBubba": this.GumHubba.setStock(GumHubba.getStock() -1);;
		break;
		case "Strips": this.GumStrips.setStock(GumStrips.getStock() - 1);;
		break;
		case "Peppermint": this.Peppermint.setStock(Peppermint.getStock() - 1);
		break;
		case "Trident": this.Trident.setStock(Trident.getStock() - 1);;
		break;
		case "Coke": this.DrinkCoke.setStock(DrinkCoke.getStock() - 1);;
		break;
		case "Sprite": this.DrinkSprite.setStock(DrinkSprite.getStock() - 1);;
		break;
		
		}
	}	//Putting the items back into inventory if the user presses cancel button
public void cancelItem(Product p)
	{
		switch(p.getName()) {
		case "Pay Day": this.CandyPayday.setStock(CandyPayday.getStock() + 1);;
		break;
		case"Kisses": this.CandyKisses.setStock(CandyKisses.getStock() + 1);
		break;
		case "Lays": this.ChipsLays.setStock(ChipsLays.getStock() + 1);;
		break;
		case "Cheetos": this.ChipsCheetos.setStock(ChipsCheetos.getStock() + 1);;
		break;
		case "HubbaBubba": this.GumHubba.setStock(GumHubba.getStock() + 1);;
		break;
		case "Strips": this.GumStrips.setStock(GumStrips.getStock() + 1);;
		break;
		case "Peppermint": this.Peppermint.setStock(Peppermint.getStock() + 1);
		break;
		case "Trident": this.Trident.setStock(Trident.getStock() + 1);;
		break;
		case "Coke": this.DrinkCoke.setStock(DrinkCoke.getStock() + 1);;
		break;
		case "Sprite": this.DrinkSprite.setStock(DrinkSprite.getStock() + 1);;
		break;
		
		}
	}
public  static GridPane InventoryInfo()// making new function for inventory display 
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
    
    Global_Inventory_Management inventory = new Global_Inventory_Management();
	//array of products
	
	Product[] arr = inventory.create_products(inventory.products, "Inventoryinfo.txt");
	Label label = null;
	Label label2 = null;
	for(int i=0; i< arr.length; i++)
	    {
	    	    label = new Label(arr[i].getName());
	    		label.setTextFill(Color.web("BLACK"));// giving color to text 
	    		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
	    		
	    		label2 = new Label(Integer.toString(arr[i].getStock()));
	    		label2.setTextFill(Color.web("BLACK"));// giving color to text 
	    		label2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
	    		
	    		inventoryinfo.add(label, 0, i+1);
	    		inventoryinfo.add(label2, 1, i+1);	    		
	    }
    
    final Button SortItemsByName = new Button("Sort Items by Name");
    SortItemsByName.setMaxWidth(200);
    SortItemsByName.setMaxHeight(60);
    SortItemsByName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));

    SortItemsByName.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
        	   
        	SortItemsByName.getScene().setRoot(SortedByName());
        }
    });
    
    final Button SortItemsByStock = new Button("Sort Items by Stock");
    SortItemsByStock.setMaxWidth(200);
    SortItemsByStock.setMaxHeight(60);
    SortItemsByStock.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));

    SortItemsByStock.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
        	   
        	SortItemsByStock.getScene().setRoot(SortedByStock());
        }
    });
    inventoryinfo.add(SortItemsByName,0,14);
    inventoryinfo.add(SortItemsByStock,0,15);
    final Button Search = new Button("Search");
    Search.setMaxWidth(60);
    Search.setMaxHeight(60);
    Search.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));
    
    TextField textField = new TextField ();
    inventoryinfo.add(Search,1,16);
    inventoryinfo.add(textField, 0 ,16 );
    Search.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            Label returnedstring = new Label(inventory.Search(arr, textField.getText().toLowerCase(), arr.length));  
            	returnedstring.setTextFill(Color.web("Red"));// giving color to text 
    			returnedstring.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 16));// setting fonts
    			inventoryinfo.add(returnedstring, 0, 17);
        }
    });
    
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
	inventoryinfo.add(Back, 0, 17);
    
    return inventoryinfo;
}
//Displaying Sorted Inventory by Name
public  static GridPane SortedByName()// making new function for inventory display 
{
   //making a new grid for inventory display
    GridPane SortedByName = new GridPane();
    SortedByName.setHgap(40);//setting horizontal gap 
    SortedByName.setVgap(7);// setting vertical gap
    SortedByName.setPadding(new Insets(0,20,7,20));//setting padding
    SortedByName.setAlignment(Pos.CENTER);// setting alignment to gridpane

    Global_Inventory_Management inventory = new Global_Inventory_Management();
    
    Product []arr = inventory.create_products(inventory.products, "Inventoryinfo.txt");
    inventory.sortByName(arr, 0, arr.length -1);
	for(int i=0; i< arr.length; i++)
    {
		
    		Label newlable = new Label(arr[i].getName());
    		newlable.setTextFill(Color.web("BLACK"));// giving color to text 
    		newlable.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
    		
    		Label newlabel2  = new Label(Integer.toString(arr[i].getStock()));
    		newlabel2.setTextFill(Color.web("BLACK"));// giving color to text 
    		newlabel2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
    		
		
    		SortedByName.add(newlable, 0, i+1);
    		SortedByName.add(newlabel2, 1, i+1);
    }
	
	final Button Back = new Button("Back");
	Back.setMaxWidth(200);
	Back.setMaxHeight(60);
	Back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));

	Back.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
        	   
        	Back.getScene().setRoot(InventoryInfo());
        }
    });
	SortedByName.add(Back, 0, 15);
    return SortedByName;
}

//Displaying Sorted Inventory by Stock
public  static GridPane SortedByStock()// making new function for inventory display 
{
   //making a new grid for inventory display
    GridPane SortedByStock = new GridPane();
    SortedByStock.setHgap(40);//setting horizontal gap 
    SortedByStock.setVgap(7);// setting vertical gap
    SortedByStock.setPadding(new Insets(0,20,7,20));//setting padding
    SortedByStock.setAlignment(Pos.CENTER);// setting alignment to gridpane

    Global_Inventory_Management inventory = new Global_Inventory_Management();
    //Creating an array of products and passing the path of inventory of a vending machine
    Product []arr = inventory.create_products(inventory.products, "Inventoryinfo.txt");
    inventory.sortByStock(arr, 0, arr.length -1);
	for(int i=0; i< arr.length; i++)
    {
		
    		Label newlable = new Label(arr[i].getName());
    		newlable.setTextFill(Color.web("BLACK"));// giving color to text 
    		newlable.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
    		
    		Label newlabel2  = new Label(Integer.toString(arr[i].getStock()));
    		newlabel2.setTextFill(Color.web("BLACK"));// giving color to text 
    		newlabel2.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));// setting fonts
    		
		
    		SortedByStock.add(newlable, 0, i+1);
    		SortedByStock.add(newlabel2, 1, i+1);
    }
	
	final Button Back = new Button("Back");
	Back.setMaxWidth(200);
	Back.setMaxHeight(60);
	Back.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 12));

	Back.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
        	   
        	Back.getScene().setRoot(InventoryInfo());
        }
    });
	SortedByStock.add(Back, 0, 15);
	
    return SortedByStock;
}

public void mergeByStock(Product arr[], int l, int m, int r)
{
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    Product L[] = new Product [n1];
    Product R[] = new Product [n2];

    /*Copy data to temp arrays*/
    for (int i=0; i<n1; ++i)
        L[i] = arr[l + i];
    for (int j=0; j<n2; ++j)
        R[j] = arr[m + 1+ j];


    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarry array
    int k = l;
    while (i < n1 && j < n2)
    {
        if (R[j].getStock() < L[i].getStock())    
        {
            arr[k] = R[j];
            j++;
        }
        else
        {
            arr[k] = L[i];
            i++;
        }
        k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1)
    {
        arr[k] = L[i];
        i++;
        k++;
    }
    /* Copy remaining elements of R[] if any */
    while (j < n2)
    {
        arr[k] = R[j];
        j++;
        k++;
    }
}

//Sorting the array of Products by Stock using Merge Sort
public void sortByStock(Product arr[], int l, int r)
	{
	    if (l < r)
	    {
	        // Find the middle point
	        int m = (l+r)/2;
	
	        // Sort first and second halves
	        sortByStock(arr, l, m);
	        sortByStock(arr , m+1, r);
	
	        // Merge the sorted halves
	        mergeByStock(arr, l, m, r);
	    }
	}



}