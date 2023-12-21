package com.example.demo.redis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.redis.entity.Book;
import com.example.demo.redis.entity.Category;
import com.example.demo.redis.repo.BookRepository;
import com.example.demo.redis.repo.CategoryRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(3)
@RequiredArgsConstructor
@Slf4j
public class CreateBooksCmd implements CommandLineRunner {

    private final BookRepository bookRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            Faker faker = new Faker();
            Book book = Book.builder()
            .pageCount(100L)
            .thumbnail(faker.internet().image())
            .price(1000D)
            


            .build();
        }
    }

}
