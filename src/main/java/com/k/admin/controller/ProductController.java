package com.k.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.k.admin.dto.ProductDto;
import com.k.admin.entity.Product;
import com.k.admin.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
	
	

	List<String> messages = new ArrayList<>();

	ProductDto productFromTopic = null;

	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg() {
		return messages;
	}

	@GetMapping("/consumeJsonMessage")
	public ProductDto consumeJsonMessage() {
		return productFromTopic;
	}

	@KafkaListener(groupId = "java-1", topics = "productNotificationTopic", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		messages.add(data);
		return messages;
	}

	@KafkaListener(groupId = "java-2", topics = "productNotificationTopic-2", containerFactory = "productKafkaListenerContainerFactory")
	public ProductDto getJsonMsgFromTopic(ProductDto productDto) {
		productFromTopic = productDto;
		return productFromTopic;
	}
	
	
	
	@Autowired
	ProductService  productService;
	
	
	
	@RequestMapping("/getProducts")
	public ResponseEntity<?> getProducts()
	{
		 Map<String, Object> map= new HashMap<>();
		 
		 
		 List<Product> allProducts=productService.getAllProducts();
		 
		 if (!allProducts.isEmpty()) {
				map.put("status", 1);
				map.put("data", allProducts);
				return new ResponseEntity<>(map, HttpStatus.OK);
			} else {
				map.clear();
				map.put("status", 0);
				map.put("message", "Data is not found");
				return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
			}
		 
		
		
	}
	

	
	@PostMapping("/addProduct")

	public  ResponseEntity<?> saveProduct(@Valid @RequestBody  ProductDto productDto)
	{
		
				//productService.addProduct(productDto);

		
		Map<String, Object> map= new HashMap<>();
		 map.put("status", 1);
		 map.put("Msg", "Product added Successfully");
		 map.put("data", productService.addProduct(productDto));
		 
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/deleteAll")

	public  ResponseEntity<?> deleteAll()
	{
		
				//productService.addProduct(productDto);

		List<Product> all  = productService.getAllProducts();
		
		for(Product  p:all)
		{
			
			productService.deleteProductById(p.getPid());
			
		}
		Map<String, Object> map= new HashMap<>();
		 map.put("status", 1);
		 map.put("Msg", "All Product deleted Successfully");
		
		 
			return new ResponseEntity<>(map, HttpStatus.OK);
		
	}

	
	@PostMapping("/updateProduct/{id}")

	public ResponseEntity<?> updateProduct(@Valid @PathVariable String id,@RequestBody  ProductDto productDto)
	{
		
		 System.out.println("iddddd"+id);;

		ProductDto prods= productService.updateProduct(id,productDto);
		 

		 Map<String, Object> map= new HashMap<>();
		 map.put("status", 1);
		 map.put("Msg", "Product Price Updated Successfully");
		 map.put("data", prods);

			return new ResponseEntity<>(map, HttpStatus.OK);

		

	}
	

	@DeleteMapping("/deleteProduct/{id}")

	public  ResponseEntity<?>  deleteProductById( @PathVariable String id)
	{
		
		 productService.deleteProductById(id);
		 
		 Map<String, Object> map= new HashMap<>();
		 map.put("status", 1);
		 map.put("Msg", "Product with id" +id+  " deleted successfully");
		 
			return new ResponseEntity<>(map, HttpStatus.OK);
				 

		
	}
	
	
	@RequestMapping("/getProduct/{id}")

	public Product getProductById( @PathVariable String id)
	{
		
		 Product product=productService.getProductsById(id);
		 
		 return product;
				 

		
	}
	
	
	
	

}
