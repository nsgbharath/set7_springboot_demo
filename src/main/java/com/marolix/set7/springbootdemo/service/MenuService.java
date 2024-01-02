package com.marolix.set7.springbootdemo.service;

import java.util.List;

import com.marolix.set7.springbootdemo.dto.MenuDTO;
import com.marolix.set7.springbootdemo.entity.Menu;
import com.zaxxer.hikari.util.FastList;

public interface MenuService {
	public MenuDTO addProductToMenu(MenuDTO menu);

	public List<Menu> viewAllItems();

	public Menu viewByProductId(Long id);

	public void deleteByProductId(Long id);

	public List<MenuDTO> viewProductWithProductName(String prodName);

	public List<MenuDTO> filterProductsByPrice(Float price,Float max);
}
