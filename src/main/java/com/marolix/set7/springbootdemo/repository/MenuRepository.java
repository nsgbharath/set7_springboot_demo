package com.marolix.set7.springbootdemo.repository;



import org.springframework.data.repository.CrudRepository;

import com.marolix.set7.springbootdemo.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {

}
