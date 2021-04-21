package edu.utn.Parcial.Service;

import edu.utn.Parcial.Domain.Manager;
import edu.utn.Parcial.Domain.Person;
import edu.utn.Parcial.Domain.Player;
import edu.utn.Parcial.Exception.AlreadyExistException;
import edu.utn.Parcial.Exception.NotFoundException;
import edu.utn.Parcial.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void addOrRefreshPlayerByManager(Integer idManager, Integer idPlayer) {
        Person managerOptional = this.getById(idManager);
        if(managerOptional != null){
            Manager manager = (Manager)managerOptional;
            Optional<Player> player = manager.findPlayer(idPlayer);
            if(player != null){
                Player player1 = player.get();
                manager.refreshWeight(player1.getCurrency().getAmount());
                manager.refreshTotalAmount(player1.getCurrency().getAmount(),player1.getCurrency().getCurrency());
                this.personRepository.save(manager);
            }else{
                throw new NotFoundException("Player not found by the manager");
            }
        }else{
            throw new NotFoundException("Manager cannot exist");
        }

    }

    public void refreshPerson(Person friend) {
        this.personRepository.save(friend);
    }

    //endregion


}
