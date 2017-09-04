package om.edu.squ.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefExceptionHandler {
 
	@ExceptionHandler(NoHandlerFoundException.class)
		public ModelAndView nohandlerFound(){
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("errortitle", "The page is not constructed");
			mv.addObject("errordescription", "The page you are looking for is not available");
			mv.addObject("title", "404 Error Page");
			
			return mv;
		}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView GeneralExceptionHandler(Exception ex){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errortitle", "Contact your admin!");
		mv.addObject("errordescription", ex.toString());
		mv.addObject("title", "Error");
		
		return mv;
	}
	
}
