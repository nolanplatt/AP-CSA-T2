package com.nighthawk.csa;

import com.nighthawk.csa.starters.ImageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AboutArchController {

    @GetMapping("/aboutArch")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String aboutArch() {
        return "aboutArch";
    }

    @GetMapping("/aboutArch/drawArch")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String drawArch() {
        return "drawArch";
    }
}
