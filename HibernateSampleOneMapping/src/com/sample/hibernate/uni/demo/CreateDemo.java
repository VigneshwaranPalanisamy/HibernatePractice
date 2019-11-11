package com.sample.hibernate.uni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.uni.entity.Instructor;
import com.sample.hibernate.uni.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Chad","Minaj","chad@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("chad.youtube.com","Youtube");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
