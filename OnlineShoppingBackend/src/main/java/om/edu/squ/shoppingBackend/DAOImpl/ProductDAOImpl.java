package om.edu.squ.shoppingBackend.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import om.edu.squ.shoppingBackend.DAO.ProductDAO;
import om.edu.squ.shoppingBackend.DTO.Category;
import om.edu.squ.shoppingBackend.DTO.Product;

@Repository("productDao")
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	 private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		try{
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		String selectActiveProduct = "From Product where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		product.setActive(false);
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		String selectActiveProducts = "From Product where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts);
		query.setParameter("active", true);
		return query.getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsbyCategory(int CategoryId) {
		// TODO Auto-generated method stub
		String selectActiveProduct = "From Product where active = :active and categoryId = :catg";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
		query.setParameter("active", true);
		query.setParameter("catg", CategoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		String selectActiveProduct = "From Product where active = :active order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
		query.setParameter("active", true);
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.getResultList();
	}

	
}
