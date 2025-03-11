package com.example.carrent.Service;

import com.example.carrent.Model.SliderImage;
import com.example.carrent.Repository.SliderImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SliderImageService {
    @Autowired
    public final SliderImageRepository sliderImageRepository;

    public SliderImageService(SliderImageRepository sliderImageRepository) {
        this.sliderImageRepository = sliderImageRepository;
    }

    public void addSliderImage(MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        SliderImage sliderImage = new SliderImage();
        sliderImage.setImage(imageBytes);
        sliderImageRepository.save(sliderImage);

    }

    public List<SliderImage> getAllSliderImages(){
        return sliderImageRepository.findAll();
    }

}