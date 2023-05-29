package lk.coop.compact.repository.authentication;

import lk.coop.compact.entity.authentication.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByName(String name);

}
