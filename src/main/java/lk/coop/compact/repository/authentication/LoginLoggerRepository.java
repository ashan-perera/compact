package lk.coop.compact.repository.authentication;

import lk.coop.compact.entity.authentication.LoginLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLoggerRepository extends JpaRepository<LoginLogger, String> {
}
