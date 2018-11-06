package ua.pp.darnsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darnsoft.models.manytomany.intermediate.entity.UserE;

public interface UserERepository extends JpaRepository<UserE, Long> {
}
