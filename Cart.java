import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import pojo.Product;
import util.ReadXML;
import util.Values;



public class Cart {
	Cart(){
		//Saved on a map with product code as key
		productInfo = ReadXML.getProductInfos();
		promoCode = new String();
	}
	Cart(String promoCodeInput){
		//Saved on a map with product code as key
		productInfo = ReadXML.getProductInfos();
		promoCode = promoCodeInput;
	}
	
	HashMap<String, Product> orderList = new HashMap<String, Product>();
	HashMap<String, Product> productInfo = new HashMap<String, Product>();
	String promoCode = new String();
	
void add(String prodCode, int orderCnt){

	Product product = new Product();
	product = productInfo.get(prodCode);
	product.setOrderCnt(orderCnt);

	if(orderList.containsKey(prodCode)){
		orderList.replace(prodCode, product);
	} else {
		orderList.put(prodCode, product);
	}
}
void items(){
	
	orderList = ProductRules.freeOneGB(productInfo, orderList);
	Set<String> keys = orderList.keySet();
	double totalCost = 0.0;
	for (Iterator<String> i = keys.iterator(); i.hasNext(); ) {
	       String key = (String) i.next();
	       Product value = (Product) orderList.get(key);
	       if(key.equals(Values.UTL_SMALL)){
	    	   totalCost += ProductRules.threeForTwo(value);
	    	   System.out.println(value.getProdName()
		    		  + " X " + value.getOrderCnt() + " = $"+ ProductRules.threeForTwo(value));
	       } else if(key.equals(Values.ULT_MEDIUM)){
	    	   totalCost += value.getOrderCnt()*value.getProdPrice();
	    	   System.out.println(value.getProdName()
			    		  + " X " + value.getOrderCnt() + " = $"+  value.getOrderCnt()*value.getProdPrice());
	       } else if(key.equals(Values.ULT_LARGE)){
	    	   totalCost += ProductRules.moreThanThree(value);
	    	   System.out.println(value.getProdName()
		    		  + " X " + value.getOrderCnt() + " = $"+ ProductRules.moreThanThree(value));
	       } else if(key.equals(Values.ONEGB)){
	    	   totalCost += (value.getOrderCnt()-value.getFreeCnt())*value.getProdPrice();
	    	   System.out.println(value.getProdName()
		    		  + " X " + value.getOrderCnt() + " = $"+ (value.getOrderCnt()-value.getFreeCnt())*value.getProdPrice());
	       }
	 }

	if(promoCode.equals(Values.PROMO_CODE)){
		totalCost = Math.round(totalCost*90.0)/100.0;
	} else {
		totalCost = Math.round(totalCost*100.0)/100.0;
	}
	
    
    System.out.println("\nTotal Cost: $"+totalCost);
}
void reset(){
	orderList = new HashMap<String, Product>();
}

}
