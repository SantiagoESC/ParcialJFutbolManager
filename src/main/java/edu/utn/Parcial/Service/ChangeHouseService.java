package edu.utn.Parcial.Service;

import edu.utn.Parcial.Repository.ChangeHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChangeHouseService {
    private ChangeHouseRepository changeHouseRepository;

    @Autowired
    public ChangeHouseService(ChangeHouseRepository changeHouseRepository) {
        this.changeHouseRepository = changeHouseRepository;
    }
}
