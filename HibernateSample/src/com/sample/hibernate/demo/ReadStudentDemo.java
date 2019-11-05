package com.sample.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			//createAndReadObject(factory);
			getAllStudents(factory);
			getAllStudentsWithCondition(factory);
		} finally {
			factory.close();
		}
		
	}

	private static void createAndReadObject(SessionFactory factory) {
		
		Session session = factory.getCurrentSession();
		
		//Create a student and insert it  into DB
		session.beginTransaction();

		Student student = new Student("Zack","Dempsy","zack@gmail.com", null);

		session.save(student);

		session.getTransaction().commit();

		//Read the inserted student record from DB
		session = factory.getCurrentSession();

		session.beginTransaction();

		Student result = session.get(Student.class, student.getId());

		System.out.println(result.toString());

		session.getTransaction().commit();
	}

	private static void getAllStudents(SessionFactory factory) {
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Student> studentList = session.createQuery("from Student").list();
		
		for(Student studentObj : studentList) {
			System.out.println(studentObj.toString());
		}
				
		session.getTransaction().commit();
	}
	
private static void getAllStudentsWithCondition(SessionFactory factory) {
		
		Session session = factory.getCurrentSession();
	
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Student> studentList = session.createQuery("from Student s where s.firstName='John' ").list();
		
		for(Student studentObj : studentList) {
			System.out.println(studentObj.toString());
		}
				
		session.getTransaction().commit();
	}

}
