package com.sample.hibernate.uni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.uni.entity.Course;
import com.sample.hibernate.uni.entity.Instructor;
import com.sample.hibernate.uni.entity.InstructorDetail;
import com.sample.hibernate.uni.entity.Review;

public class CreateCourseAndReviewDemo {

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
			
			session.beginTransaction();
			
			Course course = new Course("API Development");
			
			course.addReview(new Review("Its good"));
			course.addReview(new Review("Its bad"));
			
			session.save(course);
						
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		
	
		
	}

}
