package com.ey.banking.tms.transinit.model;

import lombok.Data;

@Data
public class CustomerDetail {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNumber;
    private String customerEmail;
}
