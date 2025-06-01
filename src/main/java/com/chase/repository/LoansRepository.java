package com.chase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chase.entity.Loans;

@Repository
public interface LoansRepository extends JpaRepository <Loans,Long> {

}
