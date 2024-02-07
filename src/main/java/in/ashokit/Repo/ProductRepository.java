package in.ashokit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	
	public List<Product> findByActiveSw(String activeSw);
}
