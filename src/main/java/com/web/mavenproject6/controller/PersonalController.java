    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.controller;

import com.web.mavenproject6.entities.Courses;
import com.web.mavenproject6.entities.Materials;
import com.web.mavenproject6.entities.Personal;
import com.web.mavenproject6.service.CoursesService;
import com.web.mavenproject6.service.MaterialsService;
import com.web.mavenproject6.service.PersonalService;
import java.util.List;
import javax.persistence.EntityManager;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Aironhand
 */
@Controller
public class PersonalController {

    @Autowired
    Environment env;

    @Autowired
    EntityManager em;

    @Autowired
    CoursesService coursesService;

    @Autowired
    PersonalService personalService;

    @Autowired
    MaterialsService materialsService;

    @ResponseBody
    @RequestMapping(value = "/getPersonalJSON*", method = RequestMethod.GET)
    public String getPersonalById(@RequestParam(value = "personalId") String id) {
        Personal cPersonal;
        List<Courses> lCourses;
        List<Materials> lMaterials;

        try {
            cPersonal = (Personal) personalService.getPersonalById(Long.parseLong(id));
            lCourses = (List<Courses>) coursesService.getLessonByPerson(Long.parseLong(id));
            lMaterials = (List<Materials>) materialsService.getMaterialByPerson(Long.parseLong(id));
            return cPersonal.toString(lCourses, lMaterials);
        } catch (NullPointerException ex) {
            return "null";
        }

    }
}
