package com.harshit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harshit.hibernate.demo.entity.Course;
import com.harshit.hibernate.demo.entity.Instructor;
import com.harshit.hibernate.demo.entity.InstructorDetail;



public class GetInstructorCoursesDemo{
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
			
			System.out.println("instructor = "+instructor);
			//get courses for the instructor
			System.out.println("Courses: "+instructor.getCourses());
			
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
