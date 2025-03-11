package com.example.carrent.Repository;
import com.example.carrent.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByAvailableTrue();
    List<Car> findByCarcategorry(String carcategorry);

}
