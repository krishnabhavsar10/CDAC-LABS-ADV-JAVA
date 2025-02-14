package fi.resthiberapp.services;

import java.util.List;

import fi.resthiberapp.dto.CategoryDTO;

public interface CategoryService 
{
	public boolean addNewCategory(CategoryDTO dto);
	public CategoryDTO getCategoryById(int categoryId);
	public List<CategoryDTO> allCategories();
	public List<CategoryDTO> getCategoryNameLike(String nameLike);
}
