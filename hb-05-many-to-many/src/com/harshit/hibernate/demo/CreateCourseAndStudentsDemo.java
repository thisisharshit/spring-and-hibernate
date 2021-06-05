package com.harshit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.harshit.hibernate.demo.entity.Course;
import com.harshit.hibernate.demo.entity.Instructor;
import com.harshit.hibernate.demo.entity.InstructorDetail;
import com.harshit.hibernate.demo.entity.Review;
import com.harshit.hibernate.demo.entity.Student;



public class CreateCourseAndStudentsDemo{
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
			
			//create a course
			Course course=new Course("Pacman - How to score one million points");
			
			
			System.out.println("\nsaving the course ....");
			session.save(course);
			System.out.println("saved the course: "+course);
			
			//create the students
			Student student1=new Student("John","Doe","john@gmail.com");
			Student student2=new Student("Mary","Public","mary@gmail.com");
			
			//add students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			//save the students
			System.out.println("\nsaving students.....");
			session.save(student1);
			session.save(student2);
			System.out.println("students saved: "+course.getStudents());
			
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
