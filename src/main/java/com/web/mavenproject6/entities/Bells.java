/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Aironhand
 */
@Entity
@Table(name="bells")
public class Bells implements Serializable {
    
    @OneToMany(mappedBy = "m_CBell",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Schedule> m_CSchedule;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long m_lBellId;
    
    private int m_nLesson;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date m_dBegin;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date m_dEnd;

    public Bells() {
        /*SimpleDateFormat format1 = new SimpleDateFormat("H:mm");
        format1.format(m_dBegin);
        format1.format(m_dEnd);*/
    }
    
}
