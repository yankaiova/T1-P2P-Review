package ru.akhramenko.P2PReview.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhramenko.P2PReview.entity.User;
import ru.akhramenko.P2PReview.repo.UserRepo;
import ru.akhramenko.P2PReview.utils.exeption.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(UUID id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public User create(User user) {
        User createdUser = new User();
        createdUser.setUser_id(UUID.randomUUID());
        createdUser.setTelegram(user.getTelegram());
        return userRepo.save(createdUser);
    }

    @Transactional
    public User update(UUID id, User user) {
        User existingUser = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        User updatedUser = new User();
        updatedUser.setUser_id(existingUser.getUser_id());
        updatedUser.setTelegram(user.getTelegram());
        return userRepo.save(updatedUser);
    }

    @Transactional
    public void delete(UUID id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        userRepo.delete(user);
    }
}
