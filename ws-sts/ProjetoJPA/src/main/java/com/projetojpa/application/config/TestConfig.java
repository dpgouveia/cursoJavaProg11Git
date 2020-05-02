package com.projetojpa.application.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetojpa.application.entities.Category;
import com.projetojpa.application.entities.PurchaseOrderProduct;
import com.projetojpa.application.entities.Product;
import com.projetojpa.application.entities.PurchaseOrder;
import com.projetojpa.application.entities.User;
import com.projetojpa.application.entities.enums.PurchaseOrderStatus;
import com.projetojpa.application.repositories.CategoryRepository;
import com.projetojpa.application.repositories.PurchaseOrderProductRepository;
import com.projetojpa.application.repositories.ProductRepository;
import com.projetojpa.application.repositories.PurchaseOrderRepository;
import com.projetojpa.application.repositories.UserRepository;

@Configuration @Profile("test") public class TestConfig implements CommandLineRunner {
	
	// atributos
	@Autowired private UserRepository userRepository;
	@Autowired private PurchaseOrderRepository purchaseOrderRepository;
	@Autowired private CategoryRepository categoryRepository;
	@Autowired private ProductRepository productRepository;
	@Autowired private PurchaseOrderProductRepository purchaseOrderProductRepository;

	// métodos
	@Override public void run(String... args) throws Exception {

		User user1 = new User(null, "Daniel", "daniel@gmail.com", "(51) 99999-9999", "1234567");
		User user2 = new User(null, "Kélia", "kelia@gmail.com", "(61) 98888-8888", "1234567");
		
		PurchaseOrder po1 = new PurchaseOrder(null, Instant.parse("2019-06-20T19:53:07Z"), PurchaseOrderStatus.PAID, user1);
		PurchaseOrder po2 = new PurchaseOrder(null, Instant.parse("2019-07-21T03:42:10Z"), PurchaseOrderStatus.WAITING_PAYMENT, user2);
		PurchaseOrder po3 = new PurchaseOrder(null, Instant.parse("2019-07-22T15:21:22Z"), PurchaseOrderStatus.WAITING_PAYMENT, user1);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");		
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		purchaseOrderRepository.saveAll(Arrays.asList(po1, po2, po3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		cat1.getProducts().add(p2);
		cat2.getProducts().add(p1);
		cat2.getProducts().add(p5);
		cat3.getProducts().add(p2);
		cat3.getProducts().add(p3);
		cat3.getProducts().add(p4);
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		PurchaseOrderProduct poi1 = new PurchaseOrderProduct(p1, po1, 2, p1.getPrice());
		PurchaseOrderProduct poi2 = new PurchaseOrderProduct(p3, po1, 1, p3.getPrice());
		PurchaseOrderProduct poi3 = new PurchaseOrderProduct(p3, po2, 2, p3.getPrice());
		PurchaseOrderProduct poi4 = new PurchaseOrderProduct(p5, po3, 2, p5.getPrice());
		purchaseOrderProductRepository.saveAll(Arrays.asList(poi1, poi2, poi3, poi4));
		
	}
	
}
