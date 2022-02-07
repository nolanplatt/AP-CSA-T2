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
import java.util.Random;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class MainController<array> {


    // 2014 Extra Credit FRQs

    // Question 1
    class WordScrambler {
        String recombine(String groupMember, String word1, String word2) {
            // Nolan Platt Code
            String combo = "";
            if (groupMember.equals("NPlatt")) {
                combo = (word1.substring(0, word1.length() / 2));

                combo += word2.substring(word2.length() / 2);
                return combo;
            }
            return combo;
        }

        String[] mixedWords(String groupMember, String[] words) {
            // Nolan Platt Code
            String[] combo = new String[words.length];
            if (groupMember.equals("NPlatt")) {
                for (int i = 0; i < combo.length; i++) {
                    combo[i] = recombine("NPlatt", words[i], words[1 + i]);
                    combo[1 + i] = recombine("NPlatt", words[1 + i], words[i]);
                }
                return combo;
            }
            return combo;
        }
    }

    // Question 2
    class Mountain {
        int getPeakIndex(String groupMember, int[] array) {
            // Nolan Platt Code
            if (groupMember.equals("NPlatt")) {
                for (int i = 1; i <= array.length; i++) {
                    if (array[i] > array[i + 1] && array[i - 1] < array[i]) {
                        return i;
                    }
                    return 0;

                }
            }
            return 0;
        }

        boolean isIncreasing(int[] array, int stop) {
            /* implementation not shown

             */
            return true;
        }

        boolean isDecreasing(int[] array, int stop) {
            /* implementation not shown

             */
            return false;
        }

        boolean isMountain(String groupMember, int[] array) {
            // Nolan Platt Code
            if (groupMember.equals("NPlatt")) {
                int currentPeak = getPeakIndex("NPlatt", array);

                return (currentPeak != -1) && isIncreasing(array, currentPeak) &&
                        isDecreasing(array, currentPeak);
            }
            return true;
        }
    }

    // Question 3
    class TemperatureGrid {
        double computeTemp(String groupMember, int row, int col) {

            // Matrix Declaration from FRQ
            Double[][] temps = new Double[6][5];

            temps[0][0] = 95.5;

            // [row][column]

            // Column 0
            temps[0][0] = 95.5;
            temps[1][0] = 0.0;
            temps[2][0] = 0.0;
            temps[3][0] = 0.0;
            temps[4][0] = 0.0;
            // Column 1
            temps[0][1] = 100.0;
            temps[1][1] = 50.0;
            temps[2][1] = 40.0;
            temps[3][1] = 20.0;
            temps[4][1] = 0.0;
            // Column 2
            temps[0][2] = 100.0;
            temps[1][2] = 50.0;
            temps[2][2] = 40.0;
            temps[3][2] = 20.0;
            temps[4][2] = 0.0;
            // Column 3
            temps[0][3] = 100.0;
            temps[1][3] = 50.0;
            temps[2][3] = 40.0;
            temps[3][3] = 20.0;
            temps[4][3] = 0.0;
            // Column 4
            temps[0][4] = 110.3;
            temps[1][4] = 0.0;
            temps[2][4] = 0.0;
            temps[3][4] = 0.0;
            temps[4][4] = 0.0;

            // Nolan Platt Code
            if (groupMember.equals("NPlatt")) {
                if (row == 0 || row == temps.length - 1 || col == 0 || col == temps[0].length - 1) {
                    return temps[row][col];
                } else {
                    return (temps[row - 1][col] + temps[row + 1][col] + temps[row][col - 1] + temps[row][col + 1]) / 4.0;
                }

            }
            return 0.0;
        }

        boolean updateAllTemps(String groupMember, double tolerance) {
            Double[][] temps = new Double[6][5];

            temps[0][0] = 95.5;

            // [row][column]

            // Column 0
            temps[0][0] = 95.5;
            temps[1][0] = 0.0;
            temps[2][0] = 0.0;
            temps[3][0] = 0.0;
            temps[4][0] = 0.0;
            // Column 1
            temps[0][1] = 100.0;
            temps[1][1] = 50.0;
            temps[2][1] = 40.0;
            temps[3][1] = 20.0;
            temps[4][1] = 0.0;
            // Column 2
            temps[0][2] = 100.0;
            temps[1][2] = 50.0;
            temps[2][2] = 40.0;
            temps[3][2] = 20.0;
            temps[4][2] = 0.0;
            // Column 3
            temps[0][3] = 100.0;
            temps[1][3] = 50.0;
            temps[2][3] = 40.0;
            temps[3][3] = 20.0;
            temps[4][3] = 0.0;
            // Column 4
            temps[0][4] = 110.3;
            temps[1][4] = 0.0;
            temps[2][4] = 0.0;
            temps[3][4] = 0.0;
            temps[4][4] = 0.0;
            // Nolan Platt Code
            if (groupMember.equals("NPlatt")) {
                double[][] newTemps = new
                        double[temps.length][temps[0].length];
                boolean tolerant = true;
                for (int i = 0; i < temps.length; i++) {
                    for (int j = 0; j < temps[0].length; j++) {
                        newTemps[i][j] = computeTemp("NPlatt", i, j);

                        if (tolerance < temps[i][j] - newTemps[i][j]) {
                            tolerant = false;
                        }
                    }
                }
                for (int k = 0; k < temps.length; k++) {
                    for (int l = 0; l < temps[0].length; l++) {
                        temps[l][k] = newTemps[l][k];
                    }
                }
                return tolerant;

            }
            return true;
        }

        // Question 4
        class ScoreInfo {
            int score;
            int numStudents;

            public ScoreInfo(int aScore) {
                score = aScore;
                numStudents = 1;
            }

            public void increment() {
                numStudents++;
            }

            public int getScore() {
                return score;
            }

            public int getFrequency() {
                return numStudents;
            }

            boolean record(String groupMember, int score) {
                // Nolan Platt Code
                ArrayList<ScoreInfo> scoreList = new ArrayList<ScoreInfo>();
                scoreList.add(0, new ScoreInfo(95));
                scoreList.add(1, new ScoreInfo(63));
                scoreList.add(2, new ScoreInfo(75));
                scoreList.add(3, new ScoreInfo(87));
                scoreList.add(3, new ScoreInfo(34));
                scoreList.add(3, new ScoreInfo(56));

                if (groupMember.equals("NPlatt")) {
                    for (int i = 0; i < scoreList.size(); i++) {
                        if (scoreList.get(i).getScore() > score) {
                            scoreList.add(i, new ScoreInfo(score));
                            return true;
                        } else if (score == scoreList.get(i).getScore()) {
                            scoreList.get(i).increment();
                            return false;
                        }
                    }
                    ScoreInfo si = new ScoreInfo(score);
                    scoreList.add(si);
                    return true;
                }
                return false;
            }

            void recordScores(String groupMember, int[] stuScores) {
                // Nolan Platt Code
                if (groupMember.equals("NPlatt")) {
                    for (int i = 0; i < stuScores.length; i++) {
                        record("NPlatt", stuScores[i]);
                    }
                }
            }

        }
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

    public String[] getFRQAnswers(int week, String name, String content) {

        String[] array = new String[50];
        array[0] = content;

        if (week == 2) {


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

            if (name.equals("ARohatgi")) {
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
                array[3] = String.valueOf(Math.sqrt(a * a + b * b));
            }


        } else if (week == 3) {

            // Nolan Platt
            if (name.equals("NPlatt")) {

                // A
                boolean rsvp = true;
                if (rsvp) {
                    array[1] = "PART A: Attending";
                } else if (!rsvp) {
                    array[1] = "PART A: Not attending";
                }

                // B
                int selection = 2;
                String foodItem = "";
                String[] possibleFoods = {"Beef", "Chicken.", "Pasta.", "Fish."};
                int ind = selection--;
                if (ind > 3) {
                    ind = 3;
                }
                foodItem = possibleFoods[ind];
                array[2] = "PART B: " + foodItem;

                // C
                boolean bool = true;
                String newFoodItem = "";
                String sentence;
                if (bool) {
                    String[] newPossibleFoods = {"Beef", "Chicken.", "Pasta.", "Fish."};
                    sentence = "Thanks for attending. You will be served ";
                    int newInd = selection--;
                    if (newInd > 3) {
                        newInd = 3;
                    }
                    newFoodItem = newPossibleFoods[newInd];
                    array[3] = "PART C: " + newFoodItem;
                } else if (!bool) {
                    sentence = "Sorry you can't make it.";
                    array[3] = "PART C: " + sentence;
                }

                // D
                String option1 = "hh";
                String option2 = "dd";
                boolean check = option1.equals(option2);
                array[4] = "PART D: " + Boolean.toString(check);
            }

            if (name.equals("ARohatgi")) {
                //A
                boolean rsvp = true;
                if (rsvp) {
                    System.out.println("attending");
                    array[1] = "attending";
                } else {
                    System.out.println("attending");
                    array[1] = "not attending";
                }

                //B
                int selection = 1;
                if (selection == 1) {
                    System.out.println("beef");
                    array[2] = "beef";
                } else if (selection == 2) {
                    System.out.println("chicken");
                    array[2] = "chicken";
                } else if (selection == 3) {
                    System.out.println("pasta");
                    array[2] = "pasta";
                } else {
                    System.out.println("fish");
                    array[2] = "fish";
                }

                //C
                String option1 = "";
                String option2 = "";
                if (!rsvp) {
                    option1 = "Sorry you can't make it.";
                    array[3] = "Sorry you can't make it.";
                } else if (rsvp && selection == 1) {
                    option1 = "Thanks for attending. You will be served beef.";
                    array[3] = "Sorry you can't make it.";
                }

                //D
                if (option1 == option2) {
                    System.out.println("true");
                    array[4] = "true";
                } else {
                    System.out.println("false");
                    array[4] = "false";
                }

            }

        } else if (week == 4) {
            // Nolan Platt FRQ handling
            if (name.equals("NPlatt")) {
                // Question 1

                // Question 2
                // Question 3
                // Question 4
            }
            // Akshay Rohatgi FRQ handling
            if (name.equals("ARohatgi")) {

                // Question 1

                // Question 2


            }
        } else if (week == 0) { // 0-> 2014 AP Extra Credit FRQs
            // Nolan Platt FRQ handling
            if (name.equals("NPlatt")) {
                // Question 1

                // Question 2
                // Question 3
                // Question 4
            }
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

    // Unit 2 CUSTOM Nolan Platt
    // Unit 3 CUSTOM
    @GetMapping("/frqCustomAPIUnit3Nolan")
    @ResponseBody
    public String[] getFrqCustomAPIUnit3Nolan(@RequestParam(name = "rsvp", required = false, defaultValue = "true") boolean rsvp,
                                              @RequestParam(name = "selection", required = false, defaultValue = "1") int selection,
                                              @RequestParam(name = "option1", required = false, defaultValue = "foo") String option1,
                                              @RequestParam(name = "option2", required = false, defaultValue = "bar") String option2) throws IOException {


        String[] array = new String[5];
        // A
        if (rsvp) {
            array[0] = "PART A: Attending";
        } else if (!rsvp) {
            array[0] = "PART A: Not attending";
        }

        // B
        String foodItem = "";
        String[] possibleFoods = {"Beef", "Chicken.", "Pasta.", "Fish."};
        int ind = selection--;
        if (ind > 3) {
            ind = 3;
        }
        foodItem = possibleFoods[ind];
        array[1] = "PART B: " + foodItem;

        // C
        boolean bool = true;
        String newFoodItem = "";
        String sentence;
        if (bool) {
            String[] newPossibleFoods = {"Beef", "Chicken.", "Pasta.", "Fish."};
            sentence = "Thanks for attending. You will be served ";
            int newInd = selection--;
            if (newInd > 3) {
                newInd = 3;
            }
            newFoodItem = newPossibleFoods[newInd];
            array[2] = "PART C: " + newFoodItem;
        } else if (!bool) {
            sentence = "Sorry you can't make it.";
            array[2] = "PART C: " + sentence;
        }

        // D
        boolean check = option1.equals(option2);
        array[3] = "PART D: " + Boolean.toString(check);

        return array;
    }

    @GetMapping("/frqCustomAPIUnit2Nolan")
    @ResponseBody
    public String[] getFrqCustomAPIUnit2Nolan(@RequestParam(name = "initial", required = false, defaultValue = "0101 0101 0101") String initial,
                                              @RequestParam(name = "changed", required = false, defaultValue = "0011 0011 0011") String changed,
                                              @RequestParam(name = "inserted", required = false, defaultValue = "1111 1111") String inserted,
                                              @RequestParam(name = "aVal", required = false, defaultValue = "3") int aVal,
                                              @RequestParam(name = "bVal", required = false, defaultValue = "3") int bVal) throws IOException {


        String[] array = new String[3];
        //A
        LightSequence gradShow = new LightSequence(initial);
        //B
        gradShow.display();
        //C
        gradShow.changeSequence(changed);
        //D
        String resultSeq = gradShow.insertSegment(inserted, 4);
        array[0] = "Result Sequence: " + resultSeq;
        //E
        String segment = "11";
        String oldSeq = "1100000111000";
        int newIndex = oldSeq.indexOf(segment);
        String newSeq = oldSeq.substring(0, newIndex);
        newSeq += oldSeq.substring(newIndex + segment.length());
        array[1] = "New Sequence: " + newSeq;
        //F
        array[2] = "Distance Sqrt Result: " + String.valueOf((Math.sqrt(aVal * aVal + bVal * bVal)));
        return array;
    }

    // Unit 5 CUSTOM
    @GetMapping("/frqCustomAPIUnit5Nolan")
    @ResponseBody
    public String[] getfrqCustomAPIUnit5Nolan(@RequestParam(name = "hostname", required = false, defaultValue = "HN") String hostName,
                                              @RequestParam(name = "address", required = false, defaultValue = "123 John Mortensen Boulevard") String address,
                                              @RequestParam(name = "invitee", required = false, defaultValue = "Nolan") String invitee,
                                              @RequestParam(name = "prefix", required = false, defaultValue = "PREFIX") String prefix,
                                              @RequestParam(name = "amount", required = false, defaultValue = "1") int amount) throws IOException {

        String[] array = new String[6];

        // Question 1
        array[0] = hostName;
        array[1] = address;
        array[2] = "Dear " + invitee + ", please attend my event at " + address + ". See you then, " + hostName + ".";;
        // Question 2
        String combined = "";
        Random r = new Random();
        for (int i = 0; i < amount; i++) {
            combined += (prefix + "." +  r.nextInt(10));
        }
        array[3] = combined;

        return array;
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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/bmi")
    public String bmi() {
        return "bmi";
    }

    // FRQ API
    @GetMapping("/frqAPI")
    @ResponseBody
    public String[] getFRQ(@RequestParam(name = "name", required = false, defaultValue = "null") String name,
                           @RequestParam(name = "frqUnit", required = false, defaultValue = "2") int unit) throws IOException {


        Path current = Paths.get("src/main/resources/static/frqs/Unit" + unit + "/" + name + ".txt");
        String content = Files.readString(current);
        System.out.println("unit-> " + unit);
        String[] array = getFRQAnswers(unit, name, content);
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

    @GetMapping("/individual/AHuang/RapidAPI")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getAHuangRapidAPI() {
        return "archTPT/RapidAPI.html";
    }

    @GetMapping("/individual/AHuang/ArchUnit4a")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getAHuangUnit4a() {
        return "archTPT/archUnit4a.html";
    }

    @GetMapping("/individual/AHuang/ArchUnit4b")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getAHuangUnit4b() {
        return "archTPT/archUnit4b.html";
    }

    @GetMapping("/individual/AHuang/ArchUnit5a")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getAHuangUnit5a() {
        return "archTPT/archUnit5a.html";
    }

    @GetMapping("/individual/AHuang/ArchUnit5b")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getAHuangUnit5b() {
        return "archTPT/archUnit5b.html";
    }


    @GetMapping("/individual/AHuang/aboutArch/drawArch")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getDrawArch() {
        return "drawArch";
    }

    // Akshay Rohatgi

    @GetMapping("/individual/ARohatgi")
    public String getARohatgi() {
        return "ARohatgi";
    }

    // Chris Rubin

    @GetMapping("/individual/CRubin")
    public String getCRUbin(Model model) {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser
                    .parse(new FileReader("src/main/java/com/nighthawk/csa/data/ChrisCB/ChrisFRQ.json"));

            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject) object;

            //Reading the array
            JSONArray CB = (JSONArray) jsonObject.get("CB");


            // All CB frqs
            for (Object frq : CB) {
                System.out.println("\t" + frq.toString());
            }

            model.addAttribute("CB", CB);

        } catch (Exception fe) {
            fe.printStackTrace();
        }
        return "CRubin";
    }

    // Unit 4a
    @GetMapping("/individual/CRubin/ChrisCB")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String getCRubinCB() {
        return "ChrisTPT/chrisCB";
    }
}