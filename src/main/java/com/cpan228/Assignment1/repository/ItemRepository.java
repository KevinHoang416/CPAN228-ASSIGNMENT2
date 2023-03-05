package com.cpan228.Assignment1.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpan228.Assignment1.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
