package com.ey.banking.tms.transinit.service;

import com.ey.banking.tms.transinit.model.Account;
import com.ey.banking.tms.transinit.model.BenefAccount;
import com.ey.banking.tms.transinit.repo.BenefAccountRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.Optional;


@Service
public class AccountService {

    private final WebClient balanceServiceWebClient = WebClient.builder().baseUrl("http://balance-service").build();;


    BenefAccountRepo benefitAccountRepo;


    public Account getAccountByAccountId(Long accountId){
        Account account = new Account();
        account.setAccountId(accountId);
        account.setAccountHolderName("John Doe");
        account.setAccountType(Account.AccountType.SAVINGS);
        account.setBranchName("Main Branch");
        account.setIfscCode("BOA1234567");
        return account;
    }

    
    @Cacheable(value = "benefAccountCache", key = "#benefetryAccount.accountId")
    public BenefAccount findBenefAccountIfExists(BenefAccount benefetryAccount) {

       Optional<BenefAccount> optional = benefitAccountRepo.findById(benefetryAccount.getAccountId());
        return optional.orElseGet(() -> benefitAccountRepo.save(benefetryAccount));
    }


    public Boolean checkBalenceForTrans(BigDecimal amount, Account sourceAccount) {

        return balanceServiceWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/balance/check")
                        .queryParam("accountId", sourceAccount.getAccountId())
                        .queryParam("amount", amount.longValue())
                        .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .onErrorReturn(false)
                .block();
    }

    public Boolean checkTransLimitExausted(BigDecimal amount, Account sourceAccount) {
        return balanceServiceWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/limit/check")
                        .queryParam("accountId", sourceAccount.getAccountId())
                        .queryParam("amount", amount.longValue())
                        .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .onErrorReturn(false)
                .block();
    }
}
