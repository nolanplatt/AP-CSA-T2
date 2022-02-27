package com.nighthawk.csa;

import com.nighthawk.csa.data.SQL.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProfileController {
    @GetMapping("/player/{id}")
    public String ProfileView(@PathVariable("id") long id, Model model) {
        model.addAttribute("id", id);
        return "profile";
    }
}
