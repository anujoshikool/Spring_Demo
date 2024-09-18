package com.consultadd.Springdemo.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.consultadd.Springdemo.Repository.InventoryManagementRepository;
import com.consultadd.Springdemo.entities.InventoryManagement;

@Service
public class InventoryManagementServiceImpl implements InventoryManagementService {
	
	@Autowired
	private InventoryManagementRepository inventoryRepo;

	@Override
	public ResponseEntity<String> saveInventory(InventoryManagement inventory) {
        try {
            validateInventory(inventory);
            inventoryRepo.save(inventory);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Inventory item saved successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                                 .body("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An unexpected error occurred: " + e.getMessage());
        }
    }
	
    @Override
    public ResponseEntity<?> getInventoryById(Long id) {
        try {
       
            InventoryManagement inventory = inventoryRepo.findById(id).orElse(null);

            if (inventory == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                     .body("Error: Inventory item not found with id: " + id);
            }
            return ResponseEntity.ok(inventory);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An unexpected error occurred: " + e.getMessage());
        }
    }
	
	
	private void validateInventory(InventoryManagement inventory) {
        if (inventory.getItemName() == null || inventory.getItemName().trim().isEmpty()) {
            throw new IllegalArgumentException("Item name is required.");
        }
        if (inventory.getQuantity() == null || inventory.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity must be a non-negative number and is requied.");
        }
        if (inventory.getPrice() == null || inventory.getPrice() < 0) {
            throw new IllegalArgumentException("Price must be a non-negative number and is required.");
        }
    }
}
