package com.marolix.set7.springbootdemo.service;

import java.util.List;

import com.marolix.set7.springbootdemo.entity.Menu;

public interface MenuService {
	public void addProductToMenu(Menu menu);
	public List<Menu> viewAllItems();
	
	public Menu viewByProductId(Long id);
	public void deleteByProductId(Long id);
} 
