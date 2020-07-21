package com.cts.inventorypurchase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.inventorypurchase.entities.Purchase;
import com.cts.inventorypurchase.repos.PurchaseRepository;

@Service

public class PurchaseService {

	@Autowired
	private PurchaseRepository repository;

	public Purchase savePurchase(Purchase purchase) {
		return repository.save(purchase);
	}

	public List<Purchase> savePurchase(List<Purchase> purchases) {
		return (List<Purchase>) repository.saveAll(purchases);
	}

	public List<Purchase> getPurchases() {
		return (List<Purchase>) repository.findAll();
	}

	public Purchase getPurchaseById(int id) {
		return repository.findById(id).orElse(null);
	}

	public String deletePurchase(int id) {
		repository.deleteById(id);
		return "puchase removed ||" + id;
	}

	public Purchase updatePurchase(Purchase purchase) {
		Purchase existingPurchase = repository.findById(purchase.getId()).orElse(null);
		existingPurchase.setName(purchase.getName());
		existingPurchase.setDescription(purchase.getDescription());
		existingPurchase.setPrice(purchase.getPrice());
		return repository.save(existingPurchase);
	}

}
