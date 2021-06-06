package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.Bank;
import com.sayitfast.important_info.repositories.BankRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {BankService.class})
@ExtendWith(SpringExtension.class)
public class BankServiceTest {
    @MockBean
    private BankRepository bankRepository;

    @Autowired
    private BankService bankService;

    @Test
    public void testGetBanks() {
        ArrayList<Bank> bankList = new ArrayList<Bank>();
        when(this.bankRepository.findAll()).thenReturn(bankList);
        List<Bank> actualBanks = this.bankService.getBanks();
        assertSame(bankList, actualBanks);
        assertTrue(actualBanks.isEmpty());
        verify(this.bankRepository).findAll();
        assertEquals(0L, this.bankService.getBanksCount());
    }

    @Test
    public void testSave() {
        Bank bank = new Bank();
        bank.setBankName("Bank Name");
        bank.setEmail("jane.doe@example.org");
        bank.setPassword("iloveyou");
        bank.setNotes("Notes");
        bank.setId(1);
        bank.setCheckingAccountNumber("Checking Account Number");
        bank.setSavingsAccountNumber("Savings Account Number");
        bank.setInvestmentAccountNumber("Investment Account Number");
        bank.setUserName("janedoe");
        bank.setIsSavings(true);
        bank.setIsCheckingAccount(true);
        bank.setLogin_URL("https://example.org/example");
        bank.setIsInvestmentAccount(true);
        when(this.bankRepository.save((Bank) any())).thenReturn(bank);
        this.bankService.save(new Bank());
        verify(this.bankRepository).save((Bank) any());
        assertTrue(this.bankService.getBanks().isEmpty());
    }

    @Test
    public void testFindById() {
        Bank bank = new Bank();
        bank.setBankName("Bank Name");
        bank.setEmail("jane.doe@example.org");
        bank.setPassword("iloveyou");
        bank.setNotes("Notes");
        bank.setId(1);
        bank.setCheckingAccountNumber("Checking Account Number");
        bank.setSavingsAccountNumber("Savings Account Number");
        bank.setInvestmentAccountNumber("Investment Account Number");
        bank.setUserName("janedoe");
        bank.setIsSavings(true);
        bank.setIsCheckingAccount(true);
        bank.setLogin_URL("https://example.org/example");
        bank.setIsInvestmentAccount(true);
        Optional<Bank> ofResult = Optional.<Bank>of(bank);
        when(this.bankRepository.findById((Integer) any())).thenReturn(ofResult);
        Optional<Bank> actualFindByIdResult = this.bankService.findById(1);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.bankRepository).findById((Integer) any());
        assertTrue(this.bankService.getBanks().isEmpty());
    }

    @Test
    public void testDelete() {
        doNothing().when(this.bankRepository).deleteById((Integer) any());
        this.bankService.delete(1);
        verify(this.bankRepository).deleteById((Integer) any());
        assertTrue(this.bankService.getBanks().isEmpty());
    }

    @Test
    public void testGetBanksCount() {
        when(this.bankRepository.count()).thenReturn(3L);
        assertEquals(3L, this.bankService.getBanksCount());
        verify(this.bankRepository).count();
        assertTrue(this.bankService.getBanks().isEmpty());
    }
}

