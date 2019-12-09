package com.sample.hibernate.uni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.uni.entity.Course;
import com.sample.hibernate.uni.entity.Instructor;
import com.sample.hibernate.uni.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			Instructor instructor = new Instructor("Vignesh","Palani","vicky@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("vicky.youtube.com","Youtube");

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
