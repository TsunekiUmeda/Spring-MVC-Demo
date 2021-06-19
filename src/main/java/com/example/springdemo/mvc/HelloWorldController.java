package com.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

    // need controller method to show the initial HTML
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //new a controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo! " + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName,
            Model model) {

//        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Hey My Friend from v3! " + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }
}
