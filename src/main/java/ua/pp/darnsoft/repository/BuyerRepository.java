package ua.pp.darnsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pp.darnsoft.models.manytoone.jointable.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
