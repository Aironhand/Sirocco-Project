/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.controller;

import com.web.mavenproject6.entities.Schedule;
import com.web.mavenproject6.service.ScheduleService;
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
public class ScheduleController {

    @Autowired
    Environment env;

    @Autowired
    EntityManager em;
    
    @Autowired
    ScheduleService scheduleService;

    @ResponseBody
    @RequestMapping(value = "/getScheduleJSON*", method = RequestMethod.GET)
    public String getScheduleById(@RequestParam(value = "scheduleId") String id) throws JSONException {
        Schedule CSchedule;

        try {
            CSchedule = (Schedule) scheduleService.getSchedule(Long.parseLong(id));
            return CSchedule.toString();
        } catch (NullPointerException ex) {
            return "null";
        }

    }
}
