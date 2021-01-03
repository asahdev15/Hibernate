package com.asahdev.mappings;

import com.asahdev.DateUtils;
import com.asahdev.HBUtils;
import com.asahdev.entity.Course;
import com.asahdev.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.Date;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = HBUtils.getSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
						
			// create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
						
			// save the course
			System.out.println("\nSaving the course ...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);

			// create the students
			String theDateOfBirthStr = "31/12/1998";
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com", theDateOfBirth);
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com", theDateOfBirth);
						
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the students
			System.out.println("\nSaving students ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
