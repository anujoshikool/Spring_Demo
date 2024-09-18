package com.consultadd.Springdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultadd.Springdemo.entities.InventoryManagement;

public interface InventoryManagementRepository extends JpaRepository<InventoryManagement, Long> {
	

}
