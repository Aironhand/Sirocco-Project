/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

import com.web.mavenproject6.entities.Courses;
import com.web.mavenproject6.repositories.CoursesRepository;

/**
 *
 * @author Aironhand
 */
public interface CoursesService {
    long count();
    Object getLesson(long id);
    Object getLesson();
    CoursesRepository getRepository();
}
