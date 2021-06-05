package com.harshit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.harshit.hibernate.demo.entity.Instructor;
import com.harshit.hibernate.demo.entity.InstructorDetail;



public class DeleteInstuctorDetailDemo{
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
			
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, 3);
			
			System.out.println("Getting Instructor Detail: "+instructorDetail);
			
			System.out.println("Associated instructor: "+instructorDetail.getInstructor());
			
			//now lets delete the instructor detail
			System.out.println("deleting instructor detail: "+instructorDetail);
						
			//remove the associated object reference -- break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			
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
