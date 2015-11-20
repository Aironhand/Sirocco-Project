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
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Aironhand
 */
@Entity
@Table(name = "bells")
public class Bells implements Serializable {

    @OneToMany(mappedBy = "m_CBell",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Schedule> m_CSchedule;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lBellId;

    private int m_nLesson;

    private String m_sBegin;
    private String m_sEnd;

    public Bells() {
        /*SimpleDateFormat format1 = new SimpleDateFormat("H:mm");
         format1.format(m_dBegin);
         format1.format(m_dEnd);*/
    }

    public List<Schedule> getM_CSchedule() {
        return m_CSchedule;
    }

    public void setM_CSchedule(List<Schedule> m_CSchedule) {
        this.m_CSchedule = m_CSchedule;
    }

    public long getM_lBellId() {
        return m_lBellId;
    }

    public void setM_lBellId(long m_lBellId) {
        this.m_lBellId = m_lBellId;
    }

    public int getM_nLesson() {
        return m_nLesson;
    }

    public void setM_nLesson(int m_nLesson) {
        this.m_nLesson = m_nLesson;
    }

    public String getM_sBegin() {
        return m_sBegin;
    }

    public void setM_sBegin(String m_sBegin) {
        this.m_sBegin = m_sBegin;
    }

    public String getM_sEnd() {
        return m_sEnd;
    }

    public void setM_sEnd(String m_sEnd) {
        this.m_sEnd = m_sEnd;
    }

    

    @Override
    public String toString() {
        JSONObject jBell = new JSONObject();
        try {
            jBell
                    .put("bellId", m_lBellId)
                    .put("number", m_nLesson)
                    .put("begin", m_sBegin)
                    .put("end", m_sEnd);
            return (new JSONObject()).put("bell", jBell).toString();
        } catch (JSONException e) {
        }
        return "Error";
    }

}
