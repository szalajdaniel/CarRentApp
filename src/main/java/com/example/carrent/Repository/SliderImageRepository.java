package com.example.carrent.Repository;

import com.example.carrent.Model.SliderImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SliderImageRepository extends JpaRepository<SliderImage, Long> {
}