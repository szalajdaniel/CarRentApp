package com.example.carrent.Repository;

import com.example.carrent.Model.Reservation;
import com.example.carrent.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserAndStatus(User user, String active);
}
