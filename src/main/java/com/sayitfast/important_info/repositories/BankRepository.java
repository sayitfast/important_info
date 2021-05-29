package com.sayitfast.important_info.repositories;

import com.sayitfast.important_info.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA. User: Rhett Herring 5/29/21 4:08 PM
 */
public interface BankRepository extends JpaRepository<Bank, Integer> {

}
