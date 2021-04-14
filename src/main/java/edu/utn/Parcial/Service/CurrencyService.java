package edu.utn.Parcial.Service;

import edu.utn.Parcial.Domain.Currency;
import edu.utn.Parcial.Exception.AlreadyExistException;
import edu.utn.Parcial.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CurrencyService {

    //region Properties
    private CurrencyRepository currencyRepository;
    //endregion

    //region Constructor
    @Autowired
    public  CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }

     //endregion

    //region REQUEST
    public List<Currency> getAll() {
        return this.currencyRepository.findAll();
    }

    public Currency getById(Integer id) {

        return this.currencyRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void addCurrency(Currency currency) {
        this.currencyRepository.save(currency);
    }

    public void deleteCurrency(Currency currency) {
        this.currencyRepository.delete(currency);
    }

    //endregion
}
