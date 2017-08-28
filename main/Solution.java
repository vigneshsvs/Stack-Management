package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import stack.DatabaseAccess;
import stack.Item;
import stack.User;

public class Solution {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1.Login \n 2.Signup");
		Integer  choice = Integer.parseInt(br.readLine());
		if(choice == 1) {
			System.out.println("Username: ");
			String userName = br.readLine();
			System.out.println("Password: ");
			String password = br.readLine();
			boolean b = DatabaseAccess.verification(userName, password);
			
			if(b) {
				System.out.println("Login Success");
				System.out.println("1.Add Item"+ " " + "2.Remove Item" +"  " + "3.update" + "  " + "4.search" + "  "+ "5.ViewAll");
				System.out.println("Enter choice:");
				switch(Integer.parseInt(br.readLine())) {
				case 1:
					Item item = new Item();
					System.out.println("Item ID :");
					item.setId(Integer.parseInt(br.readLine()));
					System.out.println("Item Name:");
					item.setItemName(br.readLine());
					System.out.println("Quantity :");
					item.setQuantity(Integer.parseInt(br.readLine()));
					System.out.println("Price    :");
					item.setPrice(Float.parseFloat(br.readLine()));
					SessionFactory sf= new Configuration().configure().buildSessionFactory();
					Session session2 =sf.openSession();
					session2.beginTransaction();
					session2.save(item);
					session2.getTransaction().commit();
					session2.close();
					break;
				case 2:
					System.out.println("Item ID to Remove:");
					Integer id = Integer.parseInt(br.readLine());
					SessionFactory sf1= new Configuration().configure().buildSessionFactory();
					Session session1 =sf1.openSession();
					session1.beginTransaction();
					Item item1 = new Item();
					item1.setId(id);
					session1.delete(item1);
					session1.getTransaction().commit();
					session1.close();
					break;
				case 3:
					
					System.out.println("Item ID to Update:");
					Integer id1 = Integer.parseInt(br.readLine());
					Item item2 = new Item();
					SessionFactory sf2= new Configuration().configure().buildSessionFactory();
					Session session21 =sf2.openSession();
					session21.beginTransaction();
					item2 = session21.get(Item.class, id1);
					System.out.println("Enter the property to update 1.Item Name  2.Price  3.Quantity:");
					Integer cho = Integer.parseInt(br.readLine());
					if(cho == 1) {
						System.out.println("Enter Item Name to Update:");
						String iname = br.readLine();
						item2.setItemName(iname);
						System.out.println("Updated Successfully");		
 					}
					else if(cho == 2) {
						System.out.println("Enter Price to Update:");
						Float iprice = Float.parseFloat(br.readLine());
						item2.setPrice(iprice);
						System.out.println("Updated Successfully");
					}
					else if(cho == 3) {
						System.out.println("Enter Quantity to Update:");
						Integer iquantity = Integer.parseInt(br.readLine());
						item2.setQuantity(iquantity);
						System.out.println("Updated Successfully");
					}
					session21.getTransaction().commit();
					session21.close();
					break;
				
				case 4:
					System.out.println("Enter the Item ID:");
					Integer id2 = Integer.parseInt(br.readLine());
					Item item3 = new Item();
					SessionFactory sf3= new Configuration().configure().buildSessionFactory();
					Session session3 =sf3.openSession();
					session3.beginTransaction();
					item3 = session3.get(Item.class, id2);
					System.out.println(item3.getId() + " " +  item3.getItemName() +" " + item3.getQuantity() + " " + item3.getPrice());
					session3.getTransaction().commit();
					session3.close();
					break;
				case 5:
					
					SessionFactory sf4= new Configuration().configure().buildSessionFactory();
					Session session31 =sf4.openSession();
					session31.beginTransaction();
					Query query = session31.createQuery("from item_tab");
					List<Item> item41 = query.getResultList(); 
					for(Item each: item41) {
						System.out.println(each.getId() + "  " + each.getItemName() + "  " + each.getQuantity() + "  " + each.getPrice());
					}
					session31.getTransaction().commit();
					session31.close();
			}
			}
			else {
				System.out.println("Login Failed");
			}	
		}
		else {
			System.out.println("Username: ");
			String userName = br.readLine();
			System.out.println("Password: ");
			String password = br.readLine();
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			SessionFactory sf= new Configuration().configure().buildSessionFactory();
			Session session =sf.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
		}
	}

}
