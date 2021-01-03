package com.asahdev.crud;

import com.asahdev.DateUtils;
import com.asahdev.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("/config/crud/hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			String theDateOfBirthStr = "31/12/1998";
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com", theDateOfBirth);
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com", theDateOfBirth);
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com", theDateOfBirth);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			factory.close();
		}
		
		
	}

}