package com.ey.banking.tms.transinit.repo;

import com.ey.banking.tms.transinit.model.BenefAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefAccountRepo extends JpaRepository<BenefAccount, Long> {
    // Custom query methods can be defined here if needed
    // For example, find accounts by account ID or date range
    // List<Account> findByAccountId(String accountId);
}
