package com.nighthawk.csa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlayersController {
    @GetMapping("/players/list")
    public String ProfileView() {
        return "players";
    }

    @GetMapping("/player/{id}")
    public String ProfileView(@PathVariable("id") long id, Model model) {
        model.addAttribute("id", id);
        return "profile";
    }

}
