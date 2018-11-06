package ua.pp.darnsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darnsoft.models.manytomany.intermediate.entity.RoleE;

public interface RoleERepository extends JpaRepository<RoleE, Long> {

}
