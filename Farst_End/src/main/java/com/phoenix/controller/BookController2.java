package com.phoenix.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.phoenix.domain.Book;
import com.phoenix.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController(这个没有考虑到与前端交互的数据结构)
//@RequestMapping("/books")
public class BookController2 {
    
     @Autowired
    private BookService bookService;

     @GetMapping
    public List<Book> getALL(){
         return bookService.getAll();
     }

    @GetMapping("{id}")
    public Book getById(@PathVariable("id") Integer id){
        return bookService.getById(id);
     }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.update(book);
    }

    @PostMapping
    public Boolean add(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
         return bookService.delete(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable  int currentPage, @PathVariable int pageSize){
        return bookService.getPage(currentPage, pageSize);
    }

}

