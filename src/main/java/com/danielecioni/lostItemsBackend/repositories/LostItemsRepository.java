package com.danielecioni.lostItemsBackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielecioni.lostItemsBackend.entities.LostItem;

public interface LostItemsRepository  extends JpaRepository<LostItem, Long>{

	List<LostItem> findByFound(boolean found);

}
