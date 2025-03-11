package com.example.carrent.Service;

import com.example.carrent.Model.User;
import com.example.carrent.Repository.UserRepository;
import com.example.carrent.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;


    public BigDecimal getBalance(Long userId) {
        return userRepository.findWalletBalanceByUserId(userId);
    }


    public void addToBalance(User user, BigDecimal amount) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            existingUser.setWallet(existingUser.getWallet() != null ? existingUser.getWallet() : BigDecimal.ZERO);
            existingUser.setWallet(existingUser.getWallet().add(amount));
            userRepository.save(existingUser);
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }

    public void deductFromBalance(User user, BigDecimal amount) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        BigDecimal currentBalance = existingUser.getWallet() != null ? existingUser.getWallet() : BigDecimal.ZERO;
        if (currentBalance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds in the wallet.");
        }

        existingUser.setWallet(currentBalance.subtract(amount));
        userRepository.save(existingUser);
    }
    public boolean checkSufficientFunds(User user, BigDecimal rentalCost) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        BigDecimal currentBalance = existingUser.getWallet() != null ? existingUser.getWallet() : BigDecimal.ZERO;

        return currentBalance.compareTo(rentalCost) >= 0;

    }
}