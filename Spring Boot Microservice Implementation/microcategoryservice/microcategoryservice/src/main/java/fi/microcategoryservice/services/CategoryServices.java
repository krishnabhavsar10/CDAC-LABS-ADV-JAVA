package fi.microcategoryservice.services;

import java.util.List;

import fi.microcategoryservice.dto.CategoryDTO;

public interface CategoryServices {
	public boolean addNewCategory(CategoryDTO dto);
	public CategoryDTO getCategoryById(int categoryId);
	public List<CategoryDTO> allCategories();
}
