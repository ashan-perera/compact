package lk.coop.compact.service;

import lk.coop.compact.dto.request.UserRequest;
import lk.coop.compact.dto.response.UserResponse;
import lk.coop.compact.entity.User;

import java.util.List;

public interface UserService {

    UserResponse save(UserRequest user);

    List<User> findAll();

    User findOne(String username);

    User findByUserName(String userName);

}
