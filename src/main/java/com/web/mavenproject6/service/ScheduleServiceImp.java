/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Schedule;
import com.web.mavenproject6.repositories.ScheduleRepository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aironhand
 */
@Service
public class ScheduleServiceImp implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private EntityManager em;

    @Override
    public Object getSchedule(long id) throws NullPointerException {
        try {
            TypedQuery query = em.createQuery("select s from Schedule s where s.m_lScheduleId = ?1", Schedule.class);
            query.setParameter(1, id);
            return query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Object getSchedule(String fclt, String audNum) throws NullPointerException {
        try {
            TypedQuery query = em.createQuery("select s from Schedule s where s.m_CAuditory.m_CFaculty.m_sTitle = ?1 and s.m_CAuditory.m_sNumber = ?2", Schedule.class);
            query.setParameter(1, fclt);
            query.setParameter(2, audNum);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
}
