/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Personal;
import com.web.mavenproject6.repositories.PersonalRepository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aironhand
 */
@Service
public class PersonalServiceImp implements PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    EntityManager em;

    @Override
    public Object getPersonalById(long id) throws NullPointerException {
        try {
            TypedQuery query = em.createQuery("select p from Personal p where p.m_lPersonalId = ?1", Personal.class);
            query.setParameter(1, id);
            return query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
