package com.phoenix.controller.utils;

import lombok.Data;

@Data
public class ResultVO  {

	private Boolean flag;//返回信息
	private Object data;
	private  String msg;
 
    public  ResultVO() {}
	public ResultVO(Boolean flag) {
		this.flag = flag;
	}
	public ResultVO(Boolean flag, Object data){
		this.flag = flag;
		this.data = data;
	}
	public ResultVO(String msg){
		this.flag = false;
		this.data = null;
		this.msg = msg;
	}

}
