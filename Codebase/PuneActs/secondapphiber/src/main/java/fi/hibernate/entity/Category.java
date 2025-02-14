package fi.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
@NamedQueries({
	@NamedQuery(name="allCategories",query = "select object(oCategory) from Category oCategory"),
	@NamedQuery(name="categoryById", query="select object(oCategory) from Category oCategory where oCategory.categoryId=:cid")
})
public class Category 
{
	@Id
	@Column(name="categoryId")
	@GeneratedValue(generator = "increment")
	int categoryId;
	
	@Column(name="categoryName")
	String categoryName;
	
	@Column(name="categoryDescription")
	String categoryDescription;
	
	@Column(name="categoryImageUrl")
	String categoryImageUrl;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}

	public void setCategoryImageUrl(String categoryImageUrl) {
		this.categoryImageUrl = categoryImageUrl;
	}
	
	
}
