package com.example.demo.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.redis.entity.Book;
import com.example.demo.redis.entity.Category;
import com.example.demo.redis.repo.BookRepository;
import com.example.demo.redis.repo.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping("")
    public Iterable<Book> all() {
        return bookRepository.findAll();
    }

    @GetMapping("/categories")
    public Iterable<Category> categories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        var bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()) {
            return bookOpt.get();
        }
        return null;
    }

}
