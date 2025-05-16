package com.danielecioni.lostItemsBackend.mappers;

import com.danielecioni.lostItemsBackend.dto.LostItemRequestDto;
import com.danielecioni.lostItemsBackend.entities.LostItem;


public class LostItemMapper {
	
	public static LostItem dtoToEntity(LostItemRequestDto lostItemRequestDto){
			
		LostItem lostItem = new LostItem();
		lostItem.setName(lostItemRequestDto.getName());
		lostItem.setDescription(lostItemRequestDto.getDescription());
		lostItem.setLost_date(lostItemRequestDto.getLost_date());
		lostItem.setLost_location(lostItemRequestDto.getLost_location());
		lostItem.setFound(false);
		
		return lostItem;	
	}
}
