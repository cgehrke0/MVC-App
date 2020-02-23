package com.collabera.todoapp.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.collabera.todoapp.model.Todo;
import com.collabera.todoapp.services.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// dd/MM/yy
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value="/list_todos", method=RequestMethod.GET)
	public String listTodos(ModelMap model) {
		
		String name = getLoggedInUserName(model);
		model.put("todos", service.listTodos(name));
		return "list_todos";
	}

	private String getLoggedInUserName(ModelMap model) {
Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails)
			return((UserDetails)principal).getUsername();
		return principal.toString();
	}
	
	
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public String getAddTodos(ModelMap model) {
		Todo todo=new Todo(0,"Default Value",getLoggedInUserName(model), new Date(), false);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="/todo", method=RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		String  name = getLoggedInUserName(model);
		service.addTodo(todo.getDescription(), name, todo.getTargetDate(), false);
		return "redirect:/list_todos";
	}
	
	@RequestMapping(value="/deletetodo", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int todoId) {
		Todo todo =service.deleteTodo(todoId);
		
		return "redirect:/list_todos";
	}
	
	@RequestMapping(value="/edittodo", method=RequestMethod.GET)
	public String showEditTodo(ModelMap model, @RequestParam int todoId) {
		Todo todo =service.getTodo(todoId);
		model.addAttribute("todo", todo);
		return "todo";
	}
	@RequestMapping(value="/edittodo", method=RequestMethod.POST)
	public String EditTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		service.editTodo(todo);

		return "redirect:/list_todos";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null)
			new SecurityContextLogoutHandler().logout(request, response, auth);
		return "redirect:/";
	}
}
