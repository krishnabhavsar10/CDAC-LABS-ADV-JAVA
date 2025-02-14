package fi.cart;

import java.util.Iterator;
import java.util.Vector;

public class ShoppingCart implements Cart 
{
	Vector<CartItem> items = new Vector<>();  // Type Inference
	
	@Override
	public void addItem(CartItem item) 
	{
		items.add(item);		
	}

	@Override
	public void deleteItem(CartItem item) {
		// TODO Auto-generated method stub
		items.remove(item);
	}

	@Override
	public Iterator<CartItem> listCart() {
		// TODO Auto-generated method stub
		return items.iterator();
	}

}
