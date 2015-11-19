/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Map;
import com.web.mavenproject6.repositories.MapRepository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aironhand
 */
@Service
public class MapServiceImp implements MapService {
    
    @Autowired
    private EntityManager em;
    
    @Autowired
    private MapRepository mapRepository;
    
    @Override
    public Object getMap(long fclt, int stage) throws NullPointerException  {
        try {
            TypedQuery query = em.createQuery("select m from Map m where m.m_CFaculty.m_lFacultyId =?1 and m.m_nCurrentFloor = ?2", Map.class);
            query.setParameter(1, fclt)
                 .setParameter(2, stage);
            return query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
