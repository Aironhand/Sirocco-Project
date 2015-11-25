/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "auditory")
public class Auditory implements Serializable {

    @OneToMany(mappedBy = "m_CAuditory",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Schedule> m_CSchedule;
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lAuditoryId;
    
    private String m_sNumber;
    private String m_sDescription;
    private String m_sTitle;
    
    
    private int[] m_aPersonal;
    private  byte[] m_aPhoto;
    
    @ManyToOne
    @JoinColumn(name = "m_lFacultyId",nullable = false)
    private Faculty m_CFaculty;

    public Auditory() {
    }

    public Auditory(long m_lAuditoryId, String m_sNumber, String m_sTitle) {
        this.m_lAuditoryId = m_lAuditoryId;
        this.m_sNumber = m_sNumber;
        this.m_sTitle = m_sTitle;
        
    }

    public long getM_lAuditoryId() {
        return m_lAuditoryId;
    }

    public void setM_lAuditoryId(long m_lAuditoryId) {
        this.m_lAuditoryId = m_lAuditoryId;
    }

    public String getM_sNumber() {
        return m_sNumber;
    }

    public void setM_sNumber(String m_sNumber) {
        this.m_sNumber = m_sNumber;
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

    public String getM_sDescription() {
        return m_sDescription;
    }

    public void setM_sDescription(String m_sDescription) {
        this.m_sDescription = m_sDescription;
    }

    public int[] getM_aPersonal() {
        return m_aPersonal;
    }

    public void setM_aPersonal(int[] m_aPersonal) {
        this.m_aPersonal = m_aPersonal;
    }

    public byte[] getM_aPhoto() {
        return m_aPhoto;
    }

    public void setM_aPhoto(byte[] m_aPhoto) {
        this.m_aPhoto = m_aPhoto;
    }

    public Faculty getM_CFaculty() {
        return m_CFaculty;
    }

    public void setM_CFaculty(Faculty m_CFaculty) {
        this.m_CFaculty = m_CFaculty;
    }
    
    @Override
    public String toString(){
    JSONObject m_jAuditory = new JSONObject();
        try{
            m_jAuditory
                    .put("id", m_lAuditoryId)
                    .put("title", m_sTitle)
                    .put("auditoryId", m_sNumber)
                    .put("description", m_sDescription)
                    .put("auditoryPersonal", m_aPersonal)
                    .put("fcltId",m_CFaculty.getM_lFacultyId());
             return (new JSONObject()).put("auditory", m_jAuditory).toString();
        }
        catch(JSONException e){
        }
        return "Error";
    }
}
