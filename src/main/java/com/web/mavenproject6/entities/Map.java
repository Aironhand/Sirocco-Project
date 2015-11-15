/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import java.util.HashMap;
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
@Table(name = "map")
public class Map implements Serializable {

    @OneToMany(mappedBy = "m_CMap",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Auditory> m_CAuditory;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lMapId;

    private int m_nCurrentFloor;
    private int m_nFloorCount;
    
    
    @ManyToOne
    @JoinColumn(name = "m_lFacultyId", nullable = false)
    private Faculty m_CFaculty;
    
    public Map() {
    }

    public Map(long m_lMapId, int m_nCurrentFloor, int m_nFloorCount, Faculty m_CFaculty) {
        this.m_lMapId = m_lMapId;
        this.m_nCurrentFloor = m_nCurrentFloor;
        this.m_nFloorCount = m_nFloorCount;
        this.m_CFaculty = m_CFaculty;
    }

    public long getM_lMapId() {
        return m_lMapId;
    }

    public void setM_lMapId(long m_lMapId) {
        this.m_lMapId = m_lMapId;
    }

    public int getM_nCurrentFloor() {
        return m_nCurrentFloor;
    }

    public void setM_nCurrentFloor(int m_nCurrentFloor) {
        this.m_nCurrentFloor = m_nCurrentFloor;
    }

    public int getM_nFloorCount() {
        return m_nFloorCount;
    }

    public void setM_nFloorCount(int m_nFloorCount) {
        this.m_nFloorCount = m_nFloorCount;
    }

    public Faculty getM_CFaculty() {
        return m_CFaculty;
    }

    public void setM_CFaculty(Faculty m_CFaculty) {
        this.m_CFaculty = m_CFaculty;
    }

}
