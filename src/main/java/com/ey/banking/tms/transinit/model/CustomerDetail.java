package com.ey.banking.tms.transinit.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class CustomerDetail {


    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerEmail;




}
