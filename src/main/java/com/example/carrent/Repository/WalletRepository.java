package com.example.carrent.Repository;

import com.example.carrent.Model.User;
import com.example.carrent.Model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Wallet findByUser(User user);
}
