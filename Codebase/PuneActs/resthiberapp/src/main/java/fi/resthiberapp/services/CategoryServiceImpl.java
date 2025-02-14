package fi.resthiberapp.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.resthiberapp.dto.CategoryDTO;
import fi.resthiberapp.entity.Category;
import fi.resthiberapp.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService 
{
	@Autowired
	CategoryRepository repository;
	
	@Override
	public boolean addNewCategory(CategoryDTO dto) 
	{
		Category entityCategory = new Category();
		BeanUtils.copyProperties(dto, entityCategory);
		
		repository.save(entityCategory);
		
		return true;
	}

	@Override
	public CategoryDTO getCategoryById(int categoryId) {
		
		Optional<Category> optCat = repository.findById(categoryId);
		if(optCat.isPresent())
		{
			Category entityCategory =optCat.get();
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(entityCategory, dto);
			return dto;
		}
		else
			return null;
	}

	@Override
	public List<CategoryDTO> allCategories() 
	{
		Iterator<Category> iter = repository.findAll().iterator();
		ArrayList<CategoryDTO> finalList = new ArrayList<>();
		while(iter.hasNext())
		{
			Category eCategory = iter.next();
			
				CategoryDTO dto = new CategoryDTO();
				BeanUtils.copyProperties(eCategory, dto);
				finalList.add(dto);
		}
		return finalList;		
	}

	@Override
	public List<CategoryDTO> getCategoryNameLike(String nameLike) {
		List<Category> allCategory = repository.getCategoriesWithLike(nameLike);
		ArrayList<CategoryDTO> finalList = new ArrayList<>();
		for(Category eCategory: allCategory)
		{
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(eCategory, dto);
			finalList.add(dto);
		}
		return finalList;
	}

}









