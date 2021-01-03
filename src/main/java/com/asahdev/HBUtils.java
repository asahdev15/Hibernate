package com.asahdev;

import com.asahdev.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtils {

    public static SessionFactory getSessionFactory(){
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

}
