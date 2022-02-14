package com.nighthawk.csa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoogleSearchController {
    @GetMapping("/googleSearch")
    public String greeting(@RequestParam(name= "UserInput", required=false, defaultValue="...") String UserInputJava, Model model) {
        return "googleSearch";
    }
}
