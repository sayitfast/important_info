package com.sayitfast.important_info.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA. User: Rhett Herring 5/26/21 1:39 PM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;
    @Column(name = "Savings")
    private Boolean savings;
    @Column(name = "Savings_Account_Number")
    private String savingsAccountNumber;
    @Column(name = "Checking_Account_Number")
    private String checkingAccountNumber;
    @Column(name = "Investment_Account_Number")
    private String investmentAccountNumber;
    @Column(name = "Investment_Account")
    private Boolean investmentAccount;
}
