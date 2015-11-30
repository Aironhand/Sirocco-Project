/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Faculty;
import com.web.mavenproject6.repositories.FacultyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aironhand
 */
@Service
public class FacultyServiceImp implements FacultyService{
    
    @Autowired
    private FacultyRepository fcltRepository;

    @Override
    public void add(Faculty fclt) {
        fcltRepository.save(fclt);
    }
    
    @Override
    public long count() {
        return fcltRepository.count();
    }


    @Override
    public void delete(Long id) {
         fcltRepository.delete(id);
    }
    
    public List<Faculty> list(){
        return (List<Faculty>) fcltRepository.findAll();
    }
}
