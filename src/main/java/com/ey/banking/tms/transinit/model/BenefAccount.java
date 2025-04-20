package com.ey.banking.tms.transinit.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "beneficiary_account")
public class BenefAccount {
    public static enum AccountType {
        SAVINGS, CURRENT, LOAN;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Account ID")
    private Long accountId;
    @Schema(description = "Account Holder Name")
    private String accountHolderName;
    @Schema(description = "Account Type", example = "SAVINGS, CURRENT, LOAN")
    private Account.AccountType accountType;
    @Schema(description = "Bank name")
    private String bankName;

    @Schema(description = "Branch name")
    private String branchName;

    @Schema(description = "IFSC code")
    private String ifscCode;

    @Schema(description = "Account balance")
    private double balance;
}
