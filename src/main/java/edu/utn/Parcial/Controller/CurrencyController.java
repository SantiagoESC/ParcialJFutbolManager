package edu.utn.Parcial.Controller;

import edu.utn.Parcial.Domain.Currency;
import edu.utn.Parcial.Service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    //region properties
    private CurrencyService currencyService;
    //endregion

    //region Constructor
    @Autowired
    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }
    //endregion

    //region GET
    @GetMapping("/")
    public List<Currency> getAll(){
        return this.currencyService.getAll();
    }

    @GetMapping("/{id}")
    public Currency getById(@PathVariable("id") Integer id){

        return this.currencyService.getById(id);
    }
    @PostMapping
    public void addCurrency(@RequestBody Currency currency){

        this.currencyService.addCurrency(currency);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Integer id){
        Currency currency = this.getById(id);
        if(currency != null) {
            this.currencyService.deleteCurrency(currency);
        }
    }


    //endregion
}
