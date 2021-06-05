package com.harshit.hibernate.demo;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.harshit.hibernate.demo.entity.Student;


public class DeleteStudentDemo{
	public static void main(String[] args) {
		
		//create sessionfactory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();	
		
		
		try {
			
			/*int id=1;
			//start a transaction
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: "+id);
			Student myStudent=session.get(Student.class, id);
			System.out.println("Get Complete: "+myStudent);
			
			//deleting student
			System.out.println("deleting student.... "+myStudent);
			session.delete(myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			*/
			
			//approach Two
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("deleting student with id = 2");
			session.createQuery("delete from Student where id = 2").executeUpdate();
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	
}
