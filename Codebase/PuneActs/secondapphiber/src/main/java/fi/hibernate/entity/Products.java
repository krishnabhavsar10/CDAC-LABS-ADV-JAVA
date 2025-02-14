package fi.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
@NamedQueries({
	@NamedQuery(name="productsByCategoryId",query="select object(product) from Products product where product.pid.categoryId=:cid"),
	@NamedQuery(name="productsById",query="select object(product) from Products product where product.pid.categoryId=:cid and product.pid.productId=:prodId"),
})
public class Products 
{
	@EmbeddedId
	ProductId pid;
	
	@Column(name="productName")
	String productName;
	@Column(name="productDescription")
	String productDescription;
	@Column(name="productImageUrl")
	String productImageUrl;
	@Column(name="productPrice")
	float productPrice;
	public ProductId getPid() {
		return pid;
	}
	public void setPid(ProductId pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
