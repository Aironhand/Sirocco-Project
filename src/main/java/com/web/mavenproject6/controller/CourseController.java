/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.controller;

import com.web.mavenproject6.entities.Courses;
import com.web.mavenproject6.service.CoursesServiceImp;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Aironhand
 */
@Controller
public class CourseController {

    @Autowired
    CoursesServiceImp coursesServiceImp;

    @RequestMapping("/admin/coursesPanel")
    public String cPanel(Map<String, Object> model) {
        model.put("Courses", coursesServiceImp.list());
        return "thy/coursesPanel";
    }

    @RequestMapping(value = "/course/add", method = RequestMethod.POST)
    public void addCourse(@RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam(required = false, value = "teacher", defaultValue = "false") String teacher,
            HttpServletResponse response, ModelMap map) throws IOException {
        Courses cCorse = new Courses();
        cCorse.setM_sTitle(title);
        cCorse.setM_sDescription(description);
        cCorse.setM_lPersonalId(Long.parseLong(teacher));
        coursesServiceImp.add(cCorse);
        response.sendRedirect("/admin/coursesPanel");
        // return "redirect:admin/apanel";
    }

    @RequestMapping(value = "/course/del/{m_lCourseId}")
    public void deleteUser(@PathVariable("m_lCourseId") String id, HttpServletRequest request, HttpServletResponse response, ModelMap map) throws IOException {
        coursesServiceImp.delete( Long.parseLong(id));
        map.addAttribute("id", id);
        response.sendRedirect("/admin/coursesPanel");
           //return "thy/coursesPanel";
    }
}
