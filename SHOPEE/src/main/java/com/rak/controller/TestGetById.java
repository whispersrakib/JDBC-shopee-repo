package com.rak.controller;

import java.util.Scanner;

import com.rak.dao.ItemDao;
import com.rak.dto.Item;

public class TestGetById {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemDao dao = new ItemDao();
		Scanner Sc= new Scanner(System.in);
		System.out.println("enter the item id");
		Item item= dao.GetById(Sc.nextInt());
		System.out.println("Item id is "+ item.getId());
		System.out.println("Quantity of item is "+ item.getQuantity());
		System.out.println("size of the item is "+item.getSize());
		System.out.println("Price is "+item.getPrice());

	}

}
