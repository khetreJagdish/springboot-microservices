package com.springtransaction.transactiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtransaction.transactiondemo.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

}
