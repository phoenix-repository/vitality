package com.phoenix.service;

import com.phoenix.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {


    @Autowired
    private BookService bookService;

    @Test
    void
    testGetBookList() {
        // 获取书籍列表
        System.out.println("测试" + bookService.getAll());
    }

    @Test
    void testGetBookById() {
        System.out.println(bookService.getById(1));
    }
    @Test
    void testUpdat() {
        Book book = new Book();
        book.setId(2);
        System.out.println(bookService.update(book));
    }
    @Test
    void testDeleteById(){
        bookService.delete(1);
    }

    @Test
    void testBookSave(){
        Book book = new Book();
        book.setId(2);
        bookService.save(book);
    }

}
