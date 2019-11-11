package com.sample.hibernate.uni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.uni.entity.Instructor;
import com.sample.hibernate.uni.entity.InstructorDetail;

public class DeleteCascadeDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			int theID = 1;
						
			session.beginTransaction();
			
			Instructor theInstructor = session.get(Instructor.class,theID);
			
			//System.out.println("Instructor found -> "+theInstructor);
			
			//System.out.println("Associate Object"+theInstructor.getInstructorDetail());
			
			session.delete(theInstructor);
			
			System.out.println("Deleted Successfully !!!");
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
