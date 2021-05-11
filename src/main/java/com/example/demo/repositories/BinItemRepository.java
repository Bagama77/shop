package com.example.demo.repositories;

import com.example.demo.entity.BinItem;
import org.springframework.data.repository.CrudRepository;

public interface BinItemRepository extends CrudRepository<BinItem, Long> {
}
