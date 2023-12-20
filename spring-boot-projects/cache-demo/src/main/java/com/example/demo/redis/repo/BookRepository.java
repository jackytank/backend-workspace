package com.example.demo.redis.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.redis.entity.Book;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

}
