package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Product;

public interface ProductService {
	
	
	public boolean addProduct(Product product);
	
	//for get list of books
	
	public List<Product> getAllPro();
	
	//delete
	
	public void delete(Integer id);
	
	//find by id
	public Product myUp(Integer id);
	
	

}
