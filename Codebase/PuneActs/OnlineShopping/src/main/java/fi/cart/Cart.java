package fi.cart;

import java.util.Iterator;

public interface Cart 
{
	public void addItem(CartItem item);
	public void deleteItem(CartItem item);
	public Iterator<CartItem> listCart();
}
