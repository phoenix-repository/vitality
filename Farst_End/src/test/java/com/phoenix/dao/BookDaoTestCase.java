package com.phoenix.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phoenix.domain.Book;
import com.phoenix.service.Impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookServiceImpl bookService;
    
     @Test()
       void testById(){
         System.out.println(bookDao.selectById(1));
     }


    @Test
    void testGetPage(){
        IPage page = new Page(1,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetSelectPage(){
        Book book = new Book();
        IPage page = new Page(1,5);
        book.setName("as");
        bookService.getPage((int) page.getCurrent(), (int) page.getSize(),book);
        System.out.println(page.getPages());
    }
}
