package com.nighthawk.csa.data.API;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Controller
public class APIController {

    // GET request, no parameters
    @GetMapping("/sportsnews")
    public String News(Model model) throws IOException, InterruptedException, ParseException {
        //api setup:
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://livescore6.p.rapidapi.com/news/v2/list-by-sport?category=2021020913321150030&page=1"))
                .header("x-rapidapi-host", "livescore6.p.rapidapi.com")
                .header("x-rapidapi-key", "00ccce1983msh870532702332d54p113f94jsn9fd7d405018d")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());

        //alternative #2: convert response.body() to JSON object
        Object obj = new JSONParser().parse(response.body());
        JSONObject jo = (JSONObject) obj;

//        System.out.println(jo.get("data"));
        model.addAttribute("data", jo.get("data"));

        return "data/list-by-sport";
    }


    @GetMapping("/soccerNews")
    public String soccer(Model model) throws IOException, InterruptedException, ParseException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://livescore6.p.rapidapi.com/matches/v2/list-live?Category=soccer%22"))
                        .header("x-rapidapi-host", "livescore6.p.rapidapi.com")
                        .header("x-rapidapi-key", "00ccce1983msh870532702332d54p113f94jsn9fd7d405018d")
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        //alternative #2: convert response.body() to JSON object
        Object obj = new JSONParser().parse(response.body());
        JSONObject jo = (JSONObject) obj;

//        System.out.println(jo.get("data"));
        model.addAttribute("data", jo.get("data"));

        return "data/list-by-sport";
    }





}