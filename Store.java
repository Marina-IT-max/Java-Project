import java.util.ArrayList;
import java.util.List;

public class Store {
	private String name;
	private String address;
	private int establishmentaYear;
	private List <ProductsMenu> products;
	private List <Customerr> customers;
	//سازنده
	public Store(String name, String address , int establishmentaYear){
		this.name = name;
		this.address = address;
		this.establishmentaYear = establishmentaYear;
		this.products = new ArrayList<>();
		this.customers = new ArrayList<>();
	}
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductsMenu> getProducts() {
        return products;
    }

    public List<Customerr> getCustomers() {
        return customers;
    }

    public void updateProduct(String uniqueCode, ProductsMenu updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getUniqueCode().equals(uniqueCode)) {
                products.set(i, updatedProduct);
                break;
            }
        }
    }

    public void updateCustomer(String email, Customerr updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getEmail().equals(email)) {
                customers.set(i, updatedCustomer);
                break;
            }
        }
    }
	//امکانات مدیر:
	//متد برای افزودن محصول
	public void addProduct(ProductsMenu product){
		products.add(product);
	}

	public void showAllProducts(){
		for (ProductsMenu product : products){
			System.out.println("model : " +product.getModel()+ " , price : " +product.getPrice()+ " , stock : " +product.getStock()+ ", uniqueCode : " +product.getUniqueCode());
		}
	}
	//متد برای افزودن مشتری
	public void addCustomer(Customerr customer){
		customers.add(customer);
	}

	public void showAllCustomers(){
		for (Customerr customer : customers){
			System.out.println("name : " + customer.getName() + " , birth: " +customer.getBirth() + " , city : " + customer.getCity() + " , emaile : " + customer.getEmail());
		}
	}
	//حذف محصول
	public void removeProduct(ProductsMenu product){
		products.remove(product);
	}
	//جستجوی محصول
	public ProductsMenu searchProductByModel(String productModel){
		for (ProductsMenu product : products){
			if (product.getModel().equalsIgnoreCase(productModel)){
				return product;
			}
		}
		return null;
	}

	public Customerr SearchCustomerbyEmail(String email){
		for (Customerr customer: customers){
			if (customer.getEmail().contains(email)){
				return customer;
			}
		}
		return null;
	 }
	//متد برای نمایش اطلاعات فروشگاه
	public void displayStoreInfo(){
		System.out.println("name of store is : " +name);
		System.out.println("adress is : " +address);
		System.out.println("establishmentYear is : " +establishmentaYear);
	}
}
