package com.sample.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();


		try {

			updateSingleStudent(factory);
			updateMultipleStudents(factory);

		} finally {
			factory.close();
		}

	}

	private static void updateSingleStudent(SessionFactory factory) {

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Student student = session.get(Student.class,1);

		student.setFirstName("Scooby");

		session.getTransaction().commit();
	}

	private static void updateMultipleStudents(SessionFactory factory) {

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.createQuery("update Student set lastName='Williams'").executeUpdate();

		session.getTransaction().commit();
	}

}
