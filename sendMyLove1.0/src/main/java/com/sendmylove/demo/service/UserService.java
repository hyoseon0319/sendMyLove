//package com.sendmylove.demo.service;
//
//import com.sendmylove.demo.model.dao.UserRepository;
//import model.domain.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service("userService")
//public class UserService {
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User findById(int user_id) {
//        return userRepository.findById(user_id);
//    }
//
//    public User saveUser(User user) {
//        user.setActive(1);
//        return userRepository.save(user);
//    }
//
//    public User updateUserActiveState(int user_id, int active) {
//        User user = userRepository.findById(user_id);
//        user.setActive(active);
//        return userRepository.save(user);
//    }
//
//    public List<User> getActiveUserList() {
//        return userRepository.findByActive(1);
//    }
//}
