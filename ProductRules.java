import java.util.HashMap;

import pojo.Product;
import util.Values;



public class ProductRules {

	public static double threeForTwo(Product product){


		int applicable = 0;

		applicable = (product.getOrderCnt() - product.getOrderCnt()%3)/3;
		
		double regPricedProductCost = (product.getOrderCnt() - applicable*3)*product.getProdPrice();
		double promotionProductCost = applicable*product.getProdPrice()*2;
		double roundedOff =  0.00;
		roundedOff = Math.round((regPricedProductCost+promotionProductCost)*100.0)/100.0;
		
		return  roundedOff;
		
	}
	public static double moreThanThree(Product product){
		
		double cost = 0;
		
		if(product.getOrderCnt() > 3){
			cost = product.getOrderCnt()*Values.ULT_LARGE_PRICE_DISCOUNTED;
		} else {
			cost = product.getOrderCnt()*product.getProdPrice();
		}
		
		double roundedOff =  0.00;
		roundedOff = Math.round(cost*100.0)/100.0;
		
		return  roundedOff;
		
	}

	public static HashMap<String, Product> freeOneGB(HashMap<String, Product> productInfo, HashMap<String, Product> orderList){
		Product product = new Product();
		Product productOneGB = new Product();
		if(orderList.containsKey(Values.ULT_MEDIUM)){
			product = orderList.get(Values.ULT_MEDIUM);
			if(orderList.containsKey(Values.ONEGB)){
				productOneGB = orderList.get(Values.ONEGB);
				productOneGB.setFreeCnt(product.getOrderCnt());
				if(product.getOrderCnt()>=productOneGB.getOrderCnt()){
					productOneGB.setOrderCnt(product.getOrderCnt());
				}
				orderList.replace(Values.ONEGB, productOneGB);
			} else {
				productOneGB = productInfo.get(Values.ONEGB);
				productOneGB.setOrderCnt(product.getOrderCnt());
				productOneGB.setFreeCnt(product.getOrderCnt());
				orderList.put(Values.ONEGB, productOneGB);
			}
		}

		return  orderList;
	}
	public static double applyPromoCodeDiscount(double totalCost, String promoCode){
		if(promoCode.equals(Values.PROMO_CODE)){
			totalCost = totalCost*.9;
		}
		double roundedOff =  0.00;
		roundedOff = Math.round(totalCost*100.0)/100.0;
		
		return  roundedOff;
	}
}
