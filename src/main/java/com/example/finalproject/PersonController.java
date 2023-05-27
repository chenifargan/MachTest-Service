package com.example.finalproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
@CrossOrigin("10.0.2.2")
public class PersonController {

    private final PersonService customerService;

    public PersonController(PersonService personService) {
        this.customerService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable final Long id) {
        return ResponseEntity.ok(customerService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable final Long id) {
        return ResponseEntity.ok(customerService.delete(id));
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody final Person person) {
        return ResponseEntity.ok(customerService.save(person));
    }
    @PutMapping
    public ResponseEntity<?> match(@RequestBody MatchBoundary matchBoundary) {
        Person p1= matchBoundary.getP1();
        Person p2= matchBoundary.getP2();
        if(p1.getName()==null||p2.getName()==null){
            throw new PersonNameException("one of person  missing name");
        }
        if(p1.getLastname()==null||p2.getLastname()==null){
            throw new PersonLastNameException("one of person  missing  last name");
        }
        if(p1.getAge()<15|| p1.getAge()>120||p2.getAge()<15|| p2.getAge()>120){

            throw new PersonAgeException("person age between 15-120");

        }
        if(String.valueOf(p1.getId()).length()!=8|| String.valueOf(p2.getId()).length()!=8){
            throw new PersonAgeException("invalid id");
        }
        try {
            AstrologicalSign sing1= AstrologicalSign.valueOf(p1.getAstrologicalSign());
            AstrologicalSign sing2= AstrologicalSign.valueOf(p2.getAstrologicalSign());


        }catch (Exception ex){
            throw new PersonAstroException("invalid astro");
        }


        return ResponseEntity.ok(customerService.match(p1,p2));
    }

}
