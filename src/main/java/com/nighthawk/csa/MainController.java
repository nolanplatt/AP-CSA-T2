package com.nighthawk.csa;

import com.nighthawk.csa.starters.ImageInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class MainController {

    // Unit 2 FRQ Stuff

    class LightSequence {
        String seq;

        public LightSequence(String seq) {
            this.seq = seq;
        }

        public String insertSegment(String segment, int ind) {
            StringBuilder sb = new StringBuilder(segment);
            sb.insert(ind, segment);
            return sb.toString();
        }

        public void changeSequence(String seq) {
            this.seq = seq;
        }

        public void display() {
            System.out.println(seq);
        }

    }

    public String[] getFRQAnswers(String name, String content) {

        String[] array = new String[4];
        array[0] = content;
        int a = 3;
        int b = 4;

        // Begin FRQ Handling for Each Group Member

        // Nolan Platt
        if (name.equals("NPlatt")) {
            //A
            LightSequence gradShow = new LightSequence("0101 0101 0101");
            //B
            gradShow.display();
            //C
            gradShow.changeSequence("0011 0011 0011");
            //D
            String resultSeq = gradShow.insertSegment("1111 1111", 4);
            array[1] = "Result Sequence: " + resultSeq;
            //E
            String segment = "11";
            String oldSeq = "1100000111000";
            int newIndex = oldSeq.indexOf(segment);
            String newSeq = oldSeq.substring(0, newIndex);
            newSeq += oldSeq.substring(newIndex + segment.length());
            array[2] = "New Sequence: " + newSeq;
            //F
            array[3] = "Distance Sqrt Result: " + String.valueOf((Math.sqrt(a * a + b * b)));
        }
        return array;
    }

    @GetMapping("/aboutus")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String abtus() {
        return "starters/aboutus";
    }

    @GetMapping("/greet")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        // @RequestParam handles required and default values, name and data are class variables, data looking like JSON
        model.addAttribute("name", name);   // MODEL is passed to html
        return "starters/greet";                     // returns HTML VIEW (greeting)
    }

    @GetMapping("/image")
    public String image(Model model) {
        String web_server = "http://p1-coders.cf:5000/";
        List<ImageInfo> lii = new ArrayList<>();

        String file0 = "/images/picOfYeonjoon.png";
        lii.add(new ImageInfo(file0, web_server + file0, 12));
        lii.get(0).read_image();

        String file1 = "/images/ChrisAbout.png";
        lii.add(new ImageInfo(file1, web_server + file1, 2));
        lii.get(1).read_image();

        String file2 = "/images/EshaanAbout.jpg";
        lii.add(new ImageInfo(file2, web_server + file2, 7));
        lii.get(2).read_image();

        model.addAttribute("lii", lii);
        return "starters/image";
    }

    @GetMapping("/grayscale")
    public String image_grayscale(@RequestParam(name = "gray", required = false, defaultValue = "false") boolean gray, Model model) {
        String web_server = "http://p1-coders:5000/";
        List<ImageInfo> lii = new ArrayList<>();

        String file0 = "/images/picOfYeonjoon.png";
        lii.add(new ImageInfo(file0, web_server + file0, 12));
        String str = lii.get(0).grayscale();

        String file1 = "/images/ncs_logo.png";
        lii.add(new ImageInfo(file1, web_server + file1, 12));
        String str1 = lii.get(1).grayscale();


        model.addAttribute("str", str);
        model.addAttribute("str1", str1);
        model.addAttribute("file", gray);
        return "starters/image_grayscale";
    }

    @GetMapping("/binary")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String binary() {
        return "starters/binary";
    }

    @GetMapping("/deploy")
    public String deploy() {
        return "deploy";
    }

    @GetMapping("/journal")
    public String journal() {
        return "journal";
    }

    @GetMapping("/graph")
    public String graph() {
        return "graph";
    }

    // FRQ API
    @GetMapping("/frqAPI")
    @ResponseBody
    public String[] getFRQ(@RequestParam(name = "name", required = false, defaultValue = "null") String name,
                           @RequestParam(name = "frqUnit", required = false, defaultValue = "2") int unit) throws IOException {

        Path current = Paths.get("src/main/resources/static/frqs/Unit" + unit + "/" + name + ".txt");
        String content = Files.readString(current);
        String[] array = getFRQAnswers(name, content);
        return array;
    }

    // About Pages

    // Nolan Platt

    @GetMapping("/individual/NPlatt")
    public String getNPlatt() {
        return "NPlatt";
    }

    // Arch Huang

    @GetMapping("/individual/AHuang")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getAHuang() {
        return "AHuang";
    }

    @GetMapping("/individual/AHuang/aboutArch/drawArch")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getDrawArch() {
        return "drawArch";
    }

    @GetMapping("/individual/ARohatgi")
    public String getARohatgi() {
        return "ARohatgi";
    }

    // Chris Rubin

    @GetMapping("/individual/CRubin")
    public String getCRUbin(Model model) {
            JSONParser parser = new JSONParser();
            try
            {
                Object object = parser
                        .parse(new FileReader("src/main/java/com/nighthawk/csa/data/ChrisCB/ChrisFRQ.json"));

                //convert Object to JSONObject
                JSONObject jsonObject = (JSONObject)object;

                //Reading the array
                JSONArray CB = (JSONArray)jsonObject.get("CB");


                // All CB frqs
                for(Object frq : CB)
                {
                    System.out.println("\t"+frq.toString());
                }

                model.addAttribute("CB", CB);

            } catch(Exception fe)
            {
                fe.printStackTrace();
            }
        return "CRubin";
    }
}