package com.example.carrent.Service;

import com.example.carrent.Model.Moderator;
import com.example.carrent.Model.User;
import com.example.carrent.Repository.ModeratorRepository;
import com.example.carrent.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeratorService {

    @Autowired
    private final ModeratorRepository moderatorRepository;

    @Autowired
    private final UserRepository userRepository;

    public ModeratorService(ModeratorRepository moderatorRepository, UserRepository userRepository) {
        this.moderatorRepository = moderatorRepository;
        this.userRepository = userRepository;
    }

    public void addModerator(User user, String role) {
        Moderator moderator = new Moderator();
        moderator.setUser(user);
        moderator.setRole(role);
        moderatorRepository.save(moderator);
    }

    public void deleteModerator(Long moderatorId){
        moderatorRepository.deleteById(moderatorId);
    }
    public Optional<Moderator> getModeratorByUserId(Long userId){
        return moderatorRepository.findByUserId(userId);
    }
    public List<Moderator> getAllModerators(){
        return  moderatorRepository.findAll();
    }

    public void editModerator(Long moderatorId, String role) {
        Optional<Moderator> moderatorOptional = moderatorRepository.findById(moderatorId);
        if(moderatorOptional.isPresent()){
            Moderator moderator = moderatorOptional.get();
            moderator.setRole(role);
            moderatorRepository.save(moderator);
        } else{
            throw new IllegalArgumentException("Moderator o podanym ID nie istnieje");
        }
    }
    public List<User> getAllModeratorsWithRoleFromUserTable() {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals("Moderator"))
                .collect(Collectors.toList());
    }
    public List<User> getAllNonModerators() {
        List<Long> moderatorIds = moderatorRepository.findAll().stream()
                .map(moderator -> moderator.getUser().getId())
                .collect(Collectors.toList());
        return userRepository.findAll().stream()
                .filter(user -> !moderatorIds.contains(user.getId()))
                .collect(Collectors.toList());
    }

}