package com.marolix.set7.springbootdemo.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.marolix.set7.springbootdemo.entity.Menu;
import com.marolix.set7.springbootdemo.service.MenuService;

@Controller(value = "menuController")
public class MenuController {

	private MenuService menuService;

	@Autowired
	public MenuController(MenuService menuService) {
		super();
		this.menuService = menuService;
	}

	public void addToMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product details");
		System.out.println("enter product name");
		String name = sc.next().toUpperCase();
		System.out.println("enter price");
		Float price = sc.nextFloat();
		Menu m = new Menu();
		m.setPrice(price);
		m.setProdName(name);
		System.out.println("menu object in controller " + m);
		menuService.addProductToMenu(m);
	}

	public void viewMenu() {
		System.out.println("menu items");
		System.out.println(menuService.viewAllItems());
	}

	public void viewProductFromMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product details");
		System.out.println("enter productid");
		Long id = sc.nextLong();

		System.out.println(menuService.viewByProductId(id));
	}

	public void deleteProductFromMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product details");
		System.out.println("enter productid");
		Long id = sc.nextLong();

		menuService.deleteByProductId(id);
		System.out.println("product deleted successfully");
	}
}
