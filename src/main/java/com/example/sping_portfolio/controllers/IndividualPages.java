package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.lang.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.database.*;

@Controller
public class IndividualPages {

    FileInputStream serviceAccount = new FileInputStream("serviceAccount.json");
    FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://nolan-4b453.firebaseio.com/")
            .build();

    public IndividualPages() throws IOException {
    }


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
            array[1] = resultSeq;
            //E
            String segment = "11";
            String oldSeq = "1100000111000";
            int newIndex = oldSeq.indexOf(segment);
            String newSeq = oldSeq.substring(0, newIndex);
            newSeq += oldSeq.substring(newIndex + segment.length());
            array[2] = newSeq;
            //F
            array[3] = String.valueOf((Math.sqrt(a * a + b * b)));
        }
        // Varnit Gupta
        else if (name.equals("VGupta")) {
            //A
            LightSequence gradShow = new LightSequence("0101 0101 0101");
            //B
            gradShow.display();
            //C
            gradShow.changeSequence("0011 0011 0011");
            //D
            String resultSeq = gradShow.insertSegment("1111 1111", 4);
            array[1] = resultSeq;
            //E
            String segment = "11";
            String oldSeq = "1100000111000";
            int newIndex = oldSeq.indexOf(segment);
            String newSeq = oldSeq.substring(0, newIndex);
            newSeq += oldSeq.substring(newIndex + segment.length());
            array[2] = newSeq;
            //F
            array[3] = String.valueOf((Math.sqrt(a * a + b * b)));
        }
        // Aman Jain
        else if (name.equals("AJain")) {
            //A)
            LightSequence gradShow = new LightSequence("0101 0101 0101");
            //B)
            gradShow.display();
            //C)
            gradShow.changeSequence("0011 0011 0011");
            //D)
            String resultSeq = gradShow.insertSegment("1111 1111", 4);
            array[1] = resultSeq;
            //E)
            String segment = "101";
            String oldSeq = "0010 1001 1011";
            int removeSubstringIndex = oldSeq.indexOf(segment);
            String newSeq = oldSeq.substring(0,removeSubstringIndex) + oldSeq.substring(removeSubstringIndex + segment.length());
            array[2] = newSeq;
            //F)
            Double distance = Math.sqrt(a*a+b*b);
            System.out.println(distance);
            array[3] = String.valueOf(distance);

        }
        // Akshay Rohatgi
        else if (name.equals("ARohatgi")) {
            //A
            LightSequence gradShow = new LightSequence("0101 0101 0101");
            //B
            gradShow.display();
            //C
            gradShow.changeSequence("0011 0011 0011");
            //D
            String resultSeq = gradShow.insertSegment("1111 1111", 4);
            array[1] = resultSeq;
            //E
            String removeSegmentString = "110";
            String oldSeq = "110101001";
            String newSeq = oldSeq.replaceFirst(removeSegmentString, "");
            array[2] = newSeq;
            //F
            array[3] = String.valueOf(Math.sqrt(a*a + b*b));
        }
        // Ashwin Babu
        else if (name.equals("ABabu")) {

        }
        //A
        return array;
    }
    @GetMapping("/groupMembers")
    public String loadGroupMembers() {
        return "GroupMembers";
    }

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
    public String[] getFRQ(@RequestParam(name = "name", required = false, defaultValue = "null") String name,
                         @RequestParam(name = "frqWeek", required = false, defaultValue = "2") int unit) throws IOException {

        Path current = Paths.get("src/main/resources/static/frqs/Unit" + unit + "/" + name + ".txt");
        String content = Files.readString(current);
        String[] array = getFRQAnswers(name, content);
        return array;
    }
    @GetMapping("/GetOrder")
    public String loadGetOrder() {
        return "GetOrder";
    }

    @GetMapping("/api/getOrder")
    @ResponseBody
    public String getFRQ(@RequestParam(name = "orderId", required = false, defaultValue = "null") String orderId) throws IOException {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("order" + orderId);
        String[] reference = {""};
        ValueEventListener valueEventListener = ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                reference[0] += (dataSnapshot.getValue(String.class)) + ",";
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }

        });
        return reference[0];
    }
}




