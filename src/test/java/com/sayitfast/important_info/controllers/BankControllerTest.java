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

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {BankController.class})
@ExtendWith(SpringExtension.class)
public class BankControllerTest {
    @Autowired
    private BankController bankController;

    @MockBean
    private BankService bankService;

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
}

