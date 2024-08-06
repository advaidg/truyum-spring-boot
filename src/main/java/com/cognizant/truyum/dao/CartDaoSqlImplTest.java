package com.cognizant.truyum.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoSqlImplTest.class);
	
	public static void main(String[] args) {
		//Completed the task associated to this TODO comment.
		LOGGER.info("Inside CartDaoSqlImplTest's Main");
		//System.out.println("Inside CartDaoSqlImplTest's Main");
		LOGGER.info("AddCartItem invoked");
		//System.out.println("AddCartItem invoked");
		testAddCartItem();
		LOGGER.info("getAllCartItem invoked");
		//System.out.println("getAllCartItem invoked");
		testGetAllCartItem();
		LOGGER.info("removeCartItem invoked");
		//System.out.println("removeCartItem invoked");
		testRemoveCartItem();
		testGetAllCartItem();
		LOGGER.info("Completed..");
		//System.out.println("Completed..");
		
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
				LOGGER.info(item.toString());
				//System.out.println(item);
			}
		} catch (CartEmptyException e) {
			LOGGER.info("The user id number {} did not buy anything",userId);
			//System.out.printf("The user id number %f did not buy anything\n",userId);
			LOGGER.error("",e);
			//e.printStackTrace();
		}
	}
	
	public static void testRemoveCartItem() {
		CartDaoSqlImpl cartDaoImpl = new CartDaoSqlImpl();
		long userId = 1;
		LOGGER.info("\nBefore Delelting");
		//System.out.println("\nBefore Delelting");
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				LOGGER.info(item.toString());
				//System.out.println(item);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			LOGGER.error("",e);
			//e.printStackTrace();
		}
		long menuItemId = 1;
		cartDaoImpl.removeCartItem(userId, menuItemId);
		LOGGER.info("\nAfter Delelting");
		//System.out.println("\nAfter Delelting");
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				LOGGER.info(item.toString());
				//System.out.println(item);
			}
		} catch (CartEmptyException e) {
			//Completed the task associated to this TODO comment.
			LOGGER.error("",e);
			//e.printStackTrace();
		}
		LOGGER.info("%n");
		//System.out.println();
	}
}
