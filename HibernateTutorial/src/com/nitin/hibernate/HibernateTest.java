package com.nitin.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nitin.test.Address;
import com.nitin.test.UserDetails;



public class HibernateTest {

	public static void main(String[] args) {
         
		UserDetails user = new UserDetails();
	
		 Address addr1= new Address();
		  addr1.setStreet("Karvenagar");
		  addr1.setCity("Pune");
		
		  Address addr2= new Address();
		  addr2.setStreet("Hinjawadi");
		  addr2.setCity("Haveli");
		
		user.setUserId(1);
		user.setUserName("vilas");
		user.setJoinedDate(new Date());
		user.setDescription("abcdef");
		user.setHomeAddress(addr1);
		user.setOfficeAddress(addr2);
		
		
		/* add another entry for another object user2 */
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Jaydeep");
		user2.setHomeAddress(addr1);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
	      
	      /* Extract the values from tables 
	       session.close();
	       user=null; 
	       session= sessionFactory.openSession();
	       session.beginTransaction();
	      user =(UserDetails)session.get(UserDetails.class, 1);
	         System.out.println("user is "+user.getUserName());
	       ***/
	       
	       
	       
	       
	}

}
