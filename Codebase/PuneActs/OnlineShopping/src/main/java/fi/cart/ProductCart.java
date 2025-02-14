package fi.cart;

import java.util.Iterator;

public class ProductCart implements Cart {

	@Override
	public void addItem(CartItem item) {
		// TODO Auto-generated method stub
		System.out.println("addItem of ProductCart");
	}

	@Override
	public void deleteItem(CartItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<CartItem> listCart() {
		// TODO Auto-generated method stub
		System.out.println("list Item of ProductCart");
		return null;
	}

}
