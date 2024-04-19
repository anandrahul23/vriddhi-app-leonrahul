package com.anand.userservice.users.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
public class DisplayUserDto {
    ObjectId id;
    String firstName;
    String lastName;
    String email;
    String mobileNumber;
    String profilePicUrl;
}
