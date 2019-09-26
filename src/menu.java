package src;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;
import java.io.FileNotFoundException;

public class menu {
        public static void main(String[] args) {
	      String filename = "warehouseDB.txt";
	      inventorySystem inventory = new inventorySystem(filename);
	      Scanner conIn = new Scanner(System.in);
	      boolean on = true;
		
	      while (on) {
			System.out.println("[1] Read File");
			System.out.println("[2] Enter Part");
			System.out.println("[3] Display Part");
			System.out.println("[4] Sell Part");
			System.out.println("[5] Sort Parts by Number");
			System.out.println("[6] Sort Parts by Name");
			System.out.println("[7] Quit");
			System.out.print("Enter number of the option you want: ");
		
			int input = 0;
			try {
				input = conIn.nextInt();
				//conIn.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid Input");
				conIn.nextLine();
			}
			
			if (input == 1) {
				System.out.print("Enter name of file: ");
				conIn.nextLine();
				String fileName = conIn.nextLine();
				inventory.readFile(fileName);
			}
			else if(input == 2) {
			         //Enter Part Call
			         conIn.nextLine();
				 System.out.print("Enter partName: ");
	                         String name = conIn.nextLine();
	    
	                         System.out.print("Enter partNumber: ");
	                         int number = Integer.parseInt(conIn.nextLine());
	                         
	                         System.out.print("Enter listPrice: ");
	                         double priceList = Double.parseDouble(conIn.nextLine());
	    
	                         System.out.print("Enter salePrice: ");
	                         double priceSale = Double.parseDouble(conIn.nextLine());
	    
	                         System.out.print("Enter onSale: ");
	                         boolean onSale = Boolean.parseBoolean(conIn.nextLine());
	    
	                         System.out.print("Enter quantity: ");
	                         int quantity = Integer.parseInt(conIn.nextLine());
	    
	                         bikePart bp = new bikePart(name, number, priceList, priceSale, onSale, quantity);
	                         inventory.addInventory(bp);
			}
			else if(input == 3) {
				inventory.displayPart();
				//Edit as you need for your method
			}
			else if(input == 4) {
				System.out.print("Enter name of part: ");
				conIn.nextLine();
				String partName = conIn.nextLine();
				inventory.sellPart(partName);
				//Edit as you need for your method
			}
			else if(input == 5) {
				inventory.sortNumber();
				//Edit as you need for your method
			}
			else if(input == 6) {
			        //SortByName Call
				Collections.sort(inventory.getInventory(), inventorySystem.SORT_BY_NAME);
				for(int i = 0; i < inventory.getSize(); i++) {
				    bikePart bp = inventory.getBp(i);
				    System.out.println(bp);
				}
			}
			else if(input == 7) {
				//Update WarehouseDB Call and Quit
			        on = false;
				
				inventory.saveWarehouseDB(filename);
    			}
              }
              conIn.close();
	}
}
