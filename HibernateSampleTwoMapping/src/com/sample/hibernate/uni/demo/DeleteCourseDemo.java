package com.sample.hibernate.uni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.uni.entity.Course;
import com.sample.hibernate.uni.entity.Instructor;
import com.sample.hibernate.uni.entity.InstructorDetail;
import com.sample.hibernate.uni.entity.Review;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Review.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			int theId = 10;
			
			session.beginTransaction();
			
			Course theCourse = session.get(Course.class, theId);
			
			session.delete(theCourse);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
