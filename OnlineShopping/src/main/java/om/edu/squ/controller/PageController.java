package om.edu.squ.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import om.edu.squ.exception.ProductNotFoundException;
import om.edu.squ.shoppingBackend.DAO.CategoryDAO;
import om.edu.squ.shoppingBackend.DAO.ProductDAO;
import om.edu.squ.shoppingBackend.DTO.Category;
import om.edu.squ.shoppingBackend.DTO.Product;



@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
			
			
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired
	private ProductDAO productDao;
	
	
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		logger.info("Inside PageController index method- INFO");
		logger.debug("Inside page Controller index method - DEBUG");
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickHome", true);
		return mv;
		
	}
	
	@RequestMapping(value={"/about"})
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
		
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
		
	}
	
	@RequestMapping(value="/showProducts")
	public ModelAndView showAllProducts(){
		System.out.println("Enters in showAllProducts");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
		
	}
	
	
	@RequestMapping("/showProduct/{id}")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("page");
		
		Category category = null;
		category = categoryDao.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDao.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
		
	}
	
	@RequestMapping("/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{
		System.out.println("Enters in showSingleProduct");
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDao.get(id);
		if(product == null){
			throw new ProductNotFoundException();
		}
		product.setViews(product.getViews()+1);
		productDao.updateProduct(product);
		System.out.println(product.toString());
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		return mv;
		
	}
}

