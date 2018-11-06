package ua.pp.darnsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darnsoft.models.manytomany.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
