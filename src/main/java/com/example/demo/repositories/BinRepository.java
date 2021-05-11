package com.example.demo.repositories;

import com.example.demo.entity.Bin;
import org.springframework.data.repository.CrudRepository;

public interface BinRepository extends CrudRepository<Bin, Long> {
}
