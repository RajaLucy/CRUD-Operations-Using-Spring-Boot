package in.ashokit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.Repo.ProductRepository;
import in.ashokit.entity.Product;
import in.ashokit.service.ProductServiceImp;

@Controller
public class ProductController {
	
	@Autowired
    private ProductServiceImp productSer;
	@Autowired
	private ProductRepository productRepo;
	
	//to load the form get mapping
	@GetMapping("/form")
	public ModelAndView form()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("product",new Product()); //this defines...this form should load the only product entity class
		mv.setViewName("form");
		return mv;
	}
	
	//insert data into table from the data
	//u have to use Post mapping...method post
	@PostMapping("/add")
	public ModelAndView addProduct(Product product)
	{
		boolean b = productSer.addProduct(product);
		ModelAndView mv=new ModelAndView();
		if(b)
		{
			mv.addObject("suc", "Prodcut Saved");
		}
		else {
			mv.addObject("fail", "Prodcut not Saved");
		}
		mv.setViewName("form");
		
	   
		return mv;
	}
	
	
	//now to u have to show list of records from the table
	@GetMapping("/list")
	public ModelAndView getReocrds()
	{
		ModelAndView mv=new ModelAndView();
		List<Product> list = productSer.getAllPro();
		
		mv.addObject("products", list);
		mv.setViewName("show");
		return mv;
		
	}
	
////	//delete that record
//	@GetMapping("/delete")
//	public String Delete(@RequestParam Integer productId)
//	{
//		productRepo.deleteById(productId);
//		return "redirect:/list";
//		
//	}
	
	//update form 
	@GetMapping("/update")
	public String update(@RequestParam Integer productId ,Model model)
	{
		//ModelAndView mv=new ModelAndView("form");
//		Product myUp = productSer.myUp(productId);
		
		Product product = productRepo.findById(productId).get();
		model.addAttribute("product", product);
		
		return "form";
		
	}
	
	
	@GetMapping("/delete")
	public ModelAndView Delete(@RequestParam Integer productId)
	{
		 ModelAndView mv =new ModelAndView();
	     productSer.delete(productId);
	     List<Product> allPro = productSer.getAllPro();
	     mv.addObject("products", allPro);
	     mv.setViewName("show");
	     return mv;
		
		
	}
	
	
	
	

}
