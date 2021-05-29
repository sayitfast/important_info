package com.sayitfast.important_info.repositories;

import com.sayitfast.important_info.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
