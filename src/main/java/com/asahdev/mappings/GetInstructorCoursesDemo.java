package com.asahdev.mappings;

import com.asahdev.HBUtils;
import com.asahdev.entity.Course;
import com.asahdev.entity.Instructor;
import com.asahdev.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = HBUtils.getSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 4;
			Instructor tempInstructor = session.get(Instructor.class, theId);		
			
			System.out.println("Instructor: " + tempInstructor);
			
			// get courses for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}