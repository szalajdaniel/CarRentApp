package com.example.carrent.Service;

import com.example.carrent.Model.Car;
import com.example.carrent.Model.Reservation;
import com.example.carrent.Model.User;
import com.example.carrent.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void createReservation(User user, Car car) {
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setCar(car);
        reservation.setStatus("ACTIVE");

        reservationRepository.save(reservation);
    }

    public List<Reservation> getActiveReservationsByUser(User user) {
        return reservationRepository.findByUserAndStatus(user, "ACTIVE");
    }


    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}