import java.util.ArrayList;
import java.util.List;
public class Customerr {
private String name;
private String birth;
private String city;
private String email;
private List<ProductsMenu> shoppingCart;
//متد سازنده
public  Customerr(String name,String birth, String city,String email){
 this.name = name;
 this.birth = birth;
 this.city = city;
 this.email = email;
 this.shoppingCart = new ArrayList<>();
}
//setter,getter متد
 public void setName(String name) {
	 this.name = name;
 }
 public void setBirth(String birth) {
	 this.birth = birth;
 }
 public void setCity(String city) {
	 this.city = city;
 }
 public void setEmail(String email){
	this.email = email;
 }
 public String getName() {
	 return name;
 }
 public String getCity() {
	 return city;
 }
 public String getBirth() {
	 return birth;
 }
 public String getEmail(){
	return email;
 }
 public List<ProductsMenu> getShoppingCart(){
	return shoppingCart;
 }
//تابع اضافه کردن به سبد خرید
public void addToCart(ProductsMenu product) {
	shoppingCart.add(product);
}
 
 //تابع حذف از سبد خرید
 public void removeFromCart(ProductsMenu product) {
	shoppingCart.remove(product);
}

  //تابع محاسبه قیمت
  public void checkout() {
    double totalCost = 0;
    System.out.println("Invoice for " + name + ":");
    for (ProductsMenu product : shoppingCart) {
        System.out.println("Product: " + product.getModel() + ", Price: " + product.getPrice());
        totalCost += product.getPrice();
    }
    System.out.println("Total Cost: " + totalCost);
    shoppingCart.clear();  // خالی کردن سبد خرید پس از پرداخت
}



 //تابع نمایش دادن اطلاعات
 @Override
 public String toString() {
	 return "Name: " + name + ",Birth : " + birth + ",City : " + city + ",Emaile : " +email;}
}



