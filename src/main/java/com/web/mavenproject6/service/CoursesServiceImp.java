/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Courses;
import com.web.mavenproject6.repositories.CoursesRepository;
import java.util.List;
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

    public List<Courses> list() {
        return (List<Courses>) coursesRepository.findAll();
    }

    @Override
    public void add(Courses course) {
        coursesRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        coursesRepository.delete(id);
    }

    @Override
    public Object getLesson() throws NullPointerException {
        try {
            TypedQuery query = em.createQuery("select c from Courses c", Courses.class);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Object getLesson(long m_lCourseId) throws NullPointerException {
        TypedQuery query = em.createQuery("select c from Courses c where c.m_lCourseId = ?1", Courses.class)
                .setParameter(1, m_lCourseId);
        return query.getResultList();

    }

    @Override
    public Object getLessonByPerson(long id) throws NullPointerException {
        try {
            TypedQuery query = em.createQuery("select c from Courses c where c.m_lPersonalId = ?1", Courses.class)
                    .setParameter(1, id);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
}
