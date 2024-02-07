package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Repo.ProductRepository;
import in.ashokit.entity.Product;
@Service
public class ProductServiceImp  implements ProductService{
    @Autowired
	private ProductRepository productRepo;
	
	@Override
	public boolean addProduct(Product product) {
		
		product.setActiveSw("Y");
		Product save = productRepo.save(product);
	  if(save.getProductId()!=null)
	  {
		return true;
	  }
	  return false;
	}

	@Override
	public List<Product> getAllPro() {
	return  productRepo.findByActiveSw("Y");
	}

	@Override
	public void delete(Integer id) {
		//this is hard delete..
//		productRepo.deleteById(id);
//		return false;
		
		//soft delete
		Optional<Product> findById = productRepo.findById(id);
		if(findById.isPresent())
		{
			Product product = findById.get();
			product.setActiveSw("N");
			productRepo.save(product);
			
		}
		
	}

	
	
	
	
	
	
	
	
	
	@Override
	public Product myUp(Integer id) {
		Optional<Product> findById = productRepo.findById(id);
		Product p=new Product();
		if(findById.isPresent())
		{
			Product product = findById.get();
			p=product;
		}
		
		return p;
	}

	

	

}
