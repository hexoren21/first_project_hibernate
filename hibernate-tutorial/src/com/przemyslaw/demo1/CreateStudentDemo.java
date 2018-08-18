package com.przemyslaw.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.przemyslaw.hibernate_demo.Student;



public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try{
			// create a student object
			System.out.println("Creating 2 new student object...");
			Student tempStudent = new Student("Tom2", "Tomkowiak2", "tom2@o2.pl");
			Student tempStudent2 = new Student("Swiniak", "Swiniaczek", "swiniak@o2.pl");
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			session.save(tempStudent2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
	}
	

}
