package com.sayitfast.important_info.controllers;

import com.sayitfast.important_info.models.Country;
import com.sayitfast.important_info.models.State;
import com.sayitfast.important_info.services.CountryService;
import org.hamcrest.Matchers;
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
import java.util.Optional;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {CountryController.class})
@ExtendWith(SpringExtension.class)
public class CountryControllerTest {
    @Autowired
    private CountryController countryController;

    @MockBean
    private CountryService countryService;

    @Test
    public void testAddNew() throws Exception {
        doNothing().when(this.countryService).save((com.sayitfast.important_info.models.Country) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/countries/addNew");
        MockMvcBuilders.standaloneSetup(this.countryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("country"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/countries"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/countries"));
    }

    @Test
    public void testGetCountries() throws Exception {
        when(this.countryService.getCountries()).thenReturn(new ArrayList<Country>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/countries");
        MockMvcBuilders.standaloneSetup(this.countryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("countries", "countriesCount"))
                .andExpect(MockMvcResultMatchers.view().name("country"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("country"));
    }

    @Test
    public void testGetCountries2() throws Exception {
        when(this.countryService.getCountries()).thenReturn(new ArrayList<Country>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/countries");
        MockMvcBuilders.standaloneSetup(this.countryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(2))
                .andExpect(MockMvcResultMatchers.model().attributeExists("countries", "countriesCount"))
                .andExpect(MockMvcResultMatchers.view().name("country"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("country"));
    }

    @Test
    public void testFindById() throws Exception {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        Optional<Country> ofResult = Optional.<Country>of(country);
        when(this.countryService.findById(anyInt())).thenReturn(ofResult);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/countries/findById");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.countryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"id\":1,\"code\":\"Code\",\"capital\":\"Capital\",\"description\":\"The characteristics of someone or something"
                                        + "\",\"nationality\":\"Nationality\",\"continent\":\"Continent\",\"states\":[]}")));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(this.countryService).delete((Integer) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/countries/delete");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("id", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.countryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/countries"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/countries"));
    }

    @Test
    public void testUpdate() throws Exception {
        doNothing().when(this.countryService).save((com.sayitfast.important_info.models.Country) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/countries/update");
        MockMvcBuilders.standaloneSetup(this.countryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("country"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/countries"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/countries"));
    }

    @Test
    public void testUpdate2() throws Exception {
        doNothing().when(this.countryService).save((com.sayitfast.important_info.models.Country) any());
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/countries/update");
        putResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.countryController)
                .build()
                .perform(putResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("country"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/countries"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/countries"));
    }
}

