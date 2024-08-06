/**
 * 
 */
package com.cognizant.truyum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

/**
 * @author Advaid Gireesan
 *
 */
@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@GetMapping(value = "/add-to-cart")
	public String addToCart(@RequestParam int menuItemId, ModelMap model) {
		LOGGER.info("add-to-cart-Start-addToCart-CartController");
		try {
			cartService.addCartItem(1, menuItemId);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		model.put("successCart", true);
		LOGGER.info("add-to-cart-end-addToCart-CartController");
		return "forward:/show-menu-list-customer";
	}

	@GetMapping(value = "/show-cart")
	public String showCart(@RequestParam int userId, ModelMap map) {
		try {
			List<MenuItem> menuList = cartService.getAllCartItems(userId);
			if (menuList.isEmpty()) {
				throw new CartEmptyException();
			}
			map.put("menuItemListCart", menuList);

		} catch (ClassNotFoundException | CartEmptyException | IOException | SQLException e) {
			return "cart-empty";
		}

		return "cart";

	}

	@GetMapping(value = "/remove-cart")
	public String removeCart(@RequestParam int menuItemId, @RequestParam int userId, ModelMap map) {
		LOGGER.info("Start remove-cart controller");
		List<MenuItem> menuList = null;
		try {
			cartService.removeCartItem(userId, menuItemId);
			menuList = cartService.getAllCartItems(userId);

			if (menuList.isEmpty()) {
				throw new CartEmptyException();
			}

		} catch (ClassNotFoundException | CartEmptyException | IOException | SQLException e) {
			return "cart-empty";
		}
		map.put("removeFromCart", true);
		map.put("menuItemListCart", menuList);
		return "cart";
	}
}
