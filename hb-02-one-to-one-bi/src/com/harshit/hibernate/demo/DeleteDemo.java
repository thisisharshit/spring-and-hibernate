package com.harshit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.harshit.hibernate.demo.entity.Instructor;
import com.harshit.hibernate.demo.entity.InstructorDetail;



public class DeleteDemo{
	public static void main(String[] args)  {
		
		//create sessionfactory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();	
		
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor by their primary key
			int id=1;
			Instructor instructor=session.get(Instructor.class,id);
			System.out.println("Found Instructor: "+instructor);
			
			if(instructor!=null) {
				System.out.println("Deleting: "+instructor);
				//NOTE: this will also delete the details object because of cascadetype.ALL
				session.delete(instructor);
			}
			
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
