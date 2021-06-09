package edu.utn.Parcial.Service;

import edu.utn.Parcial.Domain.Birthday;
import edu.utn.Parcial.Domain.Currency;
import edu.utn.Parcial.Domain.Person;
import edu.utn.Parcial.Domain.Player;
import edu.utn.Parcial.Domain.dto.BillDTO;
import edu.utn.Parcial.Exception.NotFoundException;
import edu.utn.Parcial.Repository.BirthdayRepository;
import edu.utn.Parcial.api.dolar.DolarClient;
import edu.utn.Parcial.api.dolar.DolarResponse;
import edu.utn.Parcial.api.euro.EuroClient;
import edu.utn.Parcial.api.euro.EuroResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BillService {

    private static final Integer AMOUNT_TICKET = 25000;

    private DolarClient dolarClient;
    private EuroClient euroClient;
    private BirthdayRepository partyRepository;
    private PersonService personService;

    @Autowired
    public BillService(DolarClient dolarClient, EuroClient euroClient, BirthdayRepository partyRepository, PersonService personService) {
        this.dolarClient = dolarClient;
        this.euroClient = euroClient;
        this.partyRepository = partyRepository;
        this.personService = personService;
    }

    public List<BillDTO> buildBill(Birthday birthday){

        Set<Player> guestsList = birthday.getGuestsList();

        List<BillDTO> bills = new ArrayList<>();

        guestsList.forEach(
                i -> {
                    bills.add(BillDTO.builder()
                            .nameComplete(i.getName() + " " + i.getLastName())
                            .currency(i.getCurrency().getCurrency())
                            .amount(this.getAmountBill(i.getCurrency()))
                            .build());
                }
        );
        return bills;
    }

    public List<BillDTO> getBill(Integer idManager ){

        Person manager = this.personService.getById(idManager);
        Birthday birthday = this.partyRepository.findByBirthdayPerson(manager).orElseThrow(()-> new NotFoundException("Manager Not Found"));

        return Arrays.asList();
    }
    private String getAmountBill(Currency currency){

        StringBuilder str = new StringBuilder();
        str = str.append("25.000 / cotizacion del ");

        List<DolarResponse> dolars = this.dolarClient.getDolarEnchages();
        EuroResponse euro = this.euroClient.getEuroEnchages();

        dolars.stream().filter( d -> currency.equals(d.getCurrencyConverter().getName()))

                .collect(Collectors.toList());

        return str.toString();
    }



}
