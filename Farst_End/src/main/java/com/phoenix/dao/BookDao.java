package com.phoenix.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.phoenix.domain.Book;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
