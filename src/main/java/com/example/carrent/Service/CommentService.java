package com.example.carrent.Service;

import com.example.carrent.Model.Car;
import com.example.carrent.Model.Comment;
import com.example.carrent.Model.User;
import com.example.carrent.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    public final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public void addComment(String content, User user, Car car){
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser(user);
        comment.setCar(car);
        comment.setDate(LocalDateTime.now());
        comment.setApproved(false); // Domyślnie false
        commentRepository.save(comment);
    }
    public void approveComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        if(comment != null) {
            comment.setApproved(true);
            commentRepository.save(comment);
        }
    }

    public List<Comment> getCommentsByCarId(Long carId){
        return commentRepository.findByCarIdAndApprovedTrue(carId);
    }
    public List<Comment> getAllCommentsByCarId(Long carId){
        return commentRepository.findByCarId(carId);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}