package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class IndividualPages {
    @GetMapping("/individual/NPlatt")
    public String loadNPlatt() {
        return "NPlatt";
    }

    @GetMapping("/individual/ARohatgi")
    public String loadARohatgi() {
        return "ARohatgi";
    }

    @GetMapping("/individual/AJain")
    public String loadAJain() {
        return "AJain";
    }

    @GetMapping("/individual/ABabu")
    public String loadABabu() {
        return "ABabu";
    }

    @GetMapping("/individual/VGupta")
    public String loadVGupta() {
        return "VGupta";
    }

    @GetMapping("/frqAPI")
    @ResponseBody
    public String getFRQ(@RequestParam(name = "name", required = false, defaultValue = "null") String name,
                         @RequestParam(name = "frqWeek", required = false, defaultValue = "2") int unit) throws IOException {

        Path current = Paths.get("src/main/resources/static/frqs/Unit" + unit + "/" + name + ".txt");

        String content = Files.readString(current);
        return content;

    }
}


