package com.rak.controller;

import java.util.Scanner;

import com.rak.dao.ItemDao;
import com.rak.dto.Item;

public class TestDelete {
	public static void main(String[] args) {
		Item item= new Item();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the patient id wants to delete-----");
		item.setId(sc.nextInt());

		
		ItemDao dao2=new ItemDao();
		dao2.deleteItem(item);

	}

}
