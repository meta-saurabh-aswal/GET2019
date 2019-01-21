import java.util.*;

//class of items with its name, price and quantity

class Item{
	
	private String name;
	private int quantity;
	private double price;
	
	Item(String name,double price,int quantity){
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;	
	}
	
	public String toString() {
		return name + "\t" + price+ "\t"+ quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getItemName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void updateQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public void setQuantity(int val) {
		this.quantity = val;
	}
}

public class ShoppingCart {
	
	static ShoppingCart cart;
	private static List<Object> cartItemsList;
	private static List<Object> allItemsList;
	private int choice;
	static Scanner sc = new Scanner(System.in);
	static Item item;
	
	//for initializing the total list of items
	
	ShoppingCart(){
		
		allItemsList = new ArrayList<>();			//list of total number of items
		cartItemsList = new ArrayList<>();			//list of items in cart
		
		allItemsList.add(new Item("Shoe",500,0));
		allItemsList.add(new Item("Shirt",300,0));
		allItemsList.add(new Item("Jeans",700,0));
		allItemsList.add(new Item("Bag",400,0));
		allItemsList.add(new Item("Wallet",50,0));
		
	}
	
	public static void main(String args[]) {
		
		cart = new ShoppingCart();
		
		while(true) {
			
			cart.menu();			//a menu for choosing options
		}
		
	}
	
	public void menu() {
		
		showAllItems();
		
		System.out.println(" 1.Add Item to cart \n 2.Remove Item from cart \n 3.See Items present in cart \n 4.Update cart items quantity \n 5.Billing of cart Items \n");
		System.out.println("Enter your choice : ");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			addCartItem();
			break;
		case 2:
			removeCartItem();
			break;
		case 3:
			showCartItems();
			break;
		case 4:
			updateCartItem();
			break;
		case 5:
			billingCartItems();
			break;
		default:
			System.out.println("Wrong Input! Try Again...");
		}
	}
	
	public void billingCartItems() {
		double bill = 0;
		
		Iterator itr = cartItemsList.iterator();
		while(itr.hasNext()){
			Item i = (Item)itr.next();
			bill += i.getPrice() * i.getQuantity();
		}
		System.out.println("Final bill for following items : ");
		showCartItems();
		System.out.println("\nTotal bill : "+ bill + "Rupees");
		System.exit(0);
	}
	
	public void showCartItems() {
		
		if(cartItemsList.isEmpty()) {
			System.out.println("\nCart is Empty");
		}
		else {
			System.out.println("\nCart Items given with their price are :");
			System.out.println("Product\tPrice\tQuantity");
			Iterator itr = cartItemsList.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
	}
	
	public void updateCartItem() {
		
		if(cartItemsList.isEmpty()) {
			
			System.out.println("Cart is already Empty");
		}
		else {
		
			String itemName;
			int quant;
			System.out.println("Enter item name to change its quantity : ");
			itemName = sc.next();
			
			//checking if the item is already present in the list or not
			
			if(checkIfPresent(itemName)) {
					
				if(cartItemsList.contains(item)) {
					System.out.println("Set quantity to : ");
					quant = sc.nextInt();
					if(quant <= 0)
					{
						cartItemsList.remove(item);
						item.setQuantity(0);
					}	
					item.setQuantity(quant);				//updating quantity if item is already present
				}
				else{
					System.out.println("This item is not present in your cart.");
				}
			}
			else {
				System.out.println("No product with such name.");
			}
		}
	}
	
	//adding an item to the cart
	
	public void addCartItem() {
		
		String itemName;
		System.out.println("Enter item name to add it to cart : ");
		itemName = sc.next();
		
		if(checkIfPresent(itemName)) {			//checking if item is present in the cart
		
			if(cartItemsList.isEmpty()) {			//checking if the cart is empty
				
				cartItemsList.add(item);			//adding the item to the cart if the cart is empty
				item.updateQuantity(1);
			}
			else {
				
				if(cartItemsList.contains(item)) {
					item.updateQuantity(1);			//updating the quantity of the item if its already present in the cart
				}
				else
				{
					cartItemsList.add(item);
					item.updateQuantity(1);
				}
			}
		}
		else {
			System.out.println("No product with such name.");
		}
	}
	
	//removing an item from the cart
	
	public void removeCartItem() {
		
		if(cartItemsList.isEmpty()) {
			
			System.out.println("Cart is already Empty");
		}
		else {
		
			String itemName;
			System.out.println("Enter item name to remove it from cart : ");
			itemName = sc.next();
		
			if(checkIfPresent(itemName)) {
					
				if(cartItemsList.contains(item)) {
						
					cartItemsList.remove(item);
					item.setQuantity(0);
				}
				else{
					System.out.println("This item is not present in your cart.");
				}
			}
			else {
				System.out.println("No product with such name.");
			}
		}
	}
	
	//displaying all items in the cart
	
	public void showAllItems() {
		
		System.out.println("\nItems present on our site with the prices are :");
		//System.out.println(allItemsList.toString()+"\n");
		
		System.out.println("Product\tPrice\tQuantity");
		
		Iterator itr = allItemsList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
	
	public Boolean checkIfPresent(String name) {
		
		Iterator itr = allItemsList.iterator();
		while(itr.hasNext()) {
			item = (Item)itr.next();
			
			if(item.getItemName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
}