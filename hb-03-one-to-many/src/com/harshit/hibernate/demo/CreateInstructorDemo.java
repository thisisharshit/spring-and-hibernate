package com.harshit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harshit.hibernate.demo.entity.Course;
import com.harshit.hibernate.demo.entity.Instructor;
import com.harshit.hibernate.demo.entity.InstructorDetail;



public class CreateInstructorDemo{
	public static void main(String[] args)  {
		
		//create sessionfactory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();	
		
		
		try {
			//create the object
			
			Instructor instructor=new Instructor("Suzan","Public","suzan@gmail.com");
			InstructorDetail instructorDetail=new InstructorDetail("http://www.youtube.com","Video games");
			//associate the object
			instructor.setInstructorDetail(instructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor
			//NOTE: this will also save the details object because of cascadetype.ALL
			System.out.println("saving instructor: "+instructor);
			session.save(instructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

	
}
