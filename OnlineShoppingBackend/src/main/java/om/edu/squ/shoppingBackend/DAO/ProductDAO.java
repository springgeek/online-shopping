package om.edu.squ.shoppingBackend.DAO;

import java.util.List;

import om.edu.squ.shoppingBackend.DTO.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsbyCategory(int CategoryId);
	List<Product> getLatestActiveProducts(int count);
}
