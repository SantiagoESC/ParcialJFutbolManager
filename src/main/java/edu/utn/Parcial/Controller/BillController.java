package edu.utn.Parcial.Controller;

import edu.utn.Parcial.Domain.dto.BillDTO;
import edu.utn.Parcial.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController("/tickets")
public class BillController {

    private BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    public ResponseEntity<List<BillDTO>> getBill(){

        return ResponseEntity.ok().build();
    }
}
