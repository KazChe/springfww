package com.kc.springwebapp.repositories;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
