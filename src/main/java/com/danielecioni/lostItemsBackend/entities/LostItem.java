package com.danielecioni.lostItemsBackend.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "lost_items")
@Getter @Setter @NoArgsConstructor @ToString
public class LostItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private LocalDate lost_date;
	
	@Column
	private String lost_location;
	
	@Column
	private boolean found;
	
	@Column
	private LocalDate found_date;
	
	@Column
	private String found_location;
}
