package edu.utn.Parcial.Service;

import edu.utn.Parcial.Domain.Person;
import edu.utn.Parcial.Exception.AlreadyExistException;
import edu.utn.Parcial.Exception.NotFoundException;
import edu.utn.Parcial.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    //region Properties
    private PersonRepository personRepository;
    //endregion

    //region Constructor
    @Autowired
    public  PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    //endregion

    //region Request
    public List<Person> getAll() {
        return this.personRepository.findAll();
    }

    public Person getById(Integer id) {
        if (this.personRepository.existsById(id)) {
            throw new NotFoundException("User cannot exist");
        } else {
            return this.personRepository.findById(id).orElseThrow(() -> new NotFoundException("User cannot find"));
        }
    }

    public void addPerson(Person person) {
        if(this.personRepository.existsById(person.getIdPerson())){
            throw new AlreadyExistException("User already exist.");
        }else {
            this.personRepository.save(person);
        }
    }

    public void deletePerson(Person person) {
        if(this.personRepository.existsById(person.getIdPerson())) {
            throw new NotFoundException("User cannot exist");
        }
        else {
            this.personRepository.delete(person);
        }
    }

    //endregion


}
