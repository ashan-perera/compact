package lk.coop.compact.repository;

import lk.coop.compact.entity.LoginLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLoggerRepository extends JpaRepository<LoginLogger, String> {
}
