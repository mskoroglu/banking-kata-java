package com.optivem.kata.banking.core.usecases.depositfunds;

import com.optivem.kata.banking.core.common.Guard;
import com.optivem.kata.banking.core.domain.accounts.AccountNumber;
import com.optivem.kata.banking.core.domain.accounts.BankAccount;
import com.optivem.kata.banking.core.domain.accounts.BankAccountRepository;
import com.optivem.kata.banking.core.domain.exceptions.ValidationException;
import com.optivem.kata.banking.core.domain.exceptions.ValidationMessages;
import com.optivem.kata.banking.core.usecases.UseCase;

public class DepositFundsUseCase implements UseCase<DepositFundsRequest, DepositFundsResponse> {

    private BankAccountRepository repository;

    public DepositFundsUseCase(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public DepositFundsResponse handle(DepositFundsRequest request) {
        var bankAccount = getBankAccount(request);

        return new DepositFundsResponse();
    }

    private BankAccount getBankAccount(DepositFundsRequest request) {
        Guard.againstNullOrWhitespace(request.getAccountNumber(), ValidationMessages.ACCOUNT_NUMBER_EMPTY);

        var accountNumber = new AccountNumber(request.getAccountNumber());
        var optionalBankAccount = repository.find(accountNumber);

        if(optionalBankAccount.isEmpty()) {
            throw new ValidationException(ValidationMessages.ACCOUNT_NUMBER_NOT_EXIST);
        }

        return optionalBankAccount.get();
    }
}