package com.harshit.hibernate.demo;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.harshit.hibernate.demo.entity.Student;

import java.util.List;


public class QueryStudentDemo{
	public static void main(String[] args) {
		
		//create sessionfactory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();	
		
		
		try {
			
			
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> students=session.createQuery("from Student").getResultList(); //using exact class name in query after from 
			
			//display students
			for(Student student:students) {
				System.out.println(student);
			}
			
			//query student: lastName='Doe'
			students=session.createQuery("from Student where lastName='Doe' or firstName='Mary'").getResultList();
			//display students
			for(Student student:students) {
				System.out.println(student);
			}
			
			//query student where email like '%gmail.com'
			students=session.createQuery("from Student where email like '%gmail.com'").getResultList();
			//display students
			for(Student student:students) {
				System.out.println(student);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	
}
