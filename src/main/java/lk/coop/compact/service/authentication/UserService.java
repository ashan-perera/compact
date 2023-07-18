package lk.coop.compact.service.authentication;

import lk.coop.compact.dto.authentication.request.UserRequest;
import lk.coop.compact.dto.authentication.response.UserResponse;
import lk.coop.compact.entity.authentication.User;

import java.util.List;

public interface UserService {

    UserResponse save(UserRequest user);

    List<User> findAll();

    User findOne(String username);

    User findByUserName(String userName);

}
