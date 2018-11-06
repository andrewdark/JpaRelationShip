package ua.pp.darnsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darnsoft.models.manytoone.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
