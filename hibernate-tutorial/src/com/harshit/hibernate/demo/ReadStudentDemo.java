package com.harshit.hibernate.demo;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.harshit.hibernate.demo.entity.Student;


public class ReadStudentDemo{
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
			
			//create a student object
			System.out.println("creating a student object.....");
			Student student=new Student("Daffy","Duck","daffy@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save a student object
			System.out.println("saving a student object.....");
			System.out.println(student);
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			//reading the student data
			System.out.println("student saved. Generated id = "+student.getId());
			session=factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\nGetting student with id = "+student.getId());
			Student myStudent=session.get(Student.class,student.getId());
			System.out.println("Get Complete: "+myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	
}
