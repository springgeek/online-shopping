package om.edu.squ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import om.edu.squ.shoppingBackend.DAO.ProductDAO;
import om.edu.squ.shoppingBackend.DTO.Product;

@Controller
@RequestMapping("/json/data")
public class JSONDataController {

	@Autowired
	ProductDAO productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDao.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable("id") int id){
		
		return productDao.listActiveProductsbyCategory(id);
	}
}
