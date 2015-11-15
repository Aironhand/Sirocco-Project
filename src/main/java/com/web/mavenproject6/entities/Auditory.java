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
    private List<Personal> m_CPersonal;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lAuditoryId;

    private String m_sNumber;
    private String m_sTitle;
    private String m_sInfo;
    
    @ManyToOne
    @JoinColumn(name = "m_lFacultyId")
    private Faculty m_CFaculty;

    @ManyToOne
    @JoinColumn(name = "m_lMapId")
    private Map m_CMap;

    public Auditory() {
    }

    public Auditory(List<Personal> m_CPersonal, long m_lAuditoryId, String m_sNumber, String m_sTitle, String m_sInfo) {
        this.m_CPersonal = m_CPersonal;
        this.m_lAuditoryId = m_lAuditoryId;
        this.m_sNumber = m_sNumber;
        this.m_sTitle = m_sTitle;
        this.m_sInfo = m_sInfo;
    }

    public List<Personal> getM_CPersonal() {
        return m_CPersonal;
    }

    public void setM_CPersonal(List<Personal> m_CPersonal) {
        this.m_CPersonal = m_CPersonal;
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

    public String getM_sInfo() {
        return m_sInfo;
    }

    public void setM_sInfo(String m_sInfo) {
        this.m_sInfo = m_sInfo;
    }
    
}
