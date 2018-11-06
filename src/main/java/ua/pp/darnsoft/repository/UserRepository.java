package ua.pp.darnsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darnsoft.models.onetoone.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
