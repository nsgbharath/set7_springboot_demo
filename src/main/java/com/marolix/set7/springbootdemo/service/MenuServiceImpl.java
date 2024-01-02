package com.marolix.set7.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marolix.set7.springbootdemo.dto.MenuDTO;
import com.marolix.set7.springbootdemo.entity.Menu;
import com.marolix.set7.springbootdemo.exception.BillingAppException;
import com.marolix.set7.springbootdemo.repository.MenuRepository;

@Service(value = "menuServiceImpl")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	@Transactional( noRollbackFor = BillingAppException.class)
	public MenuDTO addProductToMenu(MenuDTO menudto) {
		List<Menu> repoProducts = menuRepository.findByprodName(menudto.getProdName());
		if (repoProducts !=null &&!repoProducts.isEmpty())
			throw new BillingAppException("product already added in db with name " + menudto.getProdName());
		Menu m = new Menu();
		m.setPrice(menudto.getPrice());
		m.setProdName(menudto.getProdName());
		m = menuRepository.save(m);
		Long id = m.getProductId();
		System.out.println("id of added product =" + id);
		menudto.setProdId(id);
		// throw new BillingAppException("dummy exception"); //unchecked exception
		// throw new ArithmeticException("explicitilty generated exeception oject to
		// understand transaction");
		// return menudto;
//		try {
//			throw new Exception("this is checked exception to check the behaviour of the @transactional annotaion");
//		} catch (Exception e) {
//			e.printStackTrace();
////		}
		return menudto;
	}

	@Override
	public List<Menu> viewAllItems() {
		Iterable<Menu> itr = menuRepository.findAll();
		List<Menu> list = new ArrayList<Menu>();
		itr.forEach(m -> list.add(m));

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

	@Override
	public List<MenuDTO> viewProductWithProductName(String prodName) {
//		List<Menu> repoProducts = menuRepository.findByprodName(prodName);
		List<Menu> repoProducts = menuRepository.fetchWithNamedQuery(prodName);
		if (repoProducts.isEmpty())
			throw new BillingAppException("No products found for your search");

		return repoProducts.stream().map((Menu m) -> {

			MenuDTO dto = new MenuDTO(m.getProductId(), m.getProdName(), m.getPrice());
			return dto;
		}).collect(Collectors.toList());

	}

	@Override
	public List<MenuDTO> filterProductsByPrice(Float price, Float price2) {
		List<Menu> repoProducts = menuRepository.fetchDetailsByPrice(price, price2);
		if (repoProducts.isEmpty())
			throw new BillingAppException("No products found for your search");

		return repoProducts.stream().map((Menu m) -> {
			System.out.println("repo menu object " + m);
			MenuDTO dto = new MenuDTO(m.getProductId(), m.getProdName(), m.getPrice());
			return dto;
		}).collect(Collectors.toList());
	}

}
