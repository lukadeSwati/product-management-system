package com.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanagement.model.Product;
import com.productmanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	

	@Override
	public Product saveProduct(Product product) {
		
		return repo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
	
		return repo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		
		return repo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product=repo.findById(id).get();
		
		if(product!=null)
		{
			repo.delete(product);
			return "product delete successfully";
		}
		return "Something wrong on server";
		
		
	}

	@Override
	public Product editProduct(Product p, Integer id) {
		
		Product oldProduct=repo.findById(id).get();
		
		oldProduct.setProductname(p.getProductname());
		oldProduct.setDescription(p.getDescription());
		oldProduct.setPrice(p.getPrice());
		oldProduct.setStatus(p.getStatus());
		
		return repo.save(oldProduct);
	}
	
	

}
