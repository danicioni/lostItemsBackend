package com.danielecioni.lostItemsBackend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danielecioni.lostItemsBackend.dto.LostItemRequestDto;
import com.danielecioni.lostItemsBackend.entities.LostItem;
import com.danielecioni.lostItemsBackend.mappers.LostItemMapper;
import com.danielecioni.lostItemsBackend.mappers.LostItemMapperById;
import com.danielecioni.lostItemsBackend.repositories.LostItemsRepository;


import jakarta.validation.Valid;

@RestController @CrossOrigin
public class LostItemsController {
	
	private LostItemsRepository lostItemsRepository;
	
	public LostItemsController(LostItemsRepository lostItemsRepository) {
		this.lostItemsRepository = lostItemsRepository;
	}
	
	@GetMapping("/lostitems/")
	public ResponseEntity<List<LostItem>> index() {		
		List<LostItem> products = this.lostItemsRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}
	
	@GetMapping("/lostitems/{found}")
	public ResponseEntity<?> show(@PathVariable boolean found) {
		
		List<LostItem> optionalLostItem= this.lostItemsRepository.findByFound(found);	
		
		return ResponseEntity.status(HttpStatus.OK).body(optionalLostItem);		
	}
	
	@PostMapping("/lostitems")
	public ResponseEntity<?> item(
		@Valid @RequestBody LostItemRequestDto lostItemRequestDto,
		BindingResult result
	) 
	{
		if(result.hasErrors())
		{
			Map<String, String> errors = new HashMap<String, String>();
			result.getFieldErrors().forEach( error -> errors.put(error.getField(), error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}

		LostItem lostItem = LostItemMapper.dtoToEntity(lostItemRequestDto);		
		LostItem itemInserded = this.lostItemsRepository.save(lostItem);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(itemInserded);
	}
	
	@DeleteMapping("/lostitems/{id}")
	public ResponseEntity<?> destroyById(
		@PathVariable Long id
	) 
	{
		Optional<LostItem> optionalItem= this.lostItemsRepository.findById(id);
		
		if(optionalItem.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oggetto non trovato");
		}
		else {
			this.lostItemsRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
	@PutMapping("/lostitems/{id}")
	public ResponseEntity<?> updateById(
		@PathVariable Long id,
		@Valid @RequestBody LostItemRequestDto lostItemRequestDto,
		BindingResult result
	)
	{
		if(result.hasErrors())
		{
			Map<String, String> errors = new HashMap<String, String>();
			result.getFieldErrors().forEach( error -> errors.put(error.getField(), error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
		LostItem lostItem = LostItemMapperById.dtoToEntityId(lostItemRequestDto, id);	
		LostItem lostItemUpdated = this.lostItemsRepository.save(lostItem);
		return ResponseEntity.status(HttpStatus.OK).body(lostItemUpdated);
	}
}
