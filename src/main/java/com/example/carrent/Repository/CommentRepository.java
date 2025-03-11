package com.example.carrent.Repository;

import com.example.carrent.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCarId(Long carId);
    List<Comment> findByCarIdAndApprovedTrue(Long carId);
}