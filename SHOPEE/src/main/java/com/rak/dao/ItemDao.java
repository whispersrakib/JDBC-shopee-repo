package com.rak.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.rak.dto.Item;

public class ItemDao {
	static String url="jdbc:mysql://localhost:3306/shopee";
	static String un="root";
	static String pwd="Rakibsk20";
	public void saveItem( Item item) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,un,pwd);
			PreparedStatement statement =connection.prepareStatement("insert into items values(?,?,?,?)");
			statement.setInt(1, item.getId());
			statement.setInt(2, item.getQuantity());
			statement.setString(3, item.getSize());
			statement.setDouble(4, item.getPrice());
			
			statement.execute();
			
			System.out.println("data added succesfully!!!!!!!!!");
			
			statement.close();
			connection.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Item GetById(int id){
		Item item=new Item();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,un,pwd);
			PreparedStatement preparedStatement=connection.prepareStatement("select * from items where id=?;");
			preparedStatement.setInt(1, id);
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("--------------");
				int id1=resultSet.getInt(1);
				int quantty=resultSet.getInt(2);
				String size=resultSet.getString(3);
				Double price=resultSet.getDouble(4);
				item.setId(id1);
				item.setQuantity(quantty);
				item.setSize(size);
				item.setPrice(price);
			}
			preparedStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
		
		
	}
	public void deleteItem(Item item) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,un,pwd);
			PreparedStatement preparedStatement=connection.prepareStatement("delete from items where id=?;");
			preparedStatement.setInt(1, item.getId());
			int d=preparedStatement.executeUpdate();
			System.out.println(d+" Items deleted succesfully");
			preparedStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void UpdateItem(Item item) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection(url,un,pwd);
			PreparedStatement preparedStatement=connection.prepareStatement("update items set quantity=?,size=?,price=? where id=?");
			preparedStatement.setInt(1, item.getQuantity());
			preparedStatement.setString(2, item.getSize());
			preparedStatement.setDouble(3, item.getPrice());
			preparedStatement.setInt(4, item.getId());
			int x=preparedStatement.executeUpdate();
			System.out.println(x+" data updated succesfully......");
			preparedStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Item> getItem() {
		List<Item> I1=new ArrayList<Item>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection(url,un,pwd);
			PreparedStatement preparedStatement=connection.prepareStatement("select * from items;");
	         ResultSet resultSet=preparedStatement.executeQuery();
	         while(resultSet.next()) {
	        	 int id =resultSet.getInt(1);
	        	 int quantity =resultSet.getInt(2);
	        	 String size = resultSet.getString(3);
	        	 Double price=resultSet.getDouble(4);
	      
	        	 Item item=new Item();
	        	 item.setId(id);
	        	 item.setQuantity(quantity);
	        	 item.setSize(size);
	        	 item.setPrice(price);
	        	 //to add the patient's
	        	 I1.add(item);
	        	 }
	         preparedStatement.close();
	         connection.close();
	         
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return I1;
	}
}
