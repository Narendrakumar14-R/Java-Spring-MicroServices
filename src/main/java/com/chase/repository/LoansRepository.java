package com.chase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chase.entity.Loans;

public interface LoansRepository extends JpaRepository <Loans,Long> {

}
