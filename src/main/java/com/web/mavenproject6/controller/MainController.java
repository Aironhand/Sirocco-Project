/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.mavenproject6.controller;

import com.web.mavenproject6.entities.Lessons;
import com.web.mavenproject6.entities.Users;
import com.web.mavenproject6.service.LessonsService;
import com.web.mavenproject6.service.LessonsServiceImp;
import com.web.mavenproject6.service.UserServiceImp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author Aleks
 */
@Controller
public class MainController {

    @Autowired
    Environment env;

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    EntityManager em;

    @Autowired
    // @Qualifier("LessonsService")
    LessonsService lessonsService;

    /*@RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
     public ModelAndView defaultPage() {

     ModelAndView model = new ModelAndView();
     model.addObject("title", "Spring Security Login Form - Database Authentication");
     model.addObject("message", "This is default page!");
     model.setViewName("jsp/hello");
     return model;

     }*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView Test() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome to SiroccoProject");
        model.addObject("message", "The desert wind has a name...");
        model.setViewName("jsp/hello");
        return model;

    }

    @ResponseBody
    @RequestMapping(value = "/a**", method = RequestMethod.GET)
    public String Tes(@RequestParam(value = "j") String jso) throws JSONException {
        JSONObject json = new JSONObject(jso);
        JSONArray js = new JSONArray(jso);
        String[] str = new String[js.length()];
        for (int i = 0; i < js.length(); i++) {
             str[i] = js.getJSONObject(i).getString("lessons");
            System.err.println(str[i]);
        }
        return "";
    }
        @ResponseBody
        @RequestMapping(value = "/q**", method = RequestMethod.GET)
        public String TestQ
        (@RequestParam(value = "jsondata")
        String jsondata) throws JSONException {
            JSONObject json = new JSONObject(jsondata);
            String str = json.getString("lessonId");
            if (str.equals("all")) {
                List<Lessons> lst;
                lst = (List<Lessons>) lessonsService.getLesson();
                JSONArray jarr = new JSONArray();
                jarr.put(lst);
                /*for (Lessons lst1 : lst) {
                 jarr.put(lst1);
                 }*/

                return lst.toString();
            } else {
                Lessons les = new Lessons();
                Long id = Long.parseLong(str);
                try {
                    les = (Lessons) lessonsService.getLesson(id);
                    return les.toString();
                } catch (NullPointerException ex) {
                    return "null";
                }
            }
            /*String str2 =json.getString("type");
             System.err.println("\nTry\n");
             System.err.println("\n" + imgdata + "\n");
             System.err.println("\n" + str1 + "\n");
             System.err.println("\n" + str2 + "\n");
             System.err.println("\nCatch\n");*/
            /*ModelAndView model = new ModelAndView();
             model.addObject("title", "Spring Security Login Form - Database Authentication");
             model.addObject("message", "The desert wind has a name...");
             model.setViewName("jsp/hello");*/
       // return model;

            // return "Op";
        }

        @RequestMapping(value = "/admin**", method = RequestMethod.GET)
        public ModelAndView adminPage
        
            () {

        ModelAndView model = new ModelAndView();
            model.addObject("title", "Spring Security Login Form - Database Authentication");
            model.addObject("message", "This page is for ROLE_ADMIN only!");
            model.setViewName("jsp/admin");
            return model;

        }

        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public ModelAndView login
        (@RequestParam(value = "error", required = false)
        String error,
            @RequestParam(value = "logout", required = false) 
        String logout
        
            ) {

        for (Users u : userServiceImp.list()) {
                System.err.println(u.toString());
            }
            ModelAndView model = new ModelAndView();
            if (error != null) {
                model.addObject("error", "Invalid username and password!");
            }

            if (logout != null) {
                model.addObject("msg", "You've been logged out successfully.");
            }
            model.setViewName("thy/login");

            return model;

        }

        //for 403 access denied page
        @RequestMapping(value = "/403", method = RequestMethod.GET)
        public ModelAndView accesssDenied
        
            () {

        ModelAndView model = new ModelAndView();

            //check if user is login
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth instanceof AnonymousAuthenticationToken)) {
                UserDetails userDetail = (UserDetails) auth.getPrincipal();
                model.addObject("username", userDetail.getUsername());
            }

            model.setViewName("jsp/403");
            return model;

        }

        @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Data integrity violation")
        public ModelAndView handleError404
        (HttpServletRequest request, Exception e
        
            ) {
        ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            //mav.addObject("errorcode", "404");
            mav.setViewName("jsp/403");
            return mav;
        }

    }
