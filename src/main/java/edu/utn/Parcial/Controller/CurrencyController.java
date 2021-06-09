package edu.utn.Parcial.Controller;

import edu.utn.Parcial.Domain.Currency;
import edu.utn.Parcial.Domain.dto.request.CurrencyRequestDTO;
import edu.utn.Parcial.Domain.dto.response.CurrencyResponseDTO;
import edu.utn.Parcial.Service.ChangeHouseService;
import edu.utn.Parcial.Service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    private ChangeHouseService changeHouseService;

    @Autowired
    public CurrencyController(ChangeHouseService changeHouseService) {
        changeHouseService = changeHouseService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> addCurrency(@Valid CurrencyRequestDTO currency){
        return ResponseEntity.ok().build();
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> getCurrency(@Valid CurrencyRequestDTO currency){
        return ResponseEntity.ok().build();
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> getCurrencyById(@Valid CurrencyRequestDTO currency){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> deleteCurrencyById(@Valid CurrencyRequestDTO currency){
        return ResponseEntity.ok().build();
    }

}
