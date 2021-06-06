package com.sayitfast.important_info.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA. User: Rhett Herring 5/26/21 1:39 PM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Bank extends CommonObject {

    @Column(name = "Bank_Name")
    private String bankName;
    @Column(name = "User_Name")
    private String userName;
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;
    @Column(name = "Login_URL")
    private String login_URL;
    @Column(name = "is_Checking_Account")
    private Boolean isCheckingAccount;
    @Column(name = "is_Savings")
    private Boolean isSavings;
    @Column(name = "is_Investment_Account")
    private Boolean isInvestmentAccount;
    @Column(name = "Savings_Account_Number")
    private String savingsAccountNumber;
    @Column(name = "Checking_Account_Number")
    private String checkingAccountNumber;
    @Column(name = "Investment_Account_Number")
    private String investmentAccountNumber;
    @Column(name = "Notes")
    private String Notes;

}
