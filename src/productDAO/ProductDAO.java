package productDAO;
import java.util.List;


public interface ProductDAO {
		
		void addProduct(Product  p);
		void updateProduct(Product p);
		void deleteProduct(int pid);
		Product searchProduct(int id);
		List<Product> displayAllProducts();
		List<Product> searchByCategory(String category);

}



