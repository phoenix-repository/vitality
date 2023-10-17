package com.phoenix.controller;

import com.phoenix.controller.utils.ResultVO;
import com.phoenix.domain.Book;
import com.phoenix.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResultVO getALL(){
        return  new ResultVO(true , bookService.getAll());
    }

    @GetMapping("{id}")
    public ResultVO getById(@PathVariable("id") Integer id){
        return new ResultVO(true , bookService.getById(id));
    }

    @PutMapping
    public ResultVO update(@RequestBody Book book){
        return new ResultVO(bookService.update(book));
    }

    @PostMapping
    public ResultVO add(@RequestBody Book book) {
        return new ResultVO(bookService.save(book));
    }

    @DeleteMapping("{id}")
    public ResultVO delete(@PathVariable("id") Integer id) {
        return new ResultVO(bookService.delete(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public ResultVO getPage(@PathVariable  int currentPage, @PathVariable int pageSize){
//        return new ResultVO(true , bookService.getPage(currentPage, pageSize));
//    }


  @GetMapping({"{currentPage}/{pageSize}"})
    public ResultVO getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book){
        return new ResultVO(true , bookService.getPage(currentPage, pageSize, book));
  }


}

