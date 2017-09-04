package om.edu.squ.shoppingBackend.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import om.edu.squ.shoppingBackend.DAO.CategoryDAO;
import om.edu.squ.shoppingBackend.DTO.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDAOImpl  implements CategoryDAO{

	@Autowired
	 private SessionFactory sessionFactory;
	
	/*private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("LG");
		category.setImageUrl("img1.jpg");
		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Samsung");
		category.setImageUrl("img2.jpg");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Desktop");
		category.setDescription("HP");
		category.setImageUrl("img3.jpg");
		
		categories.add(category);
	}*/
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		String selectActiveCategory = "From Category where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		/*for(Category catg : categories)
		{
			if(catg.getId()==id){
				return catg;
			}
		}*/
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		category.setActive(false);
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

}
