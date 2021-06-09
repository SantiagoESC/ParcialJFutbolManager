package edu.utn.Parcial.Service;

import edu.utn.Parcial.Domain.*;
import edu.utn.Parcial.Domain.projections.PersonProjection;
import edu.utn.Parcial.Exception.AlreadyExistException;
import edu.utn.Parcial.Exception.NotFoundException;
import edu.utn.Parcial.Repository.PersonRepository;
import edu.utn.Parcial.Utils.EntityURLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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

    public List<Person> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Person> personaPage = personRepository.findAll(pageable);
        return  personaPage.getContent();
    }

    public Person getById(Integer id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void addPerson(Person person) {
        if(this.personRepository.existsById(person.getIdPerson())){
            throw new AlreadyExistException("User already exist.");
        }else {

            this.personRepository.save(person);
        }
    }

    public PostResponse add(Person person2) {
        Person person= personRepository.save(person2);
        return PostResponse
                .builder()
                .status(HttpStatus.CREATED)
                .url(EntityURLBuilder.buildUrl("Person", person.getIdPerson()))
                .build();
    }

    public PersonProjection findByNombre(String name) {
        return personRepository.findByName(name);
    }

    public PaginationResponse<Person> getAllSort(Integer size, Integer page, List<Sort.Order> orders) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orders) );
        Page<Person> personaPage = personRepository.findAll(pageable);
        return new PaginationResponse<>(personaPage.getContent(),
                personaPage.getTotalPages(),
                personaPage.getTotalElements());
    }

    public PaginationResponse<Person> getAllSpec(Specification<Person> pesonSpecification, Pageable pageable) {
        Page<Person>personaPage = personRepository.findAll(pesonSpecification, pageable);
        return new PaginationResponse<>(personaPage.getContent(),
                personaPage.getTotalPages(),
                personaPage.getTotalElements());
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
                //manager.refreshWeight(player1.getCurrency().getAmount());
                //manager.refreshTotalAmount(player1.getCurrency().getAmount(),player1.getCurrency().getCurrency());
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
