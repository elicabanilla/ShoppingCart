package pojo;

public class Product {
 String prodCode = new String();
 double prodPrice = 0.0;
 String prodName = new String();
 int orderCnt = 0;
 int freeCnt = 0;


public String getProdCode() {
	return prodCode;
}
public void setProdCode(String prodCode) {
	this.prodCode = prodCode;
}
public double getProdPrice() {
	return prodPrice;
}
public void setProdPrice(double prodPrice) {
	this.prodPrice = prodPrice;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public int getOrderCnt() {
	return orderCnt;
}
public void setOrderCnt(int orderCnt) {
	this.orderCnt = orderCnt;
}
public int getFreeCnt() {
	return freeCnt;
}
public void setFreeCnt(int freeCnt) {
	this.freeCnt = freeCnt;
}

}
