package com.sample.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample.hibernate.entity.Student;
import com.sample.hibernate.utils.DateUtils;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			// Insert a single student object into DB 
			
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			
			Student student = new Student("Vignesh","Palani","vignesh@gmail.com", theDateOfBirth);
			session.save(student);
			/*			
			//Insert list of student objects into DB
			List<Student> studentList = new ArrayList<>();
			
			studentList.add(new Student("John","Doe","john@gmail.com"));
			studentList.add(new Student("Clay","Jenson","clay@gmail.com"));
			studentList.add(new Student("Hannah","Baker","hannah@gmail.com"));
			
			for(Student studentObj: studentList) {
				//System.out.println(studentObj.toString());
				session.save(studentObj);
			}*/
			
			session.getTransaction().commit();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
