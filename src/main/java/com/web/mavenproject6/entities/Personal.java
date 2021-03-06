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
@Table(name = "personal")
public class Personal implements Serializable {

    @OneToMany(mappedBy = "m_CPersonal",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Schedule> m_CSchedule;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lPersonalId;

    private String m_sFST;
    private String m_sTitle;
    private String m_sBday;
    private String m_sInfo;
    private String m_sWorkThems;
    private byte[] m_aPhoto;
    
    
    @ManyToOne
    @JoinColumn(name = "m_lFacultyId", nullable = false)
    private Faculty m_CFaculty;

    public Personal() {
        this.m_lPersonalId = -1;
        this.m_sFST = "";
        this.m_sBday = "";
        this.m_sInfo = "";
        this.m_sTitle = "";
    }

    public Personal(long m_lPersonalId, String m_sFST, String m_sTitle, String m_sBday, String m_sInfo, 
            String m_sWorkThems) {
        this.m_lPersonalId = m_lPersonalId;
        this.m_sFST = m_sFST;
        this.m_sBday = m_sBday;
        this.m_sInfo = m_sInfo;
        this.m_sTitle = m_sTitle;
        this.m_sWorkThems = m_sWorkThems;
    }

    public long getM_lPersonalId() {
        return m_lPersonalId;
    }

    public void setM_lPersonalId(long m_lPersonalId) {
        this.m_lPersonalId = m_lPersonalId;
    }

    public String getM_sFST() {
        return m_sFST;
    }

    public void setM_sFST(String m_sFST) {
        this.m_sFST = m_sFST;
    }

    public String getM_sTitle() {
        return m_sTitle;
    }

    public void setM_sTitle(String m_sTitle) {
        this.m_sTitle = m_sTitle;
    }

    public String getM_sBday() {
        return m_sBday;
    }

    public void setM_sBday(String m_sBday) {
        this.m_sBday = m_sBday;
    }

    public String getM_sInfo() {
        return m_sInfo;
    }

    public void setM_sInfo(String m_sInfo) {
        this.m_sInfo = m_sInfo;
    }

    public String getM_sWorkItems() {
        return m_sWorkThems;
    }

    public void setM_sWorkItems(String m_sWorkThems) {
        this.m_sWorkThems = m_sWorkThems;
    }

    public Faculty getM_CFaculty() {
        return m_CFaculty;
    }

    public void setM_CFaculty(Faculty m_CFaculty) {
        this.m_CFaculty = m_CFaculty;
    }

    public List<Schedule> getM_CSchedule() {
        return m_CSchedule;
    }

    public void setM_CSchedule(List<Schedule> m_CSchedule) {
        this.m_CSchedule = m_CSchedule;
    }

    public String getM_sWorkThems() {
        return m_sWorkThems;
    }

    public void setM_sWorkThems(String m_sWorkThems) {
        this.m_sWorkThems = m_sWorkThems;
    }

    public byte[] getM_aPhoto() {
        return m_aPhoto;
    }

    public void setM_aPhoto(byte[] m_aPhoto) {
        this.m_aPhoto = m_aPhoto;
    }

    @Override
    public String toString() {
        JSONObject jPerson = new JSONObject();
        try {
            jPerson
                    .put("perosnalId", m_lPersonalId)
                    .put("name", m_sFST)
                    .put("title", m_sTitle)
                    .put("birthday", m_sBday)
                    .put("otherInfo", m_sInfo)
                    .put("workThems", m_sWorkThems)
                   /* .put("courses", m_CSchedule)*/;
            return (new JSONObject()).put("personal", jPerson).toString();
        } catch (JSONException e) {
        }
        return "Error";
    }
    
    public String toString(List<Courses> lCourses, List<Materials> lMaterials) {
        JSONObject jPerson = new JSONObject();
        try {
            jPerson
                    .put("perosnalId", m_lPersonalId)
                    .put("name", m_sFST)
                    .put("title", m_sTitle)
                    .put("birthday", m_sBday)
                    .put("otherInfo", m_sInfo)
                    .put("workThems", m_sWorkThems)
                    .put("courses", lCourses)
                    .put("documents", lMaterials);
            return (new JSONObject()).put("personal", jPerson).toString();
        } catch (JSONException e) {
        }
        return "Error";
    }

}
