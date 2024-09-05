package com.banking.system.banking.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.system.banking.system.entity.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

}
