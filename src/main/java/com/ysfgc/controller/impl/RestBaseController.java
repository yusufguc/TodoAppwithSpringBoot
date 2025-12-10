package com.ysfgc.controller.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ysfgc.model.RootEntity;
import com.ysfgc.utils.PagerUtil;
import com.ysfgc.utils.RestPageableEntity;
import com.ysfgc.utils.RestPageableRequest;

public class RestBaseController {
	
	public <T> RootEntity<T> ok(T data){
		return RootEntity.ok(data);
	}
	
	public <T> RootEntity<T> error(String errorMessage){
		return RootEntity.error(errorMessage);
	}
	
	
	public Pageable toPageable(RestPageableRequest request) {
		return PagerUtil.toPageable(request);
	}
	
	public <T> RestPageableEntity<T> toPageableResponse(Page<?> page,List<T> content){
		return PagerUtil.toPageableResponse(page, content);
	}

}
