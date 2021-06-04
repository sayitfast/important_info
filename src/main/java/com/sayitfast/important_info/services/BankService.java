package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.Bank;
import com.sayitfast.important_info.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: Rhett Herring
 * 6/4/21
 * 8:53 AM
 */
@Controller
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    //Return list of countries
    public List<Bank> getBanks() {
        return bankRepository.findAll();
    }

    //SAve new country
    public void save(Bank bank) {
        bankRepository.save(bank);
    }

    //get by id
    public Optional<Bank> findById(int id) {
        return bankRepository.findById(id);
    }

    public void delete(Integer id) {
        bankRepository.deleteById(id);
    }

    public long getBanksCount() {
        return bankRepository.count();
    }

}
