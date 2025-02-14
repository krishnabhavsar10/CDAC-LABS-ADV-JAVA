package fi.microcategoryservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.microcategoryservice.dto.CategoryDTO;
import fi.microcategoryservice.entity.Category;
import fi.microcategoryservice.repository.CategoryRepository;

@Service
public class CategoryServicesImpl implements CategoryServices {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public boolean addNewCategory(CategoryDTO dto) {
		Category category = new Category();
		BeanUtils.copyProperties(dto, category);
		categoryRepository.save(category);
		return true;
	}

	@Override
	public CategoryDTO getCategoryById(int categoryId) {
		Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
		if(categoryOptional.isPresent()) {
			CategoryDTO categoryDTO = new CategoryDTO();
			BeanUtils.copyProperties(categoryOptional.get(), categoryDTO);
			return categoryDTO;
		}
		else {
			return null;
		}
		
	}

	
	@Override
	public List<CategoryDTO> allCategories() {
		List<Category> entityList = categoryRepository.findAll();
		ArrayList<CategoryDTO> finalList = new ArrayList<>();
		
		for(Category c : entityList) {
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(c, dto);
			finalList.add(dto);			
		}
		return finalList;
	}

}
