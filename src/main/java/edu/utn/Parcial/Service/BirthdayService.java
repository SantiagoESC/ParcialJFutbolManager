package edu.utn.Parcial.Service;

import edu.utn.Parcial.Domain.Birthday;
import edu.utn.Parcial.Domain.Friend;
import edu.utn.Parcial.Exception.NotFoundException;
import edu.utn.Parcial.Repository.BirthdayRepository;
import edu.utn.Parcial.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirthdayService {
    //region Properties
    private BirthdayRepository birthdayRepository;
    //endregion

    //region Constructor
    @Autowired
    public  BirthdayService(BirthdayRepository birthdayRepository){
        this.birthdayRepository = birthdayRepository;
    }

    public void refreshBirthday(Birthday birthday) {
        this.birthdayRepository.save(birthday);
    }

    public Birthday getById(Integer idBirthday) {
        return  this.birthdayRepository.findById(idBirthday).orElseThrow(() -> new NotFoundException("Birthday cannot find"));
    }

    public List<Birthday> getAll() {
        return  this.birthdayRepository.findAll();
    }

    //endregion



}
