import java.util.Scanner;

import util.Values;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {
		Cart cart = new Cart();
		
		scan = new Scanner(System.in);
		String prodCode = new String();
		
		System.out.println("If you have a promo code please enter, otherwise input anything to continue: ");
		String promoCode = scan.next();
		if(promoCode.equals(Values.PROMO_CODE)){
			cart = new Cart(promoCode);
		}
		
		int i = 0;
		while(true){
			i = 0;
			prodCode = new String();
			System.out.println("\nEnter 'x' on the Product Code to exit");
			System.out.println("Enter 'c' on the Product Code to compute the cart");
			System.out.println("Enter product code: ");
			prodCode = scan.next();
			if(prodCode.equals("x")){
				break;
			}
			if(prodCode.equals("c")){
				cart.items();
				cart.reset();
				System.out.println("If you have a promo code please enter, otherwise input anything to continue: ");
				promoCode = scan.next();
				if(promoCode.equals(Values.PROMO_CODE)){
					cart = new Cart(promoCode);
				}
			} else {
				System.out.println("Enter how many you want to buy: ");
				i = scan.nextInt();
				cart.add(prodCode, i);
			}
		}
	}

}
