/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.service;

/**
 *
 * @author Aironhand
 */
public interface ScheduleService {
    Object getSchedule(long id);
    Object getSchedule(String fclt, String audNum);
}
