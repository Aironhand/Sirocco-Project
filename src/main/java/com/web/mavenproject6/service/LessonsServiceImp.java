/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Lessons;
import com.web.mavenproject6.repositories.LessonsRepository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aironhand
 */
@Service
public class LessonsServiceImp implements LessonsService {

    @Autowired
    private LessonsRepository lessonsRepository;

    @Autowired
    private EntityManager em;

    @Override
    public LessonsRepository getRepository() {
        return lessonsRepository;
    }

    @Override
    public long count() {
        return lessonsRepository.count();
    }

    @Override
    public Object getLesson() {
        try {
            TypedQuery query = em.createQuery("select l from Lessons l", Lessons.class);
// return em.createQuery("from Lessons", Lessons.class)
            // .setParameter("m_lLessonId", m_lLessonId)
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Object getLesson(long m_lLessonId) {
        try {
            return em.createQuery("from Lessons where m_lLessonId = :m_lLessonId", Lessons.class)
                    .setParameter("m_lLessonId", m_lLessonId)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
        /* TypedQuery query = em.createQuery("select l from Lessons l where l.m_lLessonId = ?1", Lessons.class);
         query.setParameter(1, m_lLessonId);

         try {
         return query.getSingleResult();
         } catch (Exception ee) {
         return null;
         }*/
    }
}
