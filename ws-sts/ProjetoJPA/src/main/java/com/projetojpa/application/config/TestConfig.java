package com.projetojpa.application.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetojpa.application.entities.Category;
import com.projetojpa.application.entities.PurchaseOrder;
import com.projetojpa.application.entities.User;
import com.projetojpa.application.entities.enums.PurchaseOrderStatus;
import com.projetojpa.application.repositories.CategoryRepository;
import com.projetojpa.application.repositories.PurchaseOrderRepository;
import com.projetojpa.application.repositories.UserRepository;

@Configuration @Profile("test") public class TestConfig implements CommandLineRunner {
	
	// atributos
	@Autowired private UserRepository userRepository;
	@Autowired private PurchaseOrderRepository purchaseOrderRepository;
	@Autowired private CategoryRepository categoryRepository;

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
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		purchaseOrderRepository.saveAll(Arrays.asList(po1, po2, po3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
	}
	
}
