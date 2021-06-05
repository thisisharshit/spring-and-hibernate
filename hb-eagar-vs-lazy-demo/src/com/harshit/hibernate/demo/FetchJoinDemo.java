package com.harshit.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.harshit.hibernate.demo.entity.Course;
import com.harshit.hibernate.demo.entity.Instructor;
import com.harshit.hibernate.demo.entity.InstructorDetail;



public class FetchJoinDemo{
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
			
			//Hibernate query with HQL
			
			// get the instructor from db
			int theid=1;
			
			Query<Instructor> query=session.createQuery("select i from Instructor i join fetch i.courses where i.id=:theInstructorId",
					Instructor.class); //this query when executed will load the instructor and courses all at once
			
			//set parameter on query
			query.setParameter("theInstructorId",theid);
			
			//execute query and get instructor
			Instructor instructor=query.getSingleResult();
			
			System.out.println("harshit: instructor = "+instructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("the session is now closed");
			
			System.out.println("harshit: courses: "+instructor.getCourses());
			
			
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
