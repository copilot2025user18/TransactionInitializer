package com.ey.banking.tms.transinit.repo;

import com.ey.banking.tms.transinit.model.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeansactionInitRepo extends JpaRepository<TransactionDetail, String> {
    // Custom query methods can be defined here if needed
    // For example, find transactions by account ID or date range
    // List<TransactionDetail> findByAccountId(String accountId);
}
