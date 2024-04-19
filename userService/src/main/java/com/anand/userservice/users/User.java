package com.anand.userservice.users;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    ObjectId id;
    String firstName;
    String lastName;
    String email;
    String password;
    String profilePicUrl;
    String mobileNumber;
}
