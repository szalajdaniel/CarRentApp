package com.example.carrent.Repository;

import com.example.carrent.Model.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Long> {
    Optional<Moderator> findByUserId(Long userId);
    List<Moderator> findAll();
}