package com.harshit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.harshit.hibernate.demo.entity.Instructor;
import com.harshit.hibernate.demo.entity.InstructorDetail;



public class CreateDemo{
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
			//create the object
			/*Instructor instructor=new Instructor("Chad","Darby","Chad@gmail.com");
			InstructorDetail instructorDetail=new InstructorDetail("http://www.harshit.com/youtube","luv to code!!!");
			*/
			Instructor instructor=new Instructor("Madhu","Patel","Madhu@gmail.com");
			InstructorDetail instructorDetail=new InstructorDetail("http://www.youtube.com","Guitar");
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
			factory.close();
		}
	}

	
}
