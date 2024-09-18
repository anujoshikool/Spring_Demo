package com.consultadd.Springdemo.Service;

import org.springframework.http.ResponseEntity;

import com.consultadd.Springdemo.entities.InventoryManagement;

public interface InventoryManagementService {
	
	public ResponseEntity<String> saveInventory(InventoryManagement inventory);

	public ResponseEntity<?> getInventoryById(Long id);

}
