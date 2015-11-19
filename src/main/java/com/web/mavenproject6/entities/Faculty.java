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

/**
 *
 * @author Aironhand
 */
@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {

    @OneToMany(mappedBy = "m_CFaculty",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Personal> m_CPersonal;

    @OneToMany(mappedBy = "m_CFaculty",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Auditory> m_CAuditory;

    @OneToMany(mappedBy = "m_CFaculty",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Map> m_CMap;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lFacultyId;

    private String m_sTitle;
    private String m_sInfo;

    public Faculty() {
        this.m_lFacultyId = -1;
        this.m_sTitle = "";
        this.m_sInfo = "";
    }

    public Faculty(long m_lFacultyId, String m_sTitle, String m_sInfo) {
        this.m_lFacultyId = m_lFacultyId;
        this.m_sTitle = m_sTitle;
        this.m_sInfo = m_sInfo;
    }

    public long getM_lFacultyId() {
        return m_lFacultyId;
    }

    public void setM_lFacultyId(long m_lFacultyId) {
        this.m_lFacultyId = m_lFacultyId;
    }

    public String getM_sTitle() {
        return m_sTitle;
    }

    public void setM_sTitle(String m_sTitle) {
        this.m_sTitle = m_sTitle;
    }

    public String getM_sInfo() {
        return m_sInfo;
    }

    public void setM_sInfo(String m_sInfo) {
        this.m_sInfo = m_sInfo;
    }

    public List<Personal> getM_CPersonal() {
        return m_CPersonal;
    }

    public void setM_CPersonal(List<Personal> m_CPersonal) {
        this.m_CPersonal = m_CPersonal;
    }

    public List<Auditory> getM_CAuditory() {
        return m_CAuditory;
    }

    public void setM_CAuditory(List<Auditory> m_CAuditory) {
        this.m_CAuditory = m_CAuditory;
    }

    public List<Map> getM_CMap() {
        return m_CMap;
    }

    public void setM_CMap(List<Map> m_CMap) {
        this.m_CMap = m_CMap;
    }
    
}
