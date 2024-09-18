package com.consultadd.Springdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consultadd.Springdemo.Service.InventoryManagementService;
import com.consultadd.Springdemo.entities.InventoryManagement;

@RestController
public class InventoryManagementController {
	
	@Autowired
	private InventoryManagementService inventoryService;
	
	@PostMapping("/inventory")
	public ResponseEntity<String> saveDepartment(@RequestBody InventoryManagement inventory) {
		return inventoryService.saveInventory(inventory);
		
	}

	@GetMapping("/inventory/{id}")
	public ResponseEntity<?> getInventoryById(@PathVariable("id") Long id) {
		return inventoryService.getInventoryById(id);
	}
	
	
	@GetMapping("/Health")
	public String Health() {
		return "Anurag";
	}


}
