package com.nighthawk.csa.archTPT;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// UserInputJava.equals("...")
// model.addAttribute("question", "Please type 3");
// return "archUnit4a";

@Controller
public class ArchUnit4a {

    @GetMapping("archUnit4a")
    public String greeting(@RequestParam(name= "UserInput", required=false, defaultValue="...") String UserInputJava, Model model) {

        // Return all model attributes to html
        return "archTPT/archUnit4a";
    }
}