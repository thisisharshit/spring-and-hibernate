package com.harshit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harshit.hibernate.demo.entity.Course;
import com.harshit.hibernate.demo.entity.Instructor;
import com.harshit.hibernate.demo.entity.InstructorDetail;



public class EagerLazyDemo{
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
			
			
			//start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int id=1;
			Instructor instructor=session.get(Instructor.class,id);
			
			System.out.println("harshit: instructor = "+instructor);
			System.out.println("harshit: Courses: "+instructor.getCourses());
			//commit transaction
			session.getTransaction().commit();
			
			session.close();
			System.out.println("session is closed");
			//since courses are lazy loaded...this should fail
			//get courses for the instructor
			System.out.println("harshit: Courses: "+instructor.getCourses());
			
			
			System.out.println("harshit: Done!");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

	
}
