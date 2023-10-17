package com.phoenix.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbi_book")
public class Book {
    private Integer id;
    private String name;
    private String type;
    private String description;
}
