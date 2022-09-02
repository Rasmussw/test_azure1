package com.example.test_azure;

import com.example.test_azure.model.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUser{

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userRepo.findAll().forEach(users::add);

        return users;
    }

    @Override
    public User save(User object) {
        userRepo.save(object);
        return null;
    }

    @Override
    public void delete(User object) {
        userRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepo.findById(aLong);
    }
}
