/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Aironhand
 */
@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lScheduleId;

    private String m_sDay;
    private String m_sCourse;
    private String m_sType;
    private String m_sGroup;
    private String m_sWeek;
    
    @ManyToOne
    @JoinColumn(name = "m_lPersonalId",nullable = false)
    private Personal m_CPersonal;

    @ManyToOne
    @JoinColumn(name = "m_lAuditoryId",nullable = false)
    private Auditory m_CAuditory;

    @ManyToOne
    @JoinColumn(name = "m_lCourseId",nullable = false)
    private Courses m_CCourse;

    @ManyToOne
    @JoinColumn(name = "m_lBellId",nullable = false)
    private Bells m_CBell;

    public Schedule() {
    }

    public Schedule(long m_lScheduleId, String m_sDay, String m_sCourse, String m_sType, String m_sGroup) {
        this.m_lScheduleId = m_lScheduleId;
        this.m_sDay = m_sDay;
        this.m_sCourse = m_sCourse;
        this.m_sType = m_sType;
        this.m_sGroup = m_sGroup;
    }

    public void setM_lScheduleId(long m_lScheduleId) {
        this.m_lScheduleId = m_lScheduleId;
    }

    public void setM_sDay(String m_sDay) {
        this.m_sDay = m_sDay;
    }

    public void setM_sCourse(String m_sCourse) {
        this.m_sCourse = m_sCourse;
    }

    public void setM_sType(String m_sType) {
        this.m_sType = m_sType;
    }

    public void setM_sGroup(String m_sGroup) {
        this.m_sGroup = m_sGroup;
    }

    public Personal getM_CPersonal() {
        return m_CPersonal;
    }

    public void setM_CPersonal(Personal m_CPersonal) {
        this.m_CPersonal = m_CPersonal;
    }

    public Auditory getM_CAuditory() {
        return m_CAuditory;
    }

    public void setM_CAuditory(Auditory m_CAuditory) {
        this.m_CAuditory = m_CAuditory;
    }

    public Courses getM_CCourse() {
        return m_CCourse;
    }

    public void setM_CCourse(Courses m_CCourse) {
        this.m_CCourse = m_CCourse;
    }

    public Bells getM_CBell() {
        return m_CBell;
    }

    public void setM_CBell(Bells m_CBell) {
        this.m_CBell = m_CBell;
    }

    public String getM_sWeek() {
        return m_sWeek;
    }

    public void setM_sWeek(String m_sWeek) {
        this.m_sWeek = m_sWeek;
    }

    @Override
    public String toString() {
        JSONObject jShedule = new JSONObject();
        try {
            jShedule
                    .put("scheduleId", m_lScheduleId)
                    .put("day", m_sDay)
                    .put("course", m_sCourse)
                    .put("group", m_sGroup)
                    .put("type", m_sType)
                    .put("week",m_sWeek)
                    .put("teacher", m_CPersonal.getM_sFST())
                    .put("bell", m_CBell.toString())
                    .put("auditory", m_CAuditory.getM_sNumber());
            return (new JSONObject()).put("schedule", jShedule).toString();
        } catch (JSONException e) {
        }
        return "Error";
    }

}
