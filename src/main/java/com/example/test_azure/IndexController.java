package com.example.test_azure;

import com.example.test_azure.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
public class IndexController {
    private UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping("/addUser")
    public ResponseEntity<User> AddUser(User user){

        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public  ResponseEntity<HashSet> ShowAllUsers(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> UpdateUser(@RequestParam("id") Long id, @RequestBody User user){

        //REST stopper her
        User newUser = userService.findById(id).get();
        newUser.setName(user.getName());
        userService.save(newUser);
        //REST starter igen her

        return new ResponseEntity(newUser, HttpStatus.OK);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<User> DeleteUser(@RequestParam("id") Long id){
        userService.deleteById(id);
        return new ResponseEntity("useren med ideet " + id + " er slettet", HttpStatus.OK);
    }
}
