package om.edu.squ.shoppingBackend.DAO;

import java.util.List;

import om.edu.squ.shoppingBackend.DTO.Category;

public interface CategoryDAO{

	public List<Category> list();
	public Category get(int id);
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	
}
