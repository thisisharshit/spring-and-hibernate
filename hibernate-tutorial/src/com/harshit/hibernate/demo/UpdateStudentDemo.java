package com.harshit.hibernate.demo;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.harshit.hibernate.demo.entity.Student;


public class UpdateStudentDemo{
	public static void main(String[] args) {
		
		//create sessionfactory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();	
		
		
		try {
			
			int id=1;
			//start a transaction
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: "+id);
			Student myStudent=session.get(Student.class, id);
			System.out.println("Get Complete: "+myStudent);
			
			
			System.out.println("Updating student....");
			myStudent.setFirstName("Scooby");

			//commit transaction
			session.getTransaction().commit();
			
			
			//Approach two
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			//update email for all students
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	
}
