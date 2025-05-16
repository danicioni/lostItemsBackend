package com.danielecioni.lostItemsBackend.mappers;

import com.danielecioni.lostItemsBackend.dto.LostItemRequestDto;
import com.danielecioni.lostItemsBackend.entities.LostItem;

public class LostItemMapperById {
	
	public static LostItem dtoToEntityId(LostItemRequestDto lostItemRequestDto, Long id){
		
		LostItem lostItem = new LostItem();
		lostItem.setId(id);
		lostItem.setName(lostItemRequestDto.getName());
		lostItem.setDescription(lostItemRequestDto.getDescription());
		lostItem.setLost_date(lostItemRequestDto.getLost_date());
		lostItem.setLost_location(lostItemRequestDto.getLost_location());
		lostItem.setFound(lostItemRequestDto.isFound());
		lostItem.setFound_date(lostItemRequestDto.getFound_date());
		lostItem.setFound_location(lostItemRequestDto.getFound_location());
		
		return lostItem;				
	}
}
