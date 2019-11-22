package com.sample.hibernate.bi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.bi.entity.Course;
import com.sample.hibernate.bi.entity.Instructor;
import com.sample.hibernate.bi.entity.InstructorDetail;

public class GetCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			int theId = 1;
			
			session.beginTransaction();
			
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor : "+theInstructor.toString());
			
			System.out.println("Courses : "+theInstructor.getCourses());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
