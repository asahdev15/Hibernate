package com.asahdev.mappings;

import com.asahdev.HBUtils;
import com.asahdev.entity.Course;
import com.asahdev.entity.Instructor;
import com.asahdev.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = HBUtils.getSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// option 2: Hibernate query with HQL
			
			// get the instructor from db
			int theId = 1;

			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
									+ "JOIN FETCH i.courses "
									+ "where i.id=:theInstructorId", 
							Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("luv2code: Instructor: " + tempInstructor);	
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("\nluv2code: The session is now closed!\n");
			
			// get courses for the instructor
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
