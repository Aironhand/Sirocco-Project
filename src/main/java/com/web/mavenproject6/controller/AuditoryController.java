/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.controller;

import com.web.mavenproject6.entities.Auditory;
import com.web.mavenproject6.service.AuditoryService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.ServletContext;

/**
 *
 * @author Aironhand
 */
@Controller
public class AuditoryController {

    @Autowired
    Environment env;

    @Autowired
    EntityManager em;

    @Autowired
    AuditoryService auditoryService;

    @Autowired
    ServletContext servletContext;

    @ResponseBody
    @RequestMapping(value = "/getAuditoryJSON*", method = RequestMethod.GET)
    public String getAuditoryByFcltftAudId(@RequestParam(value = "fcltId") String fcltId,
            @RequestParam(value = "AuditoryId") String audId) throws JSONException {
        Auditory aud;

        try {
            aud = (Auditory) auditoryService.getAuditoryByFcltftId(Long.parseLong(fcltId), Long.parseLong(audId));
            return aud.toString();
        } catch (NullPointerException ex) {
            return "null";
        }

    }

    @RequestMapping(value = "/getAuditoryPhoto*", method = RequestMethod.GET)
    public @ResponseBody
    BufferedImage getAuditoryPhoto(@RequestParam(value = "fcltId") String fcltId,
            @RequestParam(value = "AuditoryId") String audId) throws IOException  {
        Auditory aud;
        BufferedImage img;
        byte[] imageInByte;
        try {
            aud = (Auditory) auditoryService.getAuditoryByFcltftId(Long.parseLong(fcltId), Long.parseLong(audId));
            imageInByte = aud.getM_aPhoto();
            if (imageInByte.length > 1) {
                InputStream in = new ByteArrayInputStream(imageInByte);
                img = ImageIO.read(in);
            } else {

                InputStream in = servletContext.getResourceAsStream("/resources/img/noimg.png");
                img = ImageIO.read(in);
            }
            return img;
        } catch (NullPointerException ex) {
            InputStream in = servletContext.getResourceAsStream("/resources/img/noimg.png");
            img = ImageIO.read(in);
            return img;
        }

    }
}
