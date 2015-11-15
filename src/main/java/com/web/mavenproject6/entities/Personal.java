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
import org.json.JSONArray;
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
    private List<Materials> m_CMaterials;

    @OneToMany(mappedBy = "m_CPersonal",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Courses> m_cCourses;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lPersonalId;

    private String m_sFST;
    private String m_sTitle;
    private String m_sBday;
    private String m_sInfo;

    @ManyToOne
    @JoinColumn(name = "m_lFacultyId", nullable = false)
    private Faculty m_CFaculty;

    @ManyToOne
    @JoinColumn(name = "m_lAuditoryId")
    private Auditory m_CAuditory;

    public Personal() {
        this.m_lPersonalId = -1;
        this.m_sFST = "";
        this.m_sBday = "";
        this.m_sInfo = "";
        this.m_sTitle = "";
    }

    public Personal(long m_lPersonalId, String m_sFST, String m_sTitle, String m_sBday, String m_sInfo) {
        this.m_lPersonalId = m_lPersonalId;
        this.m_sFST = m_sFST;
        this.m_sBday = m_sBday;
        this.m_sInfo = m_sInfo;
        this.m_sTitle = m_sTitle;
    }

    public List<Materials> getM_CMaterials() {
        return m_CMaterials;
    }

    public void setM_CMaterials(List<Materials> m_CMaterials) {
        this.m_CMaterials = m_CMaterials;
    }

    public List<Courses> getM_cCourses() {
        return m_cCourses;
    }

    public void setM_cCourses(List<Courses> m_cCourses) {
        this.m_cCourses = m_cCourses;
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

    @Override
    public String toString() {
        JSONObject jTeacher = new JSONObject();
        JSONArray jCoursesArray = new JSONArray();
        jCoursesArray.put(m_cCourses);
        try {

            jTeacher
                    .put("perosnalId", m_lPersonalId)
                    .put("name", m_sFST)
                    .put("title", m_sTitle)
                    .put("birthday", m_sBday)
                    .put("otherInfo", m_sInfo)
                    .put("courses", m_cCourses.toString())
                    .put("documents", m_CMaterials.toString());
            return (new JSONObject()).put("personal", jTeacher).toString();
        } catch (JSONException e) {
        }
        return "Error";
    }

}
