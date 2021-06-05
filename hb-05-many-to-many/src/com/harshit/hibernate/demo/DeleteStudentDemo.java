package com.harshit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harshit.hibernate.demo.entity.Course;
import com.harshit.hibernate.demo.entity.Instructor;
import com.harshit.hibernate.demo.entity.InstructorDetail;
import com.harshit.hibernate.demo.entity.Review;
import com.harshit.hibernate.demo.entity.Student;



public class DeleteStudentDemo{
	public static void main(String[] args)  {
		
		//create sessionfactory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();	
		
		
		try {			
			//start a transaction
			session.beginTransaction();
			
			//get the student from db
			int id=2;
			Student student=session.get(Student.class,id);

			System.out.println("\nloaded student: "+student);
			System.out.println("Courses: "+student.getCourses());
			
			//delete the student
			
			System.out.println("\ndeleting student: "+student);
			session.delete(student);
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
