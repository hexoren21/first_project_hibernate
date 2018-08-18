package com.przemyslaw.demo1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




import com.przemyslaw.hibernate_demo.Student;



public class displayStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where lastName='Swiniaczek'").list();
			// commit transaction
			session.getTransaction().commit();
			displayStudents(theStudents);
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student temp : theStudents)
			System.out.println(temp);
	}
	

}
