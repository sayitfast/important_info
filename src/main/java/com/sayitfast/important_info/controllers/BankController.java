package com.sayitfast.important_info.controllers;

import com.sayitfast.important_info.models.Bank;
import com.sayitfast.important_info.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: Rhett Herring
 * 6/4/21
 * 8:57 AM
 */
@Controller
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/banks")
    public String getCountries(Model model) {
        List<Bank> bankList = bankService.getBanks();
        model.addAttribute("banks", bankList);
        model.addAttribute("banksCount", bankList.size());
        return "bank";
    }

    @PostMapping("/banks/addNew")
    public String addNew(Bank bank) {
        bankService.save(bank);
        return "redirect:/banks";
    }

    @RequestMapping("banks/findById")
    @ResponseBody
    public Optional<Bank> findById(int id) {
        return bankService.findById(id);
    }

    @RequestMapping(value = "/banks/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Bank bank) {
        bankService.save(bank);
        return "redirect:/banks";
    }

    @RequestMapping(value = "/banks/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        bankService.delete(id);
        return "redirect:/banks";
    }
}
