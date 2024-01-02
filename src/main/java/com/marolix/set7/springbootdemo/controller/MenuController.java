package com.marolix.set7.springbootdemo.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.marolix.set7.springbootdemo.dto.MenuDTO;
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
		String name = sc.nextLine().toUpperCase();
		System.out.println("name " + name);
		System.out.println("enter price");
		Float price = sc.nextFloat();
		System.out.println("price " + price);
		MenuDTO m = new MenuDTO();
		m.setPrice(price);
		m.setProdName(name);
		System.out.println("menudto object in controller " + m);
		MenuDTO dto = menuService.addProductToMenu(m);
		System.out.println("newly created dto object " + dto);
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

	public void searchByName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product name");
		String name = sc.nextLine();
		System.out.println(name);
		List<MenuDTO> dtos = menuService.viewProductWithProductName(name);
		System.out.println("All products with name " + dtos);
		sc.close();
	}

	public void filterByPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the min price");
		Float price = sc.nextFloat();
		System.out.println("enter the max price");
		Float maxprice = sc.nextFloat();
		List<MenuDTO> dtos = menuService.filterProductsByPrice(price, maxprice);
		System.out.println(" products with price greater than " + price + "and less than " + maxprice + ":" + dtos);
	}

}
