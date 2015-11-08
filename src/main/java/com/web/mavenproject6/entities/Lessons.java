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
@Table(name = "lessons")
public class Lessons implements Serializable {

    @OneToMany(mappedBy = "m_cLesson",
            cascade = CascadeType.ALL)
    private List<Materials> m_cMaterials;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lLessonId;
    private String m_sDescription;
    private String m_sTitle;
    //private Teacher m_cTeacher;
    public Lessons() {
        this.m_lLessonId = -1;
        this.m_sTitle = "";
        m_cMaterials = new ArrayList<Materials>();
    }

    public Lessons(long m_lLessonId, String m_sTitle) {
        this.m_lLessonId = m_lLessonId;
        this.m_sTitle = m_sTitle;
        m_cMaterials = new ArrayList<Materials>();
    }
    
    public List<Materials> getM_cMaterials(){
        return m_cMaterials;
    }
    
    public void addMaterial(Materials m){
        m_cMaterials.add(m);
    }
    
    public void setM_cMaterials(List<Materials> m_cMaterials){
       this.m_cMaterials = m_cMaterials;
    }
    
    public long getM_lLessonId() {
        return m_lLessonId;
    }

    public void setM_lLessonId(long m_lLessonId) {
        this.m_lLessonId = m_lLessonId;
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
                    .put("lessonId", m_lLessonId)
                    .put("title", m_sTitle)
                    .put("description", m_sDescription)
                    /*.put("teacher", m_sTeacher)*/;
             return (new JSONObject()).put("lessons", m_jLesson).toString();
        }
        catch(JSONException e){
        }
        return "Error";
    }
}
