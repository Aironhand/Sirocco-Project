/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.repositories.MaterialsRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Aironhand
 */
public class MaterialsServiceImp implements MaterialsService {

    @Autowired
    private MaterialsRepository matRepository;

    @Override
    public long count() {
        return matRepository.count();
    }
}
