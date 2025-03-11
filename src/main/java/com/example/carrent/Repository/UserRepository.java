package com.example.carrent.Repository;


import com.example.carrent.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.role FROM User u WHERE u.Id = :userId")
    String findRole(@Param("userId") Long userId);

    User findByUsername(String username);

    @Query("SELECT u.wallet FROM User u WHERE u.Id = :userId")
    BigDecimal findWalletBalanceByUserId(@Param("userId") Long userId);
}
