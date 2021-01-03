package com.asahdev.mappings;

import com.asahdev.HBUtils;
import com.asahdev.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeletePacmanCourseDemo {

	public static void main(String[] args) {

		SessionFactory factory = HBUtils.getSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get the pacman course from db
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			// delete the course
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