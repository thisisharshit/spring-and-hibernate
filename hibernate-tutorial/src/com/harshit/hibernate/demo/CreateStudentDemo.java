package com.harshit.hibernate.demo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.harshit.hibernate.demo.entity.Student;


public class CreateStudentDemo{
	public static void main(String[] args)  {
		
		//create sessionfactory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();	
		
		
		try {
			
			String date="31/12/1998";
			Date dateofbirth=DateUtils.parseDate(date);
			
			//use the session object to save java object
			
			//create a student object
			System.out.println("creating a student object.....");
			Student student=new Student("Paul","Wall","paul@gmail.com",dateofbirth);
			
			//start a transaction
			session.beginTransaction();
			
			//save a student object
			System.out.println("saving a student object.....");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

	
}
