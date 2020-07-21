package com.cts.inventorypurchase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.inventorypurchase.entities.Purchase;
import com.cts.inventorypurchase.repos.PurchaseRepository;

@SpringBootTest
@RunWith(SpringRunner.class)

class InventorypurchaseApplicationTests {
	@Autowired
	PurchaseRepository repository;


	@Test
	void contextLoads() {
	}
	@Test
	public void testCreate() {
		Purchase purchase = new Purchase();
		purchase.setId(3);
		purchase.setName("TV");
		purchase.setDescription("Samsung");
		purchase.setPrice(1000);
		repository.save(purchase);
	}

	@Test
	public void testRead() {
		Optional<Purchase> purchase = repository.findById(3);
		assertNotNull(purchase);
		System.out.println("Name::::::::::::::::::" + purchase.get().getName());
		assertEquals("TV", purchase.get().getName());

	}

	@Test
	public void testUpdate() {
		
		Purchase purchase = new Purchase();
		Optional<Purchase> purchasefind = repository.findById(3);
		if(purchasefind.isPresent()) {
			purchase = purchasefind.get();		    
		} 
		purchase.setPrice(2000);		
		 repository.save(purchase); 
	}

	@Test
	public void testDelete() {
		if (repository.existsById(3)) {
			System.out.println("Deleting the product");
			repository.deleteById(3);
		}
	}

}
