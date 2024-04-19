package com.anand.userservice.users;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("!dev")
public interface UsersRepository extends MongoRepository<User, ObjectId> {
}
