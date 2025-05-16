package com.danielecioni.lostItemsBackend.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class LostItemRequestDto {
	
	@NotBlank(message = "Campo name non valido")
	@Size(min=3, message = "Campo name troppo corto")
	private String name;
	
	@NotBlank(message = "Campo descrizione non valido")
	@Size(min=5, message = "Campo descrizione troppo corto")
	private String description;
	
	
	private LocalDate lost_date;
	
	private String lost_location;
	
	private boolean found;
	

	private LocalDate found_date;
	
	
	private String found_location;
}
