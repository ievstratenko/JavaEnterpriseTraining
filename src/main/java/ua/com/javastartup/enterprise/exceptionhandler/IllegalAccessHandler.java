package ua.com.javastartup.enterprise.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IllegalAccessHandler {

	@ExceptionHandler(IllegalAccessException.class)
	public String handle(Model model, Exception ex) {
		System.out.println(ex);
		model.addAttribute("ex", ex);
		model.addAttribute("exClass", IllegalAccessException.class);		
		return "error";
	}
}
