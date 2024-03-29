package UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controllayer.*;
import Modellayer.*;

public class Tui {
	// Employee starter terminalen op.
	// Altså er logget ind før et salg er foretaget
	// passende med use case "Order Processing"
	public Tui() {
		Employee emp = new Employee("Hanne", "25252525", 1);
		LoginController ec = LoginController.getInstance();
		ec.login(emp);
	}

	public void start() {
		mainMenu();
	}
	
	private void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = userInput();
            switch (choice) {
                case 1:
                  newOrder();
                  break;
                case 2:
                	System.out.println("Ikke implementeret");
//                	createProduct();
                  break;
                case 3:
                	System.out.println("Ikke implementeret");
//                	createCustomer();
                	break;
                case 4:
                	System.out.println("Tak for denne gang.");
                    running = false;
                default:
                  System.out.println("Der er sket en uforklarlig fejl, choice = "+choice);
                  break;
            }
        }
    }
	
	private void createProduct() {
		ProductControllerIF pc = new ProductController();
		Scanner input = new Scanner(System.in);
		System.out.println("ProduktID (skal være >1)");
        System.out.print("   -> ");
        int pID = input.nextInt();
        input.nextLine();
        System.out.println();
        
        System.out.println("Produkt navn");
        System.out.print("   -> ");
        String pName = input.nextLine();
        System.out.println();
        
        System.out.println("Firma pris for produktet");
        System.out.print("   -> ");
        double purchasePrice = input.nextDouble();
        input.nextLine();
        System.out.println();
        
        System.out.println("Salgs pris for produktet");
        System.out.print("   -> ");
        double salePrice = input.nextDouble();
        input.nextLine();
        System.out.println();
		
        System.out.println("Låne pris for produktet");
        System.out.print("   -> ");
        double rentPrice = input.nextDouble();
        input.nextLine();
        System.out.println();
        
        System.out.println("Land produktet er fra");
        System.out.print("   -> ");
        String countryOR = input.nextLine();
        System.out.println();
        
        System.out.println("Mængde af varen på lager");
        System.out.print("   -> ");
        int minStock = input.nextInt();
        input.nextLine();
        System.out.println();
        
        System.out.println("Produkt barcode (max 13 tegn)");
        System.out.print("   -> ");
        String barcode = input.nextLine();
        System.out.println();
        
        pc.newProduct(pID,pName, purchasePrice, salePrice, rentPrice, countryOR, minStock, barcode);
        System.out.println(pName + " blev oprettet i systemet med '" + barcode + "' som barcode");
        System.out.println();
	}

	private void createCustomer() {
		// TODO Auto-generated method stub
		
	}

	private int userInput() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Hovedmenu ******");
        System.out.println(" (1) Foretag salg");
        System.out.println(" (2) Opret nyt Produkt");
        System.out.println(" (3) Opret ny Kunde");
        System.out.println(" (4) Afslut");
        System.out.print("\n Vælg:");
        
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
	
	private void newOrder() {
		OrderControllerIF oc = new OrderController();
		Order o = oc.createOrder();
		System.out.println("Nyt salg oprettet | Dato: " + o.getDate() + " | Medarbejder: " + o.getEmployee().getName());
		
		List<Orderline> olList = scanner(oc);
		for(Orderline ol : olList) {
			o.addOrderline(ol);
		}
		
		Customer c = customerSearcher(oc);
		o.addCustomer(c);
		System.out.println("   - " + c.getName() + " blev tilknyttet salget");
		
		// Payment
		Scanner input = new Scanner(System.in);
		System.out.println("Betalings metoder:");
		System.out.println("(1) Kontant");
		System.out.println("(2) Kort");
		while (!input.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            input.nextLine();
        }
		int payMethod = input.nextInt();
		double total = o.getTotalPrice();
		try {
			Order resOrder = oc.payment(o);
			System.out.println();
			System.out.println("Salget er nu gennemført.");
			for(Orderline ol : olList) {
				System.out.println(ol.getQuantity() + "x" + " " + ol.getProduct().getName());
			}
			System.out.println("                             Total beløb: " + total + "dkk");
			if (payMethod == 1) {
				System.out.println("                             Betalt kontant");
			} else {
				System.out.println("                             Betalt med kort");
			}
		} catch (Exception e) {
			System.out.println("Betaling misløkkede " + e.getMessage());
		}
		
		
	}
	
	private Customer customerSearcher(OrderControllerIF oc) {
		String email = getEmail();
		System.out.println();
		Customer c = oc.addCustomer(email);
		
		if (c == null) {
			System.out.println("Ingen konto findes med denne email - " + email);
			customerSearcher(oc);
		}
		
		return c;
	}

	protected String getEmail() {
		String res = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Indtast email");
		System.out.print("   -> ");
		res = keyboard.next();
		return res;
	}

	private List<Orderline> scanner(OrderControllerIF oc) {
    Scanner input = new Scanner(System.in);
    List<Orderline> orderlines = new ArrayList<>();
    Orderline ol = null;

    boolean isScanningProduct = true;

    while (isScanningProduct) {
    	System.out.println("Vil du scanne produkt? 'ja' | 'nej'");
        System.out.print("   -> ");
        String userInput = input.nextLine();
        System.out.println();
        
        if (userInput.equals("nej")) {
        	isScanningProduct = false;
        	break;
        }
        
        System.out.println("Indtast barcode (scan produkt)");
        System.out.print("   -> ");
        String barcode = input.nextLine();
        System.out.println();
        
        System.out.println("Indtast antallet du skal bruge (0 stopper scanning)");
        System.out.print("   -> ");
        int quantity = input.nextInt();
        input.nextLine();
        System.out.println();
        
        if (quantity == 0) {
        	isScanningProduct = false;
        } else {
        	try {
        		ol = oc.scanProduct(barcode, quantity);
        		if (ol == null) {
        			System.out.println("Intet produkt findes med den pågivne barcode: " + barcode);
        			continue;
        		}
        		orderlines.add(ol);
        		System.out.println(ol.getQuantity() + "x " + ol.getProduct().getName() + " blev tilføjet til salget");
        	} catch (Exception e) {
        		System.out.println("Der skete en fejl under oprettelse af ordrelinje: " + e.getMessage());
        	}
        }
    }
    return orderlines;
    }
}