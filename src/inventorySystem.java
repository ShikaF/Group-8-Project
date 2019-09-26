package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Comparator;
import java.io.PrintWriter;
    
public class inventorySystem {
        private ArrayList<bikePart> inventoryList;

    	public inventorySystem(String filename) {
    		inventoryList = new ArrayList<bikePart>();
    		readFile(filename);
    	}
    	
    	public List<bikePart> getInventory() {
		return inventoryList;
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

        //Add Inventory Method
    	public void addInventory(bikePart bp) {
    	    bikePart found = findInventory(bp);
    	    if(found == null) {
    	        inventoryList.add(bp);
    	    } else {
    	        System.out.println("Bike Part already exists!");
    	    }
    	}
    	
    	//Find Inventory Method
        public bikePart findInventory(bikePart bp) {
		for(bikePart i : inventoryList) {
			if(i.getNumber() == bp.getNumber()) {
				return i;
			}
		}
		return null;
	}
    	
	//getBp Method
	public bikePart getBp(int i) {
	    bikePart bp = inventoryList.get(i);
	    return bp;
	}
	
	//Get Size of ArrayList Method
	public int getSize() {
	    return inventoryList.size();
	}
	
	//Update Inventory Method
	private void updateInventory(bikePart bp) {
		for(bikePart x : inventoryList) {
		    if(x.getNumber() == bp.getNumber()) {
		        x.setPriceList(bp.getPriceList());
		        x.setPriceSale(bp.getPriceSale());
		        x.setOnSale(bp.getOnSale());
		        x.setQuantity(bp.getQuantity());
		    }
		}
	}
	
	//Update WarehouseDB Method
        public void updateWarehouseDB(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner read = new Scanner(file);
		while(read.hasNextLine()) {
			String line = read.nextLine();
			String regExp = "\\s*(\\s|,)\\s*";
			String bpi[] = line.split(regExp);
			String name = bpi[0];
			int number = Integer.parseInt(bpi[1]);
			double priceList = Double.parseDouble(bpi[2]);
			double priceSale = Double.parseDouble(bpi[3]);
			boolean onSale = Boolean.parseBoolean(bpi[4]);
			int quantity = Integer.parseInt(bpi[5]);
			bikePart bp = new bikePart(name, number, priceList, priceSale, onSale, quantity);
			addInventory(bp);
		}
		read.close();
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

	//Comparator for name
	public static Comparator<bikePart> SORT_BY_NAME = new Comparator<bikePart>() {
		@Override
		public int compare( bikePart bp1, bikePart bp2) {
			String bp1Name = bp1.getName();
			String bp2Name = bp2.getName();
			return bp1Name.compareTo(bp2Name);
		}
	};   
	
	//SortByName Method
	public bikePart findPartByName(String name) {
		for(bikePart bp : inventoryList) {
			if(bp.getName().equals(name)) {
				return bp;
			}
		}
		return null;
	}
		
	//save DB method
	public void saveWarehouseDB (String fileName) {
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			for(bikePart i : inventoryList) {
				writer.println(i.getName() + "," + i.getNumber() +
						"," + i.getPriceList() + "," + i.getPriceSale() +
						"," + i.getOnSale() + "," + i.getQuantity());
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("file error!");
		}
	} 
}
