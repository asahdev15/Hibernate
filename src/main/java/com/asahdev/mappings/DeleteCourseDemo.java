package com.asahdev.mappings;

import com.asahdev.HBUtils;
import com.asahdev.entity.Course;
import com.asahdev.entity.Instructor;
import com.asahdev.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = HBUtils.getSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get a course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// delete course
			System.out.println("Deleting course: " + tempCourse);
			
			session.delete(tempCourse);

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

