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
@Table(name = "materials")
public class Materials implements Serializable {

    @ManyToOne
    @JoinColumn(name = "m_lCourseId", nullable = false)
    private Courses m_cCourse;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lMaterialsId;

    private String m_sName;
    private String m_sType;
    private String m_sAddress;
    private long m_lPersonalId;

    public Materials() {
        this.m_lMaterialsId = -1;
        this.m_sType = "";
        this.m_sAddress = "";
        this.m_sName = "";
        this.m_lPersonalId = -1;
    }

    public Materials(long m_lMaterialsId, String m_sName, String m_sType, String m_sAddress, int m_lPersonalId) {
        this.m_lMaterialsId = m_lMaterialsId;
        this.m_sType = m_sType;
        this.m_sAddress = m_sAddress;
        this.m_sName = m_sName;
        this.m_lPersonalId = m_lPersonalId;
    }

    public Courses getM_cCourse() {
        return m_cCourse;
    }

    public void setM_cCourse(Courses m_cCourse) {
        this.m_cCourse = m_cCourse;
    }

    public String getM_sName() {
        return m_sName;
    }

    public void setM_sName(String m_sName) {
        this.m_sName = m_sName;
    }

    public long getM_lMaterialsId() {
        return m_lMaterialsId;
    }

    public void setM_lMaterialsId(long m_lMaterialsId) {
        this.m_lMaterialsId = m_lMaterialsId;
    }

    public String getM_sType() {
        return m_sType;
    }

    public void setM_sType(String m_sType) {
        this.m_sType = m_sType;
    }

    public String getM_sAddress() {
        return m_sAddress;
    }

    public void setM_sAddress(String m_sAddress) {
        this.m_sAddress = m_sAddress;
    }

    public long getM_lPersonalId() {
        return m_lPersonalId;
    }

    public void setM_lPersonalId(long m_lPersonalId) {
        this.m_lPersonalId = m_lPersonalId;
    }

    @Override
    public String toString() {
        JSONObject m_jMaterial = new JSONObject();
        try {
            m_jMaterial
                    .put("materialsId", m_lMaterialsId)
                    .put("courseId", m_cCourse.getM_lCourseId())
                    .put("type", m_sType)
                    .put("address", m_sAddress);
            return (new JSONObject()).put("materials", m_jMaterial).toString();
        } catch (JSONException e) {
        }
        return "Error";
    }

}
