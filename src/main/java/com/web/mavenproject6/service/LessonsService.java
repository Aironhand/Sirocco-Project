/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Lessons;
import com.web.mavenproject6.repositories.LessonsRepository;

/**
 *
 * @author Aironhand
 */
public interface LessonsService {
    long count();
    Object getLesson(long id);
    Object getLesson();
    LessonsRepository getRepository();
}
