package com.rak.controller;

import java.util.Scanner;

import com.rak.dao.ItemDao;
import com.rak.dto.Item;



public class TestSave {

	public static void main(String[] args) {
		Item item=new Item();
		Scanner sc=new Scanner(System.in);
		System.out.println("***********enter the ITEM details***********");
		System.out.println("enter the ITEM id-----");
		item.setId(sc.nextInt());
		System.out.println("enter the ITEM quatity-----");
		item.setQuantity(sc.nextInt());
		System.out.println("enter the ITEM size-----");
		item.setSize(sc.next());
		System.out.println("enter the ITEM price---");
		item.setPrice(sc.nextDouble());
		ItemDao dao=new ItemDao();
		dao.saveItem(item);
		}
}
