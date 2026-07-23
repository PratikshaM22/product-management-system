package productDAO;
import java.util.Scanner;

import java.util.*;
import java.util.List;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        Scanner sc = new Scanner(System.in);
		        ProductDAO dao = new ProductDAOImpl();

		        int choice;
		        do {
		            System.out.println("========== PRODUCT MANAGEMENT SYSTEM ==========");
		            System.out.println("1. Add Product");
		            System.out.println("2. Update Product");
		            System.out.println("3. Delete Product");
		            System.out.println("4. Search Product");
		            System.out.println("5. Display All Products");
		            System.out.println("6. Search Product By Category");
		            System.out.println("7. Exit");
		         
		            System.out.print("Enter your choice: ");
		            choice = sc.nextInt();

		            switch (choice) {
		                case 1:
		                    System.out.print("Enter Product ID: ");
		                    int pid = sc.nextInt();
		                    sc.nextLine(); // consume newline
		                    System.out.print("Enter Product Name: ");
		                    String pname = sc.nextLine();
		                    System.out.print("Enter Price: ");
		                    double price = sc.nextDouble();
		                    sc.nextLine();
		                    System.out.print("Enter Category: ");
		                    String category = sc.nextLine();
		                    System.out.print("Enter Quantity: ");
		                    int quantity = sc.nextInt();

		                    Product p = new Product(pid, pname, price, category, quantity);
		                    dao.addProduct(p);
		                    break;

		                case 2:
		                    System.out.print("Enter Product ID to update: ");
		                    int upid = sc.nextInt();
		                    sc.nextLine();
		                    System.out.print("Enter New Name: ");
		                    String newName = sc.nextLine();
		                    System.out.print("Enter New Price: ");
		                    double newPrice = sc.nextDouble();
		                    sc.nextLine();
		                    System.out.print("Enter New Category: ");
		                    String newCategory = sc.nextLine();
		                    System.out.print("Enter New Quantity: ");
		                    int newQuantity = sc.nextInt();

		                    Product updated = new Product(upid, newName, newPrice, newCategory, newQuantity);
		                    dao.updateProduct(updated);
		                    break;

		                case 3:
		                    System.out.print("Enter Product ID to delete: ");
		                    int delId = sc.nextInt();
		                    dao.deleteProduct(delId);
		                    break;

		                case 4:
		                    System.out.print("Enter Product ID to search: ");
		                    int searchId = sc.nextInt();
		                    Product found = dao.searchProduct(searchId);
		                    if (found != null) {
		                        System.out.println("Product Found: " + found.getPid() + " | " + found.getPname() + " | " + found.getPrice() + " | " + found.getCategory() + " | " + found.getQuantity());
		                    } else {
		                        System.out.println("Product not found!");
		                    }
		                    break;

		                case 5:
		                    List<Product> list = dao.displayAllProducts();
		                    for (Product prod : list) {
		                        System.out.println(prod.getPid() + " | " + prod.getPname() + " | " + prod.getPrice() + " | " + prod.getCategory() + " | " + prod.getQuantity());
		                    }
		                    break;
		                    
		                case 6:

		                    sc.nextLine();

		                    System.out.print("Enter Category: ");

		                    category = sc.nextLine();

		                    List<Product> products = dao.searchByCategory(category);


		                    if(products.isEmpty()) {

		                        System.out.println("No products found!");

		                    } 
		                    else {

		                        for(Product prod : products) {

		                            System.out.println(
		                            prod.getPid()+" | "+
		                            prod.getPname()+" | "+
		                            prod.getPrice()+" | "+
		                            prod.getCategory()+" | "+
		                            prod.getQuantity()
		                            );
		                        }
		                    }

		                    break;

		                case 7:
		                    System.out.println("Exiting... Goodbye!");
		                    break;

		                default:
		                    System.out.println(" Invalid choice! Please try again.");
		            }
		        } while (choice != 7);

		        sc.close();
		    }
         }

