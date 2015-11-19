/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Materials;
import com.web.mavenproject6.repositories.MaterialsRepository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aironhand
 */
@Service
public class MaterialsServiceImp implements MaterialsService {

    @Autowired
    private MaterialsRepository matRepository;

    @Autowired
    EntityManager em;

    @Override
    public long count() {
        return matRepository.count();
    }

    @Override
    public Object getMaterialByPerson(long id) throws NullPointerException {
        try {
            TypedQuery query = em.createQuery("select m from Materials m where m.m_lPersonalId = ?1", Materials.class);
            query.setParameter(1, id);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
}
