package edu.utn.Parcial.Controller;

import edu.utn.Parcial.Domain.PaginationResponse;
import edu.utn.Parcial.Domain.Person;
import edu.utn.Parcial.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public List<Person> getAll(@RequestParam(value = "size", defaultValue = "20") Integer size, //elementos por paginas
                               @RequestParam(value="page", defaultValue="0") Integer page)  { //pagina en la que estas parado
        return personService.getAll(page, size);
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
