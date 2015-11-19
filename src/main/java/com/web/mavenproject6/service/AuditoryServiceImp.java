/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Auditory;
import com.web.mavenproject6.repositories.AuditoryRepository;
import java.awt.image.BufferedImage;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aironhand
 */
@Service
public class AuditoryServiceImp implements AuditoryService {

    @Autowired
    private AuditoryRepository auditoryRepository;

    @Autowired
    private EntityManager em;

    @Override
    public Object getAuditoryByFcltftId(long fcltId, long audId) throws NullPointerException {
        try {
            TypedQuery query = em.createQuery("select a from Auditory a where a.m_lAuditoryId =?1 "
                    + "and a.m_CFaculty.m_lFacultyId = ?2", Auditory.class);
            query.setParameter(1, audId)
                    .setParameter(2, fcltId);
            return query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
