package om.edu.squ.OnlineShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import om.edu.squ.shoppingBackend.DAO.ProductDAO;
import om.edu.squ.shoppingBackend.DTO.Product;


public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDao;
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("om.edu.squ.shoppingBackend");
		context.refresh();
		productDao = (ProductDAO)context.getBean("productDao");
	}
	
	/*@Test
	public void testCRUDCategory(){
		//inserting data
		product = new Product();
		product.setName("Test Product");
		product.setActive(true);
		product.setBrand("LG");
		product.setCategoryId(3);
		product.setSupplierId(3);
		product.setUnitPrice(25000);
		product.setDescription("Testing entering a new product");
		assertEquals("something went wrong whilst entering a new product", true, productDao.addProduct(product));
		//updating data
		
		product = productDao.get(2);
		product.setDescription("Updated Description");
		assertEquals("something went wrong whilst updating a product", true, productDao.updateProduct(product));
		
		assertEquals("something went wrong whilst deleting a product", true, productDao.deleteProduct(product));
		
		//assertEquals("something went wrong whilst listing products", 6, productDao.list().size());
	}*/
	@Test
	public void testCRUDCategory(){
		assertEquals("something went wrong whilst listing products", 5, productDao.listActiveProducts().size());
	
	}
}
