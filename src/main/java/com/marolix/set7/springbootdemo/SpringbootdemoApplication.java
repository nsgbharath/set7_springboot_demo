package com.marolix.set7.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.marolix.set7.springbootdemo.controller.MenuController;

@SpringBootApplication
public class SpringbootdemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootdemoApplication.class, args);
		MenuController mc = context.getBean(MenuController.class);
		// mc.addToMenu();
	 mc.viewMenu();
		// mc.viewProductFromMenu();
	//	mc.deleteProductFromMenu();
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
