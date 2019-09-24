import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		inventorySystem inventory = new inventorySystem();
		Scanner conIn = new Scanner(System.in);
		boolean on = true;
		
		while (on) {
			System.out.println("[1] Read File");
			System.out.println("[2] Enter Part");
			System.out.println("[3] Dsiplay Part");
			System.out.println("[4] Sell Part");
			System.out.println("[5] Sort Parts by Number");
			System.out.println("[6] Sort Parts by Name");
			System.out.println("[7] Quit");
			System.out.print("Enter number of the option you want: ");
		
			int input = conIn.nextInt();
			
			if (input == 1) {
				System.out.print("Enter name of file: ");
				String fileName = conIn.nextLine();
				inventory.readFile(fileName);
			}
			else if(input == 2) {
				inventory.enterPart();
				//Edit as you need for your method
			}
			else if(input == 3) {
				inventory.displayPart();
				//Edit as you need for your method
			}
			else if(input == 4) {
				inventory.sellPart();
				//Edit as you need for your method
			}
			else if(input == 5) {
				inventory.sortNumber();
				//Edit as you need for your method
			}
			else if(input == 6) {
				inventory.sortName();
				//Edit as you need for your method
			}
			else if(input == 7) {
				on = false;
				inventory.updateWarehouseDB();
				//Edit as you need for your method
			}
			
		}
		conIn.close();
	
	}

}
