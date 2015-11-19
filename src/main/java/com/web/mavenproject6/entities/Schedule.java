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

      
    @ManyToOne
    @JoinColumn(name = "m_lPersonalId")
    private Personal m_CPersonal;
    
    @ManyToOne
    @JoinColumn(name = "m_lAuditoryId")
    private Auditory m_CAuditory;
    
    @ManyToOne
    @JoinColumn(name = "m_lCourseId")
    private Courses m_CCourse;
    
    @ManyToOne
    @JoinColumn(name = "m_lBellId")
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
    

}
