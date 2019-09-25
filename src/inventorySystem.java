package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class inventorySystem {

	private ArrayList<bikePart> inventoryList;
	
	public inventorySystem() {
		inventoryList = new ArrayList<bikePart>();
		readFile("warehouseDB.txt");
	}
	
	public void readFile (String fileName) {
		try {
			File invFile = new File(fileName);
			Scanner fileReader = new Scanner(invFile);
			while(fileReader.hasNextLine()) {
				String inputLine = fileReader.nextLine();
				String[] stringArray = inputLine.split(",");
				boolean found = false;
				
				//Searches through the inventory for the part updaring the fields if it is found 
				if (!inventoryList.isEmpty()) {
					for(int i = 0; i < inventoryList.size(); i++) {
						if(inventoryList.get(i).getName().equals(stringArray[0])) {
							found = true;
							inventoryList.get(i).setPriceList(Double.parseDouble(stringArray[2]));
							inventoryList.get(i).setPriceSale(Double.parseDouble(stringArray[3]));
							if(stringArray[4].equals("true"))inventoryList.get(i).setOnSale(true);
							else inventoryList.get(i).setOnSale(false);
							inventoryList.get(i).setQuantity(Integer.parseInt(stringArray[5]));
							break;
						}
					}
				}
				
				//if the part is not found then it is added to the inventory
				if(!found) {
					boolean onSale;
					if(stringArray[4].equals("true"))onSale = true;
					else onSale = false;
					
					bikePart tempPart = new bikePart(stringArray[0], Integer.parseInt(stringArray[1]),
							Double.parseDouble(stringArray[2]), Double.parseDouble(stringArray[3]), 
							onSale, Integer.parseInt(stringArray[5]));
					inventoryList.add(tempPart);
					tempPart = null;
				}
			}
			fileReader.close();
			System.out.println("Successfully read file.");
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	//Saleman's Part
	public void enterPart () {
		
	}
	public void displayPart () {
		
	}
	public void sellPart (String partName) {
		for(int i = 0; i < inventoryList.size(); i++) {
			if (inventoryList.get(i).getName().equals(partName)) {
				double price;
				if(inventoryList.get(i).getOnSale())price = inventoryList.get(i).getPriceSale();
				else price = inventoryList.get(i).getPriceList();
				System.out.println(inventoryList.get(i).getName() + ":" + price + "|Time:" + System.currentTimeMillis() + "|");
				break;
			}
		}
		
	}
	public void sortNumber () {
		
	}
	//Saleman's Part2
	public void sortName () {
		
	}
	public void updateWarehouseDB () {
		
	}
}
