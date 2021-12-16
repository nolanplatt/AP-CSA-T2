package com.nighthawk.csa.data.ChrisCB;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileReader;

@Controller
public class chrisCB {

    @GetMapping("/Cfrq")
    public String cb(@RequestParam(name = "week", required = false, defaultValue = "") Model model) {
        String key = "";

        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser
                    .parse(new FileReader("src/main/java/com/nighthawk/csa/data/ChrisCB/ChrisFRQ.json"));

            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;

            //Reading the array
            JSONArray CB = (JSONArray)jsonObject.get("CB");

            //Printing all the values

            // All CB frqs
            for(Object frq : CB)
            {
                System.out.println("\t"+frq.toString());
            }

//            String week = object.getString("week");


            model.addAttribute("CB", CB);
//            model.addAttribute("week", week);



        } catch(Exception fe)
        {
            fe.printStackTrace();
        }
        return "data/chrisCB";
    }
}




//        ArrayList<FRQ> frqs = new ArrayList<>();
//
//        JSONParser parser = new JSONParser();
//        Object obj = parser.parse(new FileReader("src/main/java/com/nighthawk/csa/data/CB/ChrisFRQ.json"));
//        JSONObject jsonObject = (JSONObject) obj;
//
//        for (Object o : jsonObject.keySet()) {
//            String key = (String) o;
//
//            // Song song = new Song();
//            JSONObject FRQobj = (JSONObject) jsonObject.get(key);
//            frqs.add(new FRQ((String) FRQobj.get("name"), (String) FRQobj.get("gist"), (String) FRQobj.get("output")));
//        }
//
//        System.out.println(frqs.get(0));
//        model.addAttribute("FRQlist", frqs);
//        model.addAttribute("frq",frq);