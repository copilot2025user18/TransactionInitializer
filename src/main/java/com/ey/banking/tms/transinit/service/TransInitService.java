package com.ey.banking.tms.transinit.service;

import com.ey.banking.tms.transinit.model.Account;
import com.ey.banking.tms.transinit.model.BenefAccount;
import com.ey.banking.tms.transinit.model.TransactionDetail;
import com.ey.banking.tms.transinit.repo.TeansactionInitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransInitService {

    @Autowired
    public AccountService accountService;

    @Autowired
    public TeansactionInitRepo transactionInitRepo;

    public TransactionDetail initializeTransaction(Long accountId, TransactionDetail transactionDetail) {
        // Logic to initialize transaction
        //Get User Account
        Account sourceAccount =  accountService.getAccountByAccountId(accountId);
        transactionDetail.setAccount(sourceAccount);

        //Get Beneficiary Account
        BenefAccount benefAccount = accountService.findBenefAccountIfExists(transactionDetail.getBenefetryAccount());
        transactionDetail.setBenefetryAccount(benefAccount);

        //Save Transaction
        transactionDetail = transactionInitRepo.save(transactionDetail);

        //Balance check
        Boolean balenceCheck = accountService.checkBalenceForTrans(transactionDetail.getAmount(), sourceAccount);
        transactionDetail.setBalenceCheckStatus(balenceCheck);

        //Transaction Limit check
        Boolean transLimitcheckStatus = accountService.checkTransLimitExausted(transactionDetail.getAmount(), sourceAccount);
        transactionDetail.setTransLimitChkStatus(transLimitcheckStatus);

        //Save Check Transaction Status
        transactionInitRepo.save(transactionDetail);

        return transactionDetail;
    }
}
