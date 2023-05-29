package lk.coop.compact.repository.authentication;

import lk.coop.compact.entity.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String userName);

}
