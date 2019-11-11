package com.sample.hibernate.bi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.bi.entity.Instructor;
import com.sample.hibernate.bi.entity.InstructorDetail;

public class DeleteCascadeDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			int theID = 2;
						
			session.beginTransaction();
			
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class,theID);
			
			if (theInstructorDetail != null) {
				
				//System.out.println("Instructor Details -> " + theInstructorDetail);
				//System.out.println("Associate Object" + theInstructorDetail.getInstructor());
				theInstructorDetail.getInstructor().setInstructorDetail(null);
				
			}
			
			
			session.delete(theInstructorDetail);
			
			//System.out.println("Deleted Successfully !!!");
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
