package com.kc.springwebapp.repositories;

import com.kc.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Long> {

}
