package com.ey.banking.tms.transinit.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Schema(description = "Beneficiary Account detail")
@Entity
@Table(name = "account")
public class Account {

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
    private AccountType accountType;

    @Schema(description = "Branch Name")
    private String branchName;

    @Schema(description = "IFSC code")
    private String ifscCode;

    // Additional fields and methods can be added as needed
}
