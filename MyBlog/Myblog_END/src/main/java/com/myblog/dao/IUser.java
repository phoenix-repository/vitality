package com.myblog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myblog.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUser extends BaseMapper<User> {

}
