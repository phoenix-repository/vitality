package com.myblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myblog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBlog extends BaseMapper<Blog> {
}
