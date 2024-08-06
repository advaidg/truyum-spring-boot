package com.cognizant.truyum.controller;

import java.nio.file.FileSystemException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;
    

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

    @InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
    }

    @GetMapping(value = "/show-menu-list-admin")
    public String showMenuItemListAdmin(ModelMap model) throws FileSystemException, ClassNotFoundException, SQLException {
        LOGGER.info("Start - showMenuItemListAdmin");
        model.addAttribute("menuItemListAdmin", menuItemService.getMenuItemListAdmin());
        LOGGER.info("End - showMenuItemListAdmin");
        return "menu-item-list-admin";
    }

    @GetMapping(value = "/show-menu-list-customer")
    public String showMenuItemListCustomer(ModelMap model) throws FileSystemException {
        LOGGER.info("Start - showMenuItemListCustomer");

        model.addAttribute("menuItemListCustomer", menuItemService.getMenuItemListCustomer());
        LOGGER.info("End - showMenuItemListCustomer");

        return "menu-item-list-customer";
    }

    @GetMapping(value = "/show-edit-menu-item")
    public String showEditMenuItem(@RequestParam long menuItemId, ModelMap model) {
        LOGGER.info("Start - showEditMenuItem");
        MenuItem item = menuItemService.getMenuItem(menuItemId);
        
        List<String> categories = Arrays.asList("Starters", "Main Course", "Desert", "Drinks");

    model.addAttribute("menuItem", item);
     model.addAttribute("categoryList", categories);
     
        LOGGER.info("End - showEditMenuItem");
        return "edit-menu-item";
    }
    @PostMapping("/edit-menu-item")
    public String editMenuItem(@ModelAttribute @Valid MenuItem menuItem, BindingResult bindingResult)
    {	LOGGER.info("Start---- edit menu item" );
    	
    	if(bindingResult.hasErrors())
    	{
    		return "edit-menu-item";
    	}
    	menuItemService.getMenuItemDao().modifyMenuItem(menuItem);
   
    	LOGGER.info("End --- edit menu Item");
		return "edit-menu-item-status";
    	
    }
}
