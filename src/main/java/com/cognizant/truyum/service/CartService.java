.java
package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service("CartService")
/**
 * 
 * @author Advaid Gireesan Service Class
 */
public class CartService {
	@Autowired
	/**
	 * 
	 */
	private CartDao cartDao;

	public void setCartDao(final CartDao cartDao) {
		this.cartDao = cartDao;
	}

	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 *  // Removed throws declarations as no checked exceptions are thrown in the method body
	 */
	public void addCartItem(final long userId, final long menuItemId) {

		cartDao.addCartItem(userId, menuItemId);

	}

	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 * // Removed throws declarations as no checked exceptions are thrown in the method body
	 */
	public void removeCartItem(final long userId, final long menuItemId)
			throws CartEmptyException { // Kept CartEmptyException as it is a custom exception and might be thrown by the dao layer
		cartDao.removeCartItem(userId, menuItemId);
	}

	/**
	 * 
	 * @param userid
	 * @return
	 * // Removed throws declarations as no checked exceptions are thrown in the method body
	 */
	public List<MenuItem> getAllCartItems(final long userid)
			throws CartEmptyException { // Kept CartEmptyException as it is a custom exception and might be thrown by the dao layer

		return cartDao.getAllCartItems(userid);

	}
}
