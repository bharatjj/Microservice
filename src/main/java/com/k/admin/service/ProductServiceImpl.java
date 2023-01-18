package com.k.admin.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.k.admin.dto.PriceDto;
import com.k.admin.dto.ProductDto;
import com.k.admin.entity.Product;
import com.k.admin.repository.ProductRepository;
import com.k.admin.util.MailServerClass;






@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private MailServerClass mailService;
	
	
	@Autowired
	private  KafkaTemplate<String,Object> kafkaTemplate;
	

	
	 
	@Autowired
	ProductRepository   productRepository;
	
	
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		
		


		
		Product product = new Product();
		
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		Product products =productRepository.save(product);
		
		

		
		ProductDto products1= new ProductDto();
		
		products1.setDescription(products.getDescription());
		products1.setName(products.getName());
		products1.setPid(products.getPid());
		products1.setPriceId(products.getPriceId()
				);
		products1.setValue(products.getPrice());
		
       // JSONObject jsonObj = new JSONObject(products1);

		//kafkaTemplate.send("productNotificationTopic", products.getPid());
		kafkaTemplate.send("productNotificationTopic", products1.toString());
		Map<String,Object> m= new HashMap<>();
		Map<String,Object> m1= new HashMap<>();

		
		m.put("id",products.getPid());

		m.put("name",products.getName());
		m.put("description",products.getDescription());
		m1.put("productdetails",m);

		  
		//sending email
		mailService.sendMail(m1);
	
		
		return products1;
	}

	
	public ProductDto updateProduct(String id,ProductDto productDto) {
		
		
		 RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		

		
		// HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("admin", "password");
		headers.setContentType(MediaType.APPLICATION_JSON);

        
		PriceDto priceDto= new PriceDto();
		
		priceDto.setValue(productDto.getValue());
		priceDto.setProductId(id);
		
		
		System.out.println(productDto.getValue());
		
		HttpEntity<PriceDto> httpEntity = new HttpEntity<>(priceDto, headers);

		
        Product product = productRepository.findById(id).get();
		
		System.out.println(product.getPid());
		
       // Rest Call to update price for product	
		
		ResponseEntity<PriceDto> priceObject = 
		           restTemplate.exchange("http://localhost:8585/price/addPrice", HttpMethod.POST, httpEntity, PriceDto.class);
		
		

        product.setPid(id);
        product.setPrice(productDto.getValue());
		
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
		Product products= productRepository.save(product);
		
	

        ProductDto products1= new ProductDto();
		
		products1.setDescription(products.getDescription());
		products1.setName(products.getName());
		products1.setPid(id);
		products1.setPriceId(priceObject.getBody().getPriceId());
		products1.setValue(products.getPrice());
		
		return products1;
		      
	}

	@Override
	public Product getProductsById(String id) {
		
		
		Product product= productRepository.findById(id).get();
		
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		
		
		return productRepository.findAll();
	}

	@Override
	public void deleteProductById(String id) {

		
		Product product= productRepository.findById(id).get();

		productRepository.delete(product);
	}
	
	
	}


