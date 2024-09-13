package com.inventory.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.inventoryservice.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, String> {

}
