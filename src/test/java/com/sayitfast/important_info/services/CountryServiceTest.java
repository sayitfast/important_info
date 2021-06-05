package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.Country;
import com.sayitfast.important_info.models.State;
import com.sayitfast.important_info.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {CountryService.class})
@ExtendWith(SpringExtension.class)
public class CountryServiceTest {
    @MockBean
    private CountryRepository countryRepository;

    @Autowired
    private CountryService countryService;

    @Test
    public void testGetCountries() {
        ArrayList<Country> countryList = new ArrayList<Country>();
        when(this.countryRepository.findAll()).thenReturn(countryList);
        List<Country> actualCountries = this.countryService.getCountries();
        assertSame(countryList, actualCountries);
        assertTrue(actualCountries.isEmpty());
        verify(this.countryRepository).findAll();
        assertEquals(0L, this.countryService.getCountriesCount());
    }

    @Test
    public void testSave() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        country.setStates(new ArrayList<State>());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        country.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        country.setId(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        country.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDetails("Details");
        country.setDescription("The characteristics of someone or something");
        country.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        when(this.countryRepository.save((Country) any())).thenReturn(country);
        this.countryService.save(new Country());
        verify(this.countryRepository).save((Country) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testFindById() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setLastModifiedBy("Jan 1, 2020 9:00am GMT+0100");
        country.setStates(new ArrayList<State>());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        country.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        country.setId(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        country.setLastModifiedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDetails("Details");
        country.setDescription("The characteristics of someone or something");
        country.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
        Optional<Country> ofResult = Optional.<Country>of(country);
        when(this.countryRepository.findById((Integer) any())).thenReturn(ofResult);
        Optional<Country> actualFindByIdResult = this.countryService.findById(1);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.countryRepository).findById((Integer) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testDelete() {
        doNothing().when(this.countryRepository).deleteById((Integer) any());
        this.countryService.delete(1);
        verify(this.countryRepository).deleteById((Integer) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testGetCountriesCount() {
        when(this.countryRepository.count()).thenReturn(3L);
        assertEquals(3L, this.countryService.getCountriesCount());
        verify(this.countryRepository).count();
        assertTrue(this.countryService.getCountries().isEmpty());
    }
}

