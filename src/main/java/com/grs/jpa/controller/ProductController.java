package com.grs.jpa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grs.jpa.domain.Product;
import com.grs.jpa.domain.SignupForm;
import com.grs.jpa.service.ProductService;
import com.grs.jpa.service.UserService;



@Controller
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/")
	public ModelAndView viewHomePage(Model model ,HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView("index");
		List<Product> productList = productService.listAll(); 
		System.out.println("*********************************************************=======>"+productList);
		for (Product product : productList) {
			System.out.println("******************************************"+product.getName());
		}
		
		model.addAttribute("productList",productList);
		
		// initialize PagedListHolder with our list, set current page defaulted to 0, and pass it to the view
				PagedListHolder<Product> pagedListHolder = new PagedListHolder<Product>(productList);
				int page = ServletRequestUtils.getIntParameter(request, "p", 0);
				pagedListHolder.setPage(page);
				int pageSize = 5;
				pagedListHolder.setPageSize(pageSize);
				mav.addObject("pagedListHolder", pagedListHolder);
		
		return mav;
	}
	
	
	@RequestMapping(path = "/sortHomePage")
	public ModelAndView sortHomePage(Model model ,HttpServletRequest request, HttpServletResponse response,@RequestParam(required = false) String eventName)
	{
		System.out.println("the Event hit is............................................ "+eventName);
		ModelAndView mav = new ModelAndView("index");
		List<Product> productList = productService.listAll(); 
		
		
		HttpSession session = request.getSession();
		
	   sortColumnsBasedOnEventTypeValue(eventName,productList,session);
		
		// initialize PagedListHolder with our list, set current page defaulted to 0, and pass it to the view
				PagedListHolder<Product> pagedListHolder = new PagedListHolder<Product>(productList);
				int page = ServletRequestUtils.getIntParameter(request, "p", 0);
				pagedListHolder.setPage(page);
				int pageSize = 5;
				pagedListHolder.setPageSize(pageSize);
				mav.addObject("pagedListHolder", pagedListHolder);
		
				model.addAttribute("productList",productList);
		return mav;
	}
	
	private void sortColumnsBasedOnEventTypeValue(String eventName,List<Product>productList,HttpSession session) {
		
		if(eventName.equals("sortByProductIdAsc"))
		{
			session.setAttribute("sortById","desc");
			PropertyComparator.sort(productList, new MutableSortDefinition("id", true, true));
		}else if(eventName.equals("sortByProductIdDesc"))
		{
			session.setAttribute("sortById","asc");
			PropertyComparator.sort(productList, new MutableSortDefinition("id",true,false));
		}
		if(eventName.equals("sortByNameAsc"))
		{
			session.setAttribute("sortByName", "desc");
			PropertyComparator.sort(productList, new MutableSortDefinition("name", true,true));
		}else if(eventName.equals("sortByNameDesc"))
		{
			session.setAttribute("sortByName","asc" );
			PropertyComparator.sort(productList,new MutableSortDefinition("name",true,false ) );
		}
		if(eventName.equals("sortByBrandAsc"))
		{
			session.setAttribute("sortByBrand", "desc");
			PropertyComparator.sort(productList, new MutableSortDefinition("brand",true,true));
		}else if(eventName.equals("sortByBrandDesc"))
		{
			session.setAttribute("sortByBrand", "asc");
			PropertyComparator.sort(productList, new MutableSortDefinition("brand",true,false));
		}
		if(eventName.equals("sortByModelAsc"))
		{
			session.setAttribute("sortByModel", "desc");
			PropertyComparator.sort(productList, new MutableSortDefinition("model",true,true));
		}else if(eventName.equals("sortByModelDesc"))
		{
			session.setAttribute("sortByModel", "asc");
			PropertyComparator.sort(productList, new MutableSortDefinition("model",true,false));
		}
		if(eventName.equals("sortByPriceAsc"))
		{
			session.setAttribute("sortByPrice", "desc");
			PropertyComparator.sort(productList, new MutableSortDefinition("model",true,true));
		}else if(eventName.equals("sortByPriceDesc"))
		{
			session.setAttribute("sortByPrice", "asc");
			PropertyComparator.sort(productList, new MutableSortDefinition("model",true,false));
		}
	}


	@RequestMapping(path="/new")
	  public String  showNewProductForm() {
	  
		return "newProduct";
	 }
	 
	 
	 @PostMapping(path="/save")
	  public String saveProduct(@Valid Product prod ,BindingResult result,@ModelAttribute Product product,Model model) {
		 System.out.println("product Details ***************************************************************************"+ product.getBrand());
		 if(result.hasErrors()) {
			 if(result.getFieldError().getField().contains("brand"))
				 model.addAttribute("modelError",result.getFieldError().getField()+result.getFieldError().getDefaultMessage());
			 return "editForm";
		 }
		 productService.save(product);
		 return "redirect:/";
	  }
	 
	 @GetMapping(path="/edit")
	  public String showEditProductForm(HttpServletRequest request) {
		  String id = request.getParameter("id");
		  System.out.println("id is for edit ***************"+id);
		  return "redirect:/editProduct?id="+id;
	  }
	 
	 
	 @GetMapping(path="/delete")
	  public String  deleteProduct(HttpServletRequest request) {
		  String id = request.getParameter("id");
		  System.out.println("id is ***************"+id);
		  productService.delete(Long.parseLong(id));
		  return "redirect:/";
		  
	  }
	 
	 
	 @GetMapping(path="/editProduct")
	 public String editProduct(@RequestParam("id") Long id,Model model)
	 {
		 Product product = productService.get(id);
		 System.out.println("product******************************\n"+product);
		 model.addAttribute("product",product);
		 return "editForm";
	 }
	 
	@GetMapping(path="/signup")
	public String signUp(Model model)
	{
		model.addAttribute( new SignupForm());
		
		return "signup";
	}
	
	
	@PostMapping(path="/signup")
	public String singup(@ModelAttribute("signupForm") @Valid SignupForm signupForm,BindingResult result,RedirectAttributes redirectAttribute)
	{
	   if(result.hasErrors())
	   {
		   return "signup";
	   }
	   System.out.println(signupForm);	
	   
	   userService.signup(signupForm);
	   
	   redirectAttribute.addAttribute("flashMessage", "Successfully Added User");
	   redirectAttribute.addAttribute("flashMessageUser",signupForm.getUserName());
	   
	   return "redirect:/";
	}
}
