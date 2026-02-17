public class ProductsMenu {
private double price;
private String model;
private int stock;
private String uniqueCode;
//متد سازنده
public ProductsMenu(String model, double price,int stock,String uniqueCode){
this.model=model;
this.price=price; 
this.stock=stock;
this.uniqueCode=uniqueCode;
}
//متد setter ,getter
public void setPrice(double p) {
	if (p>0) {
		price =p;
	}else { 
		System.out.println("wrong price");
	}
}
public void setModel(String model) {
	this.model=model;
}
public void setStock(int stock){
	if (stock >= 0){
		this.stock=stock;
	}else{
		System.out.println("empty");
	}
}
public void setUniqueCode(String uniqueCode){
	this.uniqueCode=uniqueCode;
}
public double getPrice() {
	return price;
}

public String getModel() {
	return model;
}
public int getStock(){
	return stock;
}
public String getUniqueCode() {
	return uniqueCode;
}

@Override
public String toString() {
    return "Product{" +
            "model='" + model + '\'' +
            ", price=" + price +
            ", stock=" + stock +
            ", uniqueCode='" + uniqueCode + '\'' +
            '}';
}
}

