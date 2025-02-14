package fi.microcategoryservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.microcategoryservice.dto.CategoryDTO;
import fi.microcategoryservice.services.CategoryServices;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryServices categoryServices;
	
	@PostMapping("/addCategory")
	public boolean addNewCategory(@RequestBody CategoryDTO dto) {
		return categoryServices.addNewCategory(dto);
	}
	
	@GetMapping("/getCategory/{cid}")
	public CategoryDTO getCategoryById(@PathVariable("cid") int categoryId) {
		return categoryServices.getCategoryById(categoryId);
	}
	
	@GetMapping("/allCategory")
	public List<CategoryDTO> allCategories(){
		return categoryServices.allCategories();
	}
}
