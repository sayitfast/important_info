package com.sayitfast.important_info.controllers;

import com.sayitfast.important_info.models.Bank;
import com.sayitfast.important_info.services.BankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {BankController.class})
@ExtendWith(SpringExtension.class)
public class BankControllerTest {
    @Autowired
    private BankController bankController;

    @MockBean
    private BankService bankService;

//    @Test
//    public void testFindById() throws Exception {
//        Bank bank = new Bank();
//        bank.setBankName("Bank Name");
//        bank.setEmail("jane.doe@example.org");
//        bank.setPassword("iloveyou");
//        bank.setNotes("Notes");
//        bank.setId(1);
//        bank.setCheckingAccountNumber("Checking Account Number");
//        bank.setSavingsAccountNumber("Savings Account Number");
//        bank.setInvestmentAccountNumber("Investment Account Number");
//        bank.setUserName("janedoe");
//        bank.setIsSavings(true);
//        bank.setIsCheckingAccount(true);
//        bank.setLogin_URL("https://example.org/example");
//        bank.setIsInvestmentAccount(true);
//        Optional<Bank> ofResult = Optional.<Bank>of(bank);
//        when(this.bankService.findById(anyInt())).thenReturn(ofResult);
//        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/banks/findById");
//        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));
//        MockMvcBuilders.standaloneSetup(this.bankController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(Matchers.containsString(
//                                "{\"id\":1,\"bankName\":\"Bank Name\",\"userName\":\"janedoe\",\"password\":\"iloveyou\",\"email\":\"jane.doe@example"
//                                        + ".org\",\"isCheckingAccount\":true,\"isSavings\":true,\"isInvestmentAccount\":true,\"savingsAccountNumber\":\"Savings"
//                                        + " Account Number\",\"checkingAccountNumber\":\"Checking Account Number\",\"investmentAccountNumber\":\"Investment"
//                                        + " Account Number\",\"login_URL\":\"https://example.org/example\",\"notes\":\"Notes\"}")));
//    }

    @Test
    public void testAddNew() throws Exception {
        doNothing().when(this.bankService).save((com.sayitfast.important_info.models.Bank) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/banks/addNew");
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("bank"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/banks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/banks"));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(this.bankService).delete((Integer) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/banks/delete");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/banks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/banks"));
    }

    @Test
    public void testGetCountries() throws Exception {
        when(this.bankService.getBanks()).thenReturn(new ArrayList<Bank>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/banks");
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("banks", "banksCount"))
                .andExpect(MockMvcResultMatchers.view().name("bank"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("bank"));
    }

    @Test
    public void testUpdate() throws Exception {
        doNothing().when(this.bankService).save((com.sayitfast.important_info.models.Bank) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/banks/update");
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("bank"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/banks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/banks"));
    }

    @Test
    public void testUpdate2() throws Exception {
        doNothing().when(this.bankService).save((com.sayitfast.important_info.models.Bank) any());
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/banks/update");
        putResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.bankController)
                .build()
                .perform(putResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("bank"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/banks"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/banks"));
    }
}

