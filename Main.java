import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		System.out.println("enter store details : ");
		System.out.println("enter the name of store : ");
		String StoreName=scanner.nextLine();
		System.out.println("enter the address of store : ");
		String address =scanner.nextLine();
		System.out.println("enter the establishment of store: ");
		int establishment =scanner.nextInt();
		scanner.nextLine();
        Store store = new Store(StoreName, address, establishment);

        // افزودن محصول به فروشگاه
		while(true){
        System.out.println("Enter product details:");
        System.out.println("enter the model :");
        String model = scanner.nextLine();
		
        System.out.println("enter the price : ");
        double price = scanner.nextDouble();
        System.out.println("enter the stock : ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // مصرف کردن newline
        System.out.print("Unique Code: ");
        String uniqueCode = scanner.nextLine();
		

        ProductsMenu newProduct = new ProductsMenu(model, price, stock, uniqueCode);
        store.addProduct(newProduct);
        System.out.println("Product added successfully!");

		System.out.println("do you want to add another product?  (yes/no) : ");
		String response = scanner.nextLine();
		if (response.equalsIgnoreCase("no")){
			break;
		}
	}

        // افزودن مشتری به فروشگاه
		while (true){
        System.out.println("Enter customer details:");
        System.out.println("enter customer name:");
        String name = scanner.nextLine();
		System.out.println("enter customer birth:");
		String birth = scanner.nextLine();
		System.out.println("enter customer city: ");
		String city = scanner.nextLine();
        System.out.println("enter customer email: ");
        String email = scanner.nextLine();

        Customerr newCustomer = new Customerr(name,birth,city, email);
        store.addCustomer(newCustomer);
        System.out.println("Customer added successfully!");

		System.out.println("do you want to add another customer?  (yes/no) : ");
		String response = scanner.nextLine();
		if (response.equalsIgnoreCase("no")){
			break;
		}
	}
        // منوی انتخابی برای عملیات مختلف
        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. View All Products");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Product by Model");
            System.out.println("4. Add Product to Customer Cart");
            System.out.println("5. Remove Product from Customer Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // مصرف کردن newline

            switch (choice) {
                case 1:
                    store.showAllProducts();
                    break;
                case 2:
                    store.showAllCustomers();
                    break;
                case 3:
				
				System.out.print("Enter model to search: ");
				String searchModel = scanner.nextLine();
				ProductsMenu foundProduct = store.searchProductByModel(searchModel);
				if (foundProduct != null) {
					System.out.println("Product found: "  + foundProduct);
					System.out.println("--------------------"); // خط جداکننده
					System.out.println(foundProduct.toString());  // اینجا متد toString استفاده میشه
				} else {
					System.out.println("Product not found!");
				}
				break;
			
                case 4:
                    // اضافه کردن محصول به سبد خرید مشتری
                    System.out.println("Enter customer email to add product:");
                    String customerEmail = scanner.nextLine();
                    Customerr customer = store.SearchCustomerbyEmail(customerEmail); // فراخوانی متد جستجو در Store
                    if (customer != null) {
                        System.out.println("Enter product model to add:");
                        String addModel = scanner.nextLine();
                        ProductsMenu productToAdd = store.searchProductByModel(addModel); // فراخوانی متد جستجو در Store
                        if (productToAdd != null) {
							if (productToAdd.getStock()>0){
								customer.addToCart(productToAdd);
								System.out.println("Product added to cart!");
							}else{
								System.out.println("product is out of stock");
							}
                            
                        } else {
                            System.out.println("Product not found!");
                        }
                    } else {
                        System.out.println("Customer not found!");
                    }
                    break;
                case 5:
                    // حذف محصول از سبد خرید مشتری
                    System.out.println("Enter customer email to remove product:");
                    customerEmail = scanner.nextLine();
                    customer = store.SearchCustomerbyEmail(customerEmail); // فراخوانی متد جستجو در Store
                    if (customer != null) {
                        System.out.println("Enter product model to remove:");
                        String removeModel = scanner.nextLine();
                        ProductsMenu productToRemove = store.searchProductByModel(removeModel); // فراخوانی متد جستجو در Store
                        if (productToRemove != null) {
                            customer.removeFromCart(productToRemove);
                            System.out.println("Product removed from cart!");
                        } else {
                            System.out.println("Product not found in cart!");
                        }
                    } else {
                        System.out.println("Customer not found!");
                    }
                    break;
                case 6:
                    // چک‌اوت و پرداخت
                    System.out.println("Enter customer email for checkout:");
                    customerEmail = scanner.nextLine();
                    customer = store.SearchCustomerbyEmail(customerEmail); // فراخوانی متد جستجو در Store
                    if (customer != null) {
                        customer.checkout();
                    } else {
                        System.out.println("Customer not found!");
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}





