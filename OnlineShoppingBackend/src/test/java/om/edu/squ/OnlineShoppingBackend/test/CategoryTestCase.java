package om.edu.squ.OnlineShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import om.edu.squ.shoppingBackend.DAO.CategoryDAO;
import om.edu.squ.shoppingBackend.DTO.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDao;
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("om.edu.squ.shoppingBackend");
		context.refresh();
		categoryDao = (CategoryDAO)context.getBean("categoryDao");
	}
	
	/*@Test
	public void testAddCategory(){
		category = new Category();
		category.setName("Mobile");
		category.setDescription("Samsung");
		category.setImageUrl("img5.jpg");
		assertEquals("Successfully added a category", true, categoryDao.addCategory(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category = categoryDao.get(1);
		assertEquals("Successfully fetch a single category", "Television", category.getName());
		
	}*/
	
	/*@Test
	public void testupdateCategory(){
		category = categoryDao.get(2);
		category.setName("Laptop");
		category.setDescription("Fujitsu");
		assertEquals("Successfully updated a category", true, categoryDao.updateCategory(category));
	}*/
	
	/*@Test
	public void testdeleteCategory(){
		category = categoryDao.get(1);
		assertEquals("Successfully deleted a category", true, categoryDao.deleteCategory(category));
	}*/
	
	/*@Test
	public void testListCategory(){
		assertEquals("Successfully fetched categories", 2, categoryDao.list().size());
	}*/
	
	@Test
	public void testCRUDCategory(){
		//inserting data
		category = new Category();
		category.setName("Mobile");
		category.setDescription("IPhone");
		category.setImageUrl("img1.jpg");
		assertEquals("Successfully added a category", true, categoryDao.addCategory(category));
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("HP");
		category.setImageUrl("img2.jpg");
		assertEquals("Successfully added a category", true, categoryDao.addCategory(category));
		
		//updating data
		category = categoryDao.get(2);
		category.setName("Laptop");
		category.setDescription("Fujitsu");
		assertEquals("Successfully updated a category", true, categoryDao.updateCategory(category));
		
		//delete data
		category = categoryDao.get(2);
		assertEquals("Successfully deleted a category", true, categoryDao.deleteCategory(category));
		
		//list categories
		assertEquals("Successfully fetched categories", 1, categoryDao.list().size());
	}
}
