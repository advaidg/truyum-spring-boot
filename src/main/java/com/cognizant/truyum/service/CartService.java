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
	 */
	public void addCartItem(final long userId, final long menuItemId) {

		cartDao.addCartItem(userId, menuItemId);

	}

	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 * @throws CartEmptyException
	 */
	public void removeCartItem(final long userId, final long menuItemId) throws CartEmptyException {
		cartDao.removeCartItem(userId, menuItemId);
	}

	/**
	 * 
	 * @param userid
	 * @return
	 * @throws CartEmptyException
	 */
	public List<MenuItem> getAllCartItems(final long userid) throws CartEmptyException {

		return cartDao.getAllCartItems(userid);

	}
}
