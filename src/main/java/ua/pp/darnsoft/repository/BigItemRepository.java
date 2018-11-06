package ua.pp.darnsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darnsoft.models.manytomany.BigItem;

public interface BigItemRepository extends JpaRepository<BigItem, Long> {
}
