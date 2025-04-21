package com.ey.banking.tms.transinit.controller;

import com.ey.banking.tms.transinit.model.TransactionDetail;
import com.ey.banking.tms.transinit.service.TransInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transinit/v1")
public class TransInitController {


    @Autowired
    private TransInitService transInitService;

    @PostMapping("/initialize/{acountId}")
    public ResponseEntity<Object> initTransaction(@PathVariable("acountId") Long accountid, @RequestBody TransactionDetail transactionDetail) {
        // Logic to initialize transaction
        // For example, save transaction details to the database
        TransactionDetail transDetail = transInitService.initializeTransaction(accountid, transactionDetail);
        System.out.println("Transaction initialized successfully for account ID: " + transDetail);

        return ResponseEntity.ok("Transaction initialized successfully for account ID: " + accountid);

    }
}
