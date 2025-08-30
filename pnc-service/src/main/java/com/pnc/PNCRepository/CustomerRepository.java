package com.pnc.PNCRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pnc.PNCEntity.CustomerEntity;

@Repository

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
