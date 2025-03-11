package com.example.carrent.Service;

import com.example.carrent.Model.Car;
import com.example.carrent.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCar(Long number, String brand,String carcategorry, Boolean available, MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();

        Car car = new Car();
        car.setNumber(number);
        car.setBrand(brand);
        car.setImage(imageBytes);
        car.setCarcategorry(carcategorry);
        car.setAvailable(available);

        carRepository.save(car);
    }

    public void editCar(Long carId, Long number, String brand, Boolean available,
                        MultipartFile image) throws IOException {
        Optional<Car> optionalCar = carRepository.findById(carId);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setNumber(number);
            car.setBrand(brand);
            car.setAvailable(available);

            if (image != null && !image.isEmpty()) {
                byte[] imageData = image.getBytes();
                car.setImage(imageData);
            }

            carRepository.save(car);
        } else {
            throw new IllegalArgumentException("Samochód o podanym ID nie istnieje");
        }
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);

    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getAvailableCars() {
        return carRepository.findByAvailableTrue();
    }

    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void setCarUnavailable(Long carId) {
        Car car = carRepository.findById(carId).orElse(null);
        if (car != null) {
            car.setAvailable(false);
            carRepository.save(car);
        } else {
            throw new IllegalArgumentException("Car not found");
        }
    }

    public void save(Car car) {
        carRepository.save(car);
    }
    public List<Car> getCarsByCategory(String category) {
        if ("ALL".equals(category)) {
            return carRepository.findAll(); // Zwróci wszystkie samochody
        }
        return carRepository.findByCarcategorry(category); // Zwróci samochody tylko z wybraną kategorią
    }
}
