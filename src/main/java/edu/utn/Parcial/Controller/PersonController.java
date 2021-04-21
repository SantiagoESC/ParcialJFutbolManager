package edu.utn.Parcial.Controller;

import edu.utn.Parcial.Domain.Manager;
import edu.utn.Parcial.Domain.Person;
import edu.utn.Parcial.Domain.PersonType;
import edu.utn.Parcial.Domain.Player;
import edu.utn.Parcial.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    /*
    POST /person
    GET /person
    GET /person/{id}
    DEL /person
    PUT /person/{id}/jugadores/{idJugador}
     */

    //region properties
    private PersonService  personService;
    //endregion

    //region Constructor
    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }
    //endregion

    //region GET
    @GetMapping("/")
    public List<Person> getAll(){
        return this.personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") Integer id){

        return this.personService.getById(id);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        this.personService.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Integer id){
        Person person = this.getById(id);
        if(person != null) {
            this.personService.deletePerson(person);
        }
    }

    @PutMapping("/{id}/player/{idPlayer}")
    public void refreshPlayerByManager(@PathVariable("id") Integer idManager, @PathVariable("idPlayer") Integer idPlayer){
        this.personService.addOrRefreshPlayerByManager(idManager,idPlayer);
    }


    //endregion


}
