/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.controller;

import com.web.mavenproject6.entities.Map;
import com.web.mavenproject6.service.MapService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Aironhand
 */
@Controller
public class MapController {

    @Autowired
    EntityManager em;

    @Autowired
    MapService mapService;

    @Autowired
    ServletContext servletContext;

    @ResponseBody
    @RequestMapping(value = "/getMapJSON*", method = RequestMethod.GET)
    public String getMap(@RequestParam(value = "fcltId") String fcltId, 
            @RequestParam (required = false, value = "stage", defaultValue = "1") String stage) throws JSONException {
        Map CMap;
        try {
            CMap = (Map) mapService.getMap(Long.parseLong(fcltId),Integer.parseInt(stage));
            return CMap.toString();
        } catch (NullPointerException ex) {
            return "null";
        }

    }

    @ResponseBody
    @RequestMapping(value = "/getMapPhoto*", method = RequestMethod.GET)
    public BufferedImage getMapPhoto(@RequestParam(value = "fcltId") String fcltId, String stage) throws JSONException, IOException {
        Map CMap;
        BufferedImage img;
        byte[] imageInByte;
        try {
            CMap = (Map) mapService.getMap(Long.parseLong(fcltId), stage == null ? 1 : Integer.parseInt(stage));
            imageInByte = CMap.getM_aPhoto();
            if (imageInByte.length > 1) {
                InputStream in = new ByteArrayInputStream(imageInByte);
                img = ImageIO.read(in);
            } else {

                InputStream in = servletContext.getResourceAsStream("/resources/img/no_map.jpg");
                img = ImageIO.read(in);
            }
            return img;
        } catch (NullPointerException ex) {
            InputStream in = servletContext.getResourceAsStream("/resources/img/no_map.jpg");
            img = ImageIO.read(in);
            return img;
        }

    }
}
