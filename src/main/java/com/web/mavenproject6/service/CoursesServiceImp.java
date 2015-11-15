/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Courses;
import com.web.mavenproject6.repositories.CoursesRepository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aironhand
 */
@Service
public class CoursesServiceImp implements CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private EntityManager em;

    @Override
    public CoursesRepository getRepository() {
        return coursesRepository;
    }

    @Override
    public long count() {
        return coursesRepository.count();
    }

    @Override
    public Object getLesson() {
        try {
            TypedQuery query = em.createQuery("select c from Courses c", Courses.class);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Object getLesson(long CourseId) throws NullPointerException {
        /*   try {
         return em.createQuery("from Courses where  m_lCourseId = :m_lLessonId", Courses.class)
         .setParameter("m_lLessonId", m_lLessonId)
         .getSingleResult();
         } catch (Exception ex) {
         return null;
         }*/
        TypedQuery query = em.createQuery("select c from Courses c where c.m_lCourseId = ?1", Courses.class);
        query.setParameter(1, CourseId);

        try {
            return query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
