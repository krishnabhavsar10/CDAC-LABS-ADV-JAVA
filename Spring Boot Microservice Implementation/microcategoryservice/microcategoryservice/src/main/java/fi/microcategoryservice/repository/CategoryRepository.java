package fi.microcategoryservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fi.microcategoryservice.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
