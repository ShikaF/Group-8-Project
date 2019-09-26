package src;


public class bikePart {
	private String name;
	private int number;
	private double priceList;
	private double priceSale;
	private boolean onSale;
	private int quantity;
	
	/**Creates a bikePart object with all the fields filled with the corresponding variable.
	 * 
	 * @param name the name of the part.
	 * @param number the number of the part.
	 * @param priceList the listed price of the part.
	 * @param priceSale the sale price of the part.
	 * @param onSale whether or not the part is on sale.
	 */
	public bikePart(String name, int number, double priceList, double priceSale, boolean onSale, int quantity) {
		this.name = name;
		this.number = number;
		this.priceList = priceList;
		this.priceSale = priceSale;
		this.onSale = onSale;
		this.quantity = quantity;
	}

	/**Getter method for the name field
	 * 
	 * @return name of the part.
	 */
	public String getName() {
		return name;
	}
	
	/**Setter method for the name field.
	 * 
	 * @param name The name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**Getter method for the number field
	 * 
	 * @return number of the part.
	 */
	public int getNumber() {
		return number;
	}
	
	/**Setter method for the number field.
	 * 
	 * @param number The number to be set.
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**Getter method for the priceList field
	 * 
	 * @return priceList of the part.
	 */
	public double getPriceList() {
		return priceList;
	}
	
	/**Setter method for the priceList field.
	 * 
	 * @param prcelist The priceList to be set.
	 */
	public void setPriceList(double priceList) {
		this.priceList = priceList;
	}
	
	/**Getter method for the priceSale field
	 * 
	 * @return priceSale of the part.
	 */
	public double getPriceSale() {
		return priceSale;
	}
	
	/**Setter method for the priceSale field.
	 * 
	 * @param priceSale The priceSale to be set.
	 */
	public void setPriceSale(double priceSale) {
		this.priceSale = priceSale;
	}
	
	/**Getter method for the onSale field
	 * 
	 * @return onSale of the part.
	 */
	public boolean getOnSale() {
		return onSale;
	}
	/**Setter method for the onSale field.
	 * 
	 * @param onSale The onSale to be set.
	 */
	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}	
	
	/**Getter method for the quantity field
	 * 
	 * @return quantity of the part.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**Setter method for the quantity field.
	 * 
	 * @param quantity The quantity to be set.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/** Override of the toString method giving a list of the fields of the object.
	 * 
	 * @return a String containing information on all of the field of this method.
	 */
	@Override
	public String toString() {
		return name + "," + number + "," + priceList + "," + priceSale + "," + onSale + "," + quantity;
	}
}
