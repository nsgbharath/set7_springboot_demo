package com.marolix.set7.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marolix.set7.springbootdemo.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {
//method name Approach
	List<Menu> findByprodName(String prodName);

//QueryApproach
	// native query

	// named parameters
//	@Query(value = "select * from menu_details where price>= :p1 and price <= :p2", nativeQuery = true)
//	List<Menu> fetchDetailsByPrice(@Param(value = "p1") Float price,@Param(value="p2") Float price2);

	// position paramter
	@Query(value = "select * from menu_details where price>= ?1 and price <= ?2", nativeQuery = true)
	List<Menu> fetchDetailsByPrice( Float price, Float price2);

	// JPQL query

	// position parameters //constructing our own objct
//	@Query(value = "select new com.marolix.set7.springbootdemo.entity.Menu(c.prodName) from Menu c where c.price>= ?1 and c.price <= ?2", nativeQuery = false)
//	List<Menu> fetchDetailsByPrice(Float price, Float price2);

	// named parameters
//	@Query( "select m from Menu m where m.price>= :p1 and m.price <= :p2")
//	List<Menu> fetchDetailsByPrice(@Param(value = "p1") Float price,@Param(value="p2") Float price2);

//@named query approach
	List<Menu> fetchWithNamedQuery(String name);
}
