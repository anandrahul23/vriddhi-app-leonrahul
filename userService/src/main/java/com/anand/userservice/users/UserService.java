package com.anand.userservice.users;


import com.anand.userservice.commons.exceptions.UserCreationException;
import com.anand.userservice.commons.exceptions.UserNotFoundException;
import com.anand.userservice.users.dto.CreateUserDto;
import com.anand.userservice.users.dto.DisplayUserDto;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("!dev")
public class UserService {
    ModelMapper modelMapper;
    UsersRepository usersRepository;

    UserService(ModelMapper modelMapper, UsersRepository usersRepository) {
        this.modelMapper = modelMapper;
        this.usersRepository = usersRepository;
    }


    List<DisplayUserDto> getAllUsers() {
        List<Integer> intList = List.of(1, 2, 3, 4);
        intList.stream().max((i, j) -> i > j ? i : j );
        return modelMapper.map(usersRepository.findAll(), List.class);
    }

    DisplayUserDto createUser(CreateUserDto userDto) {

        User createdUser = usersRepository.insert(modelMapper.map(userDto, User.class));
        //TODO existing user check
        //TODO password encryption
        //TODO email verification
        //TODO email format check
        //TODO mobile number format check
        //TODO mobile number verification
        if (createdUser == null) {
            throw new UserCreationException("User creation failed for user: " + userDto.getEmail() + "");
        }

        return modelMapper.map(createdUser, DisplayUserDto.class);

    }

    DisplayUserDto getUser(String id) {
        User user = usersRepository.findById(new ObjectId(id)).orElseThrow(() -> new UserNotFoundException("User not found for id: " + id));
        return modelMapper.map(user, DisplayUserDto.class);
    }


}
