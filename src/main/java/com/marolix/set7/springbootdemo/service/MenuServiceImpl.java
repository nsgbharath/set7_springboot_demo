package com.marolix.set7.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.set7.springbootdemo.entity.Menu;
import com.marolix.set7.springbootdemo.repository.MenuRepository;

@Service(value = "menuServiceImpl")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public void addProductToMenu(Menu menu) {
		// create operate
		System.out.println("menu object in service " + menu);
		menuRepository.save(menu);
	}

	@Override
	public List<Menu> viewAllItems() {
		Iterable<Menu> itr = menuRepository.findAll();
		List<Menu> list = new ArrayList<Menu>();
		itr.forEach(m -> list.add(m));
		;
		return list;
	}

	@Override
	public Menu viewByProductId(Long id) {
		Optional<Menu> opt = menuRepository.findById(id);
		return opt.get();
	}

	@Override
	public void deleteByProductId(Long id) {
		menuRepository.deleteById(id);
		
	}

}
