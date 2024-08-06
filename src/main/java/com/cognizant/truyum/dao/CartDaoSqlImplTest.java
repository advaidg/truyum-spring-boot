package com.cognizant.truyum.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoSqlImplTest.class);
	public static void main(String[] args) {
		LOGGER.info("Inside CartDaoSqlImplTest's Main");
		LOGGER.info("AddCartItem invoked");
		testAddCartItem();
		LOGGER.info("getAllCartItem invoked");
		testGetAllCartItem();
		LOGGER.info("removeCartItem invoked");
		testRemoveCartItem();
		testGetAllCartItem();
		LOGGER.info("Completed..");
		
	}
	
	public static void testAddCartItem() {
		CartDaoSqlImpl cartDaoImpl = new CartDaoSqlImpl();
		cartDaoImpl.addCartItem(2, 2);
		cartDaoImpl.addCartItem(1, 2);
		cartDaoImpl.addCartItem(2, 2);
		cartDaoImpl.addCartItem(2, 3);
		cartDaoImpl.addCartItem(2, 4);
	}
	
	public static void testGetAllCartItem() {
		int userId = 2;
		CartDaoSqlImpl cartDaoImpl = new CartDaoSqlImpl();
		try {
			List<MenuItem> menuItemList = cartDaoImpl.getAllCartItems(userId);
			for(MenuItem item : menuItemList) {
				LOGGER.info("{}",item);
			}
		} catch (CartEmptyException e) {
			LOGGER.info(String.format("The user id number %d did not buy anything%n",userId),e);
		}
	}
	
	public static void testRemoveCartItem() {
		CartDaoSqlImpl cartDaoImpl = new CartDaoSqlImpl();
		long userId = 1;
		LOGGER.info("\nBefore Delelting");
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				LOGGER.info("{}",item);
			}
		} catch (CartEmptyException e) {
			LOGGER.info("Cart is Empty",e);
		}
		long menuItemId = 1;
		cartDaoImpl.removeCartItem(userId, menuItemId);
		LOGGER.info("\nAfter Delelting");
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				LOGGER.info("{}",item);
			}
		} catch (CartEmptyException e) {
			LOGGER.info("Cart is Empty",e);
		}
		LOGGER.info(System.lineSeparator());
	}
}
