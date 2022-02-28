package com.nighthawk.csa;

import com.nighthawk.csa.data.SQL.Person;
import com.nighthawk.csa.data.SQL.PersonSqlRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class PersonSqlMvcController implements WebMvcConfigurer {

    // Autowired enables Control to connect HTML and POJO Object to Database easily for CRUD
    @Autowired
    private PersonSqlRepository repository;

    @GetMapping("/data/personAuth")
    public String getPersonAuth() {
        return "data/personAuth";
    }

    @GetMapping("/personAuthAPI")
    public String getPersonAuthAPI(@RequestParam(name = "password") String password, HttpServletResponse httpResponse) throws IOException {
        if(password.equals("LHopital")) {
            System.out.println("Admin PW Matches");
            return "redirect:data/person";
        } else {
            System.out.println("!!!false");
            return "data/personAuth";
        }
    }
    @GetMapping("/data/person")
    public String person(Model model) {
        List<Person> list = repository.listAll();
        model.addAttribute("list", list);
        return "data/person";
    }

    @GetMapping("/data/personsearch_get")
    public String person() {
        return "data/personsearch_get";
    }

    /*
    The personSearch API looks across database for partial match to term (k,v) passed by RequestEntity body
     */
    @RequestMapping(value = "/api/personsearch_get", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> personSearch(RequestEntity<Object> request) {

        // extract term from RequestEntity
        JSONObject json = new JSONObject((Map) Objects.requireNonNull(request.getBody()));
        String term = (String) json.get("term");

        // custom JPA query to filter on term
        List<Person> list = repository.listLikeNative(term);

        // return resulting list and status, error checking should be added
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /*  The HTML template Forms and PersonForm attributes are bound
        @return - template for person form
        @param - Person Class
    */
    @GetMapping("/data/personcreate")
    public String personAdd(Person person) {
        return "data/personcreate";
    }

    /* Gathers the attributes filled out in the form, tests for and retrieves validation error
    @param - Person object with @Valid
    @param - BindingResult object
     */
    @PostMapping("/data/personcreate")
    public String personSave(@Valid Person person, BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        if (bindingResult.hasErrors()) {
            return "data/personcreate";
        }
        repository.save(person);
        // Redirect to next step
        return "redirect:/data/person";
    }

    @GetMapping("/data/personupdate/{id}")
    public String personUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", repository.get(id));
        return "data/personupdate";
    }

    @PostMapping("/data/personupdate")
    public String personUpdateSave(@Valid Person person, BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        if (bindingResult.hasErrors()) {
            return "data/personupdate";
        }
        repository.save(person);
        // Redirect to next step
        return "redirect:/data/person";
    }

    @GetMapping("/data/persondelete/{id}")
    public String personDelete(@PathVariable("id") long id) {
        repository.delete(id);
        return "redirect:/data/person";
    }

    /*
    #### RESTful API section ####
    Resource: https://spring.io/guides/gs/rest-service/
    */

    /*
    GET List of People
     */
    @RequestMapping(value = "/api/people/get")
    public ResponseEntity<List<Person>> getPeople() {
        return new ResponseEntity<>(repository.listAll(), HttpStatus.OK);
    }

    /*
    GET individual Person using ID
     */
    @RequestMapping(value = "/api/person/get/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable long id) {
        return new ResponseEntity<>(repository.get(id), HttpStatus.OK);
    }

    /*
    DELETE individual Person using ID
     */
    @RequestMapping(value = "/api/person/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePerson(@PathVariable long id) {
        repository.delete(id);
        return new ResponseEntity<>("" + id + " deleted", HttpStatus.OK);
    }


    /*
    POST Aa record by Requesting Parameters from URI
     */
    @RequestMapping(value = "/api/person/post", method = RequestMethod.POST)
    public ResponseEntity<Object> postPerson(@RequestParam("email") String email,
                                             @RequestParam("phonenumber") String phonenumber,
                                             @RequestParam("experience") String experience,
                                             @RequestParam("recruited") Boolean recruited,
                                             @RequestParam("name") String name,
                                             @RequestParam("sport") String sport,
                                             @RequestParam("image") String image,
                                             @RequestParam("dob") String dobString) {
        Date dob;
        try {
            dob = new SimpleDateFormat("MM-dd-yyyy").parse(dobString);
        } catch (Exception e) {
            return new ResponseEntity<>(dobString + " error; try MM-dd-yyyy", HttpStatus.BAD_REQUEST);
        }
        // A person object WITHOUT ID will create a new record
        Person person = new Person(email, phonenumber, experience, recruited, name, sport, image, dob);
        repository.save(person);
        return new ResponseEntity<>(email + " is created successfully", HttpStatus.CREATED);
    }

}
