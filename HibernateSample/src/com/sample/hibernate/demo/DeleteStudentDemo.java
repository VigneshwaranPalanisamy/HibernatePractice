package com.sample.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();


		try {

			//deleteSingleStudent(factory);
			deleteMultipleStudents(factory);

		} finally {
			factory.close();
		}

	}

	private static void deleteSingleStudent(SessionFactory factory) {

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Student student = session.get(Student.class,1);
		
		if(student != null)
			session.delete(student);
		else 
			System.out.println("Record Not Found..........");
		
		session.getTransaction().commit();
	}

	private static void deleteMultipleStudents(SessionFactory factory) {

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.createQuery("delete from Student where email='vignesh@gmail.com'").executeUpdate();

		session.getTransaction().commit();
	}

}
