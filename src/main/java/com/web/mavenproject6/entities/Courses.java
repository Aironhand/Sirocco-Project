/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lCourseId;
  
    private String m_sDescription;
    private String m_sTitle;
    
    @ManyToOne
    @JoinColumn(name = "m_lPersonalId",nullable = false)
    private Personal m_CPersonal;
    
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

    public Personal getM_CPersonal() {
        return m_CPersonal;
    }

    public void setM_CPersonal(Personal m_CPersonal) {
        this.m_CPersonal = m_CPersonal;
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

    @Override
    public String toString(){
        JSONObject m_jLesson = new JSONObject();
        try{
            m_jLesson
                    .put("lessonId", m_lCourseId)
                    .put("title", m_sTitle)
                    .put("description", m_sDescription)
                    .put("teacher", m_CPersonal.getM_lPersonalId());
             return (new JSONObject()).put("lessons", m_jLesson).toString();
        }
        catch(JSONException e){
        }
        return "Error";
    }
}
