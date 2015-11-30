/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import java.util.HashMap;
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
@Table(name = "map")
public class Map implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lMapId;

    private int m_nCurrentFloor;
    private int m_nFloorCount;
    private HashMap<String,String>[] m_hmAuditories;
    private HashMap<String, String>[] m_hmMapSize;
    private byte[] m_aPhoto;
    
    @ManyToOne
    @JoinColumn(name = "m_lFacultyId", nullable = false)
    private Faculty m_CFaculty;
    
    public Map() {
       m_lMapId = -1;
       m_nCurrentFloor = -1;
       m_nFloorCount = -1;
       m_hmAuditories = null;
       m_hmMapSize = null;
       m_aPhoto = null;
    }

    public Map(long m_lMapId, int m_nCurrentFloor, int m_nFloorCount, Faculty m_CFaculty,
            HashMap<String ,String>[]  m_hmAuditories,HashMap<String,String>[] m_hmMapSize) {
        this.m_lMapId = m_lMapId;
        this.m_nCurrentFloor = m_nCurrentFloor;
        this.m_nFloorCount = m_nFloorCount;
        this.m_CFaculty = m_CFaculty;
        this.m_hmAuditories = m_hmAuditories;
        this.m_hmMapSize = m_hmMapSize;
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

    public byte[] getM_aPhoto() {
        return m_aPhoto;
    }

    public void setM_aPhoto(byte[] m_aPhoto) {
        this.m_aPhoto = m_aPhoto;
    }

    public HashMap<String, String>[] getM_hmAuditories() {
        return m_hmAuditories;
    }

    public void setM_hmAuditories(HashMap<String, String>[] m_hmAuditories) {
        this.m_hmAuditories = m_hmAuditories;
    }

    public HashMap<String, String>[] getM_hmMapSize() {
        return m_hmMapSize;
    }

    public void setM_hmMapSize(HashMap<String, String>[] m_hmMapSize) {
        this.m_hmMapSize = m_hmMapSize;
    }

    @Override
    public String toString(){
        JSONObject jMap = new JSONObject();
        try {
            jMap
                    .put("mapId", m_lMapId)
                    .put("fcltCurrentStage", m_nCurrentFloor)
                    .put("fcltStageCount", m_nFloorCount)
                    .put("fcltId", m_CFaculty.getM_lFacultyId())
                    .put("fcltName", m_CFaculty.getM_sTitle())
                    .put("fcltAuditories", m_hmAuditories)
                    .put("map", m_hmMapSize);
            return (new JSONObject()).put("map", jMap).toString();
        } catch (JSONException e) {
        }
        return "Error";
    }
}
