package com.rak.controller;

import java.util.List;
import com.rak.dao.ItemDao;
import com.rak.dto.Item;

public class TestGet {
	public static void main(String[] args) {
		
		ItemDao dao2 = new ItemDao();
		List<Item> lt =dao2.getItem();
		
		
		for(Item item : lt) {
			
			System.out.println("----------");
			System.out.println("Item id is "+ item.getId());
			System.out.println("Quantity of item is "+ item.getQuantity());
			System.out.println("size of the item is "+item.getSize());
			System.out.println("Price is "+item.getPrice());
			
		}
		
		}
	}

