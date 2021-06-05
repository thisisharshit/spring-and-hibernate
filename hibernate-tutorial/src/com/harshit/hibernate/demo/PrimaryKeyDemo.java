package com.harshit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harshit.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create sessionfactory
				SessionFactory factory=new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				//create session
				Session session=factory.getCurrentSession();	
				
				
				try {
					//use the session object to save java object
					
					//create 3 student objects
					System.out.println("creating 3 student objects.....");
					Student student1=new Student("John","Doe","john@gmail.com");
					Student student2=new Student("Mary","Public","mary@gmail.com");
					Student student3=new Student("Bonita","Applebum","bonita@gmail.com");
					
					//start a transaction
					session.beginTransaction();
					
					//save a student object
					System.out.println("saving a student object.....");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
				} finally {
					factory.close();
				}
				
				
	}

}
