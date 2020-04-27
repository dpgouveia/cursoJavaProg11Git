package com.projetojpa.application.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetojpa.application.entities.PurchaseOrder;
import com.projetojpa.application.entities.User;
import com.projetojpa.application.repositories.PurchaseOrderRepository;
import com.projetojpa.application.repositories.UserRepository;

@Configuration @Profile("test") public class TestConfig implements CommandLineRunner {
	
	// atributos
	@Autowired private UserRepository userRepository;
	@Autowired private PurchaseOrderRepository purchaseOrderRepository;

	// métodos
	@Override public void run(String... args) throws Exception {

		User user1 = new User(null, "Daniel", "daniel@gmail.com", "(51) 99999-9999", "1234567");
		User user2 = new User(null, "Kélia", "kelia@gmail.com", "(61) 98888-8888", "1234567");
		
		PurchaseOrder po1 = new PurchaseOrder(null, Instant.parse("2019-06-20T19:53:07Z"), user1);
		PurchaseOrder po2 = new PurchaseOrder(null, Instant.parse("2019-07-21T03:42:10Z"), user2);
		PurchaseOrder po3 = new PurchaseOrder(null, Instant.parse("2019-07-22T15:21:22Z"), user1);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		purchaseOrderRepository.saveAll(Arrays.asList(po1, po2, po3));
		
	}
	
	
	
}
