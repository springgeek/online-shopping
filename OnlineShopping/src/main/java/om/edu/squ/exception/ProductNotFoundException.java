package om.edu.squ.exception;

import java.io.Serializable;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class ProductNotFoundException extends Exception implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException(){
		this("product is not available");
	}

	public ProductNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		this.message = System.currentTimeMillis() + ": " + string;
	}

	public String getMessage() {
		return message;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView ProductNotFoundExceptionHandler(){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errortitle", "Product not available");
		mv.addObject("errordescription", "The product you are looking for is not available");
		mv.addObject("title", "Product unavailable");
		
		return mv;
	}
	
}
