package fi.resthiberapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fi.resthiberapp.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	@Query("select objCat from Category objCat where objCat.categoryName LIKE :name%")
	public List<Category> getCategoriesWithLike(@Param("name")String name);
}
