/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Aironhand
 */
@Entity
@Table(name = "courses")
public class Courses implements Serializable {

    @OneToMany(mappedBy = "m_cCourse",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Materials> m_CMaterials;
    
    @OneToMany(mappedBy = "m_CCourse",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Schedule> m_CSchedule;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lCourseId;
  
    private String m_sDescription;
    private String m_sTitle;
    private long m_lPersonalId;
    
    public Courses() {
        this.m_lCourseId = -1;
        this.m_sTitle = "";
        this.m_sDescription = "";
    }

    public Courses(long m_lCourseId, String m_sTitle, String m_sDescription) {
        this.m_lCourseId = m_lCourseId;
        this.m_sTitle = m_sTitle;
        this.m_sDescription = m_sDescription;
    }

    public List<Materials> getM_CMaterials() {
        return m_CMaterials;
    }

    public void setM_CMaterials(List<Materials> m_CMaterials) {
        this.m_CMaterials = m_CMaterials;
    }

    public String getM_sDescription() {
        return m_sDescription;
    }

    public void setM_sDescription(String m_sDescription) {
        this.m_sDescription = m_sDescription;
    }
   
    public long getM_lCourseId() {
        return m_lCourseId;
    }

    public void setM_lCourseId(long m_lLessonId) {
        this.m_lCourseId = m_lLessonId;
    }

    public String getM_sTitle() {
        return m_sTitle;
    }

    public void setM_sTitle(String m_sTitle) {
        this.m_sTitle = m_sTitle;
    }

    public List<Schedule> getM_CSchedule() {
        return m_CSchedule;
    }

    public void setM_CSchedule(List<Schedule> m_CSchedule) {
        this.m_CSchedule = m_CSchedule;
    }

    public long getM_lPersonalId() {
        return m_lPersonalId;
    }

    public void setM_lPersonalId(long m_lPersonalId) {
        this.m_lPersonalId = m_lPersonalId;
    }

    @Override
    public String toString(){
        JSONObject m_jLesson = new JSONObject();
        try{
            m_jLesson
                    .put("lessonId", m_lCourseId)
                    .put("title", m_sTitle)
                    .put("description", m_sDescription);
             return (new JSONObject()).put("lessons", m_jLesson).toString();
        }
        catch(JSONException e){
        }
        return "Error";
    }
}
