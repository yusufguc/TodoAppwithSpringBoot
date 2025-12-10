package com.ysfgc.controller;

import com.ysfgc.dto.TodosDto;
import com.ysfgc.dto.TodosDtoUI;
import com.ysfgc.model.RootEntity;
import com.ysfgc.utils.RestPageableEntity;
import com.ysfgc.utils.RestPageableRequest;

public interface TodosController {

	public RootEntity<TodosDto> addTodosDto(TodosDtoUI todoUI);
	
	public RootEntity<TodosDto> updateTodo(TodosDtoUI todo, Long id) ;
	
	public void deleteTodoById(Long id) ;
	
	public RootEntity<RestPageableEntity<TodosDto>>findAllPageable(RestPageableRequest pageable) ;

}

