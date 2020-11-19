package gorokhov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gorokhov.domain.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findFirstByName(String name);
}
