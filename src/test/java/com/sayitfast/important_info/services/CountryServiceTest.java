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

import java.util.ArrayList;
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
    public void testGetCountries2() {
        ArrayList<Country> countryList = new ArrayList<Country>();
        when(this.countryRepository.findAll()).thenReturn(countryList);
        List<Country> actualCountries = this.countryService.getCountries();
        assertSame(countryList, actualCountries);
        assertTrue(actualCountries.isEmpty());
        verify(this.countryRepository).findAll();
        assertEquals(0L, this.countryService.getCountriesCount());
    }

    @Test
    public void testGetCountries3() {
        ArrayList<Country> countryList = new ArrayList<Country>();
        when(this.countryRepository.findAll()).thenReturn(countryList);
        List<Country> actualCountries = this.countryService.getCountries();
        assertSame(countryList, actualCountries);
        assertTrue(actualCountries.isEmpty());
        verify(this.countryRepository).findAll();
        assertEquals(0L, this.countryService.getCountriesCount());
    }

    @Test
    public void testGetCountries4() {
        ArrayList<Country> countryList = new ArrayList<Country>();
        when(this.countryRepository.findAll()).thenReturn(countryList);
        List<Country> actualCountries = this.countryService.getCountries();
        assertSame(countryList, actualCountries);
        assertTrue(actualCountries.isEmpty());
        verify(this.countryRepository).findAll();
        assertEquals(0L, this.countryService.getCountriesCount());
    }

    @Test
    public void testGetCountries5() {
        ArrayList<Country> countryList = new ArrayList<Country>();
        when(this.countryRepository.findAll()).thenReturn(countryList);
        List<Country> actualCountries = this.countryService.getCountries();
        assertSame(countryList, actualCountries);
        assertTrue(actualCountries.isEmpty());
        verify(this.countryRepository).findAll();
        assertEquals(0L, this.countryService.getCountriesCount());
    }

    @Test
    public void testGetCountries6() {
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
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        when(this.countryRepository.save((Country) any())).thenReturn(country);
        this.countryService.save(new Country());
        verify(this.countryRepository).save((Country) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testSave2() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        when(this.countryRepository.save((Country) any())).thenReturn(country);
        this.countryService.save(new Country());
        verify(this.countryRepository).save((Country) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testSave3() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        when(this.countryRepository.save((Country) any())).thenReturn(country);
        this.countryService.save(new Country());
        verify(this.countryRepository).save((Country) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testSave4() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        when(this.countryRepository.save((Country) any())).thenReturn(country);
        this.countryService.save(new Country());
        verify(this.countryRepository).save((Country) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testSave5() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        when(this.countryRepository.save((Country) any())).thenReturn(country);
        this.countryService.save(new Country());
        verify(this.countryRepository).save((Country) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testFindById() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        Optional<Country> ofResult = Optional.<Country>of(country);
        when(this.countryRepository.findById((Integer) any())).thenReturn(ofResult);
        Optional<Country> actualFindByIdResult = this.countryService.findById(1);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.countryRepository).findById((Integer) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testFindById2() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        Optional<Country> ofResult = Optional.<Country>of(country);
        when(this.countryRepository.findById((Integer) any())).thenReturn(ofResult);
        Optional<Country> actualFindByIdResult = this.countryService.findById(1);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.countryRepository).findById((Integer) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testFindById3() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        Optional<Country> ofResult = Optional.<Country>of(country);
        when(this.countryRepository.findById((Integer) any())).thenReturn(ofResult);
        Optional<Country> actualFindByIdResult = this.countryService.findById(1);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.countryRepository).findById((Integer) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testFindById4() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
        Optional<Country> ofResult = Optional.<Country>of(country);
        when(this.countryRepository.findById((Integer) any())).thenReturn(ofResult);
        Optional<Country> actualFindByIdResult = this.countryService.findById(1);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.countryRepository).findById((Integer) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testFindById5() {
        Country country = new Country();
        country.setContinent("Continent");
        country.setStates(new ArrayList<State>());
        country.setId(1);
        country.setCode("Code");
        country.setNationality("Nationality");
        country.setCapital("Capital");
        country.setDescription("The characteristics of someone or something");
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
    public void testDelete2() {
        doNothing().when(this.countryRepository).deleteById((Integer) any());
        this.countryService.delete(1);
        verify(this.countryRepository).deleteById((Integer) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testDelete3() {
        doNothing().when(this.countryRepository).deleteById((Integer) any());
        this.countryService.delete(1);
        verify(this.countryRepository).deleteById((Integer) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testDelete4() {
        doNothing().when(this.countryRepository).deleteById((Integer) any());
        this.countryService.delete(1);
        verify(this.countryRepository).deleteById((Integer) any());
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testDelete5() {
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

    @Test
    public void testGetCountriesCount2() {
        when(this.countryRepository.count()).thenReturn(3L);
        assertEquals(3L, this.countryService.getCountriesCount());
        verify(this.countryRepository).count();
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testGetCountriesCount3() {
        when(this.countryRepository.count()).thenReturn(3L);
        assertEquals(3L, this.countryService.getCountriesCount());
        verify(this.countryRepository).count();
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testGetCountriesCount4() {
        when(this.countryRepository.count()).thenReturn(3L);
        assertEquals(3L, this.countryService.getCountriesCount());
        verify(this.countryRepository).count();
        assertTrue(this.countryService.getCountries().isEmpty());
    }

    @Test
    public void testGetCountriesCount5() {
        when(this.countryRepository.count()).thenReturn(3L);
        assertEquals(3L, this.countryService.getCountriesCount());
        verify(this.countryRepository).count();
        assertTrue(this.countryService.getCountries().isEmpty());
    }
}

