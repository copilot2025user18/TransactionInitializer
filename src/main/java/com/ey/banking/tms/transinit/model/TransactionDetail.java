package com.ey.banking.tms.transinit.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transaction_detail")
public class TransactionDetail {

    public static enum TransactionType {
        UPI, NIFT, IMPS,RTGS, INTERNAL;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID uuid;

    @Schema(description = "Source account details")
    @ManyToOne
    @JoinColumn(name = "account_id")
    public Account account;

    @ManyToOne
    @JoinColumn(name = "benef_account_id")
    @Schema(description = "Destination account details")
    public BenefAccount benefetryAccount;

    @Schema(description = "Transaction ID", example = "UPI, NIFT, IMPS,RTGS, INTERNAL")
    public TransactionType transactionType;

    @Schema(description = "Transaction amount")
    public BigDecimal amount;

    @Schema(description = "Transaction timestamp")
    public LocalDateTime timeStamp;

    public boolean balenceCheckStatus;

    public  boolean transLimitChkStatus;


}
