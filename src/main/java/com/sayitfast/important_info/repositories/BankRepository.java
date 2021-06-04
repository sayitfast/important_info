package com.sayitfast.important_info.repositories;

import com.sayitfast.important_info.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA. User: Rhett Herring 5/29/21 4:08 PM
 */
@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

}
