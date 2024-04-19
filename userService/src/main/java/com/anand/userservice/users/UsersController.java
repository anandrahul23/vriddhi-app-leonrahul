package com.anand.userservice.users;


import com.anand.userservice.users.dto.CreateUserDto;
import com.anand.userservice.users.dto.DisplayUserDto;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
    @RequestMapping("/api/v1/users")
@Profile("!dev")
public class UsersController {

    UserService userService;

    UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<DisplayUserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("")
    public ResponseEntity<DisplayUserDto> createUser(@RequestBody CreateUserDto createUserDto) {

        DisplayUserDto displayUserDto = userService.createUser(createUserDto);

        return ResponseEntity.created(URI.create("/api/v1/users/" + createUserDto.getId())).body(displayUserDto);
    }

    @GetMapping(path= "/{id}")
    public ResponseEntity<DisplayUserDto> getUser(@PathVariable String id) {
        DisplayUserDto displayUserDto = userService.getUser(id);
        return ResponseEntity.ok(displayUserDto);
    }
}
