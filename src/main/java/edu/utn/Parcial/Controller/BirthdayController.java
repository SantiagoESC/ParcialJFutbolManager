package edu.utn.Parcial.Controller;

import edu.utn.Parcial.Domain.Birthday;

import edu.utn.Parcial.Domain.Person;
import edu.utn.Parcial.Domain.PersonType;
import edu.utn.Parcial.Service.BirthdayService;
import edu.utn.Parcial.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/birthday")
public class BirthdayController {

    //region properties
    private BirthdayService birthdayService;
    private PersonService  personService;
    //endregion

    //region Constructor
    @Autowired
    public BirthdayController(BirthdayService birthdayService,PersonService  personService ){
        this.birthdayService = birthdayService;
        this.personService = personService;
    }
    //endregion

    //region REQUEST
    @GetMapping("/{id}")
    public Birthday getById(@PathVariable("id") Integer id){
        return this.birthdayService.getById(id);
    }

    @GetMapping("/")
    public List<Birthday> getAll(){
        return  this.birthdayService.getAll();
    }

    @PostMapping("/{idBirthday}/guest/{idGuest}")
    public void addFriend(@PathVariable("idBirthday") Integer idBirthday, @PathVariable("idGuest") Integer idGuest){

        Person friend = this.personService.getById(idGuest);
        Birthday birthday = this.birthdayService.getById(idBirthday);
        if(birthday.getGuestsList().size() > 10){
            throw new RuntimeException("Max Friend reached");
        }
        if(friend.PersonType().equals(PersonType.FRIEND)){
            friend.getBirthdayList().add(birthday);
            birthday.getGuestsList().add(friend);
            this.birthdayService.refreshBirthday(birthday);
            this.personService.refreshPerson(friend);
        }
    }

    //endregion
}
