package util;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pojo.Product;

public class ReadXML {

 public static HashMap<String, Product> getProductInfos(){
	 HashMap<String, Product> productInfo = new HashMap<String, Product>();
	 try {
		
			File fXmlFile = new File("Products.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			//optional, but recommended
			doc.getDocumentElement().normalize();

			//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Product");

			//System.out.println("----------------------------");
			Product product = new Product();
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				//System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					product = new Product();
					Element eElement = (Element) nNode;
					
					product.setProdCode(eElement.getElementsByTagName("product_code").item(0).getTextContent());
					product.setProdName(eElement.getElementsByTagName("product_name").item(0).getTextContent());
					product.setProdPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
					productInfo.put(product.getProdCode(), product);
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
	 return productInfo;}
 
 public static void main(String args[]){
           getProductInfos();
 }
}
