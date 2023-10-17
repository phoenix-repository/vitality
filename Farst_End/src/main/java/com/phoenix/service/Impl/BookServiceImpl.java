package com.phoenix.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phoenix.dao.BookDao;
import com.phoenix.domain.Book;
import com.phoenix.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{



    @Autowired
    private BookDao bookDao;
    @Override
    public Boolean save(Book book) {
      return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById( book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById( id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null );
    }

    @Override  
    public IPage<Book> getPage(Integer pageNum, Integer pageSize) {
        IPage<Book> page = new Page(pageNum, pageSize);
        return bookDao.selectPage(page, null);
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize, Book queryBook) {
        IPage page = new Page (currentPage,pageSize);
        LambdaQueryWrapper<Book> iqw = new LambdaQueryWrapper<Book>();
        iqw.like(Strings.isNotEmpty (queryBook.getName()), Book::getName, queryBook.getName()) ;
        iqw.like(Strings.isNotEmpty (queryBook.getType()), Book::getType, queryBook.getType());
        iqw.like(Strings.isNotEmpty(queryBook.getDescription()),
                Book::getDescription, queryBook.getDescription());
        return bookDao.selectPage (page, iqw);

    }
}
