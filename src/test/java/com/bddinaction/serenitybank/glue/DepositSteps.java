package com.bddinaction.serenitybank.glue;

import com.bddinaction.serenitybank.accounts.AccountService;
import com.bddinaction.serenitybank.model.AccountType;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Percentage.withPercentage;

public class DepositSteps {

    AccountService accountService = new AccountService();
    String accountNumber;

    @Given("^Joe has a (.*) account with a balance of €(.*)$")
    public void joe_has_an_account_with_a_balance(AccountType accountType, BigDecimal initialBalance) throws Throwable {
        accountNumber = accountService.createNewAccount(accountType,initialBalance);
    }

    @When("^he deposits €(\\d+) into his account$")
    public void he_deposits_€_into_his_account(BigDecimal deposit) throws Throwable {
        accountService.makeDeposit(accountNumber, deposit);
    }

    @Then("^his account should have a balance of €(.*)$")
    public void his_account_should_have_a_balance(BigDecimal expectedBalance) throws Throwable {
        assertThat(accountService.getBalance(accountNumber)).isCloseTo(expectedBalance, withPercentage(0.0));
    }

    @When("^he deposits €(\\d+) into his account on (.*)$")
    public void he_deposits_into_his_account(BigDecimal deposit,
                                             Date transactionDate) throws Throwable {
    }

    @When("^he withdraws €(\\d+) from his account on (.*)$")
    public void he_withdraws_from_his_account(BigDecimal deposit,
                                              Date transactionDate) throws Throwable {
    }

    @Then("^his transaction history should include:$")
    public void his_transaction_history_should_include(DataTable transactions) throws Throwable {
    }

}


