package lk.coop.compact.repository;

import lk.coop.compact.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String userName);

}
