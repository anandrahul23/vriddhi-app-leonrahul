package com.anand.userservice.users.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
public class CreateUserDto {

    enum Color
    {
        RED;

    }

    ObjectId id;
    String firstName;
    String lastName;
    String email;
    String password;
    String mobileNumber;

}
