package ua.pp.darnsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darnsoft.models.manytomany.intermediate.entity.RoledUser;

public interface RoledUserRepository extends JpaRepository<RoledUser, Long> {
}
