package com.ysfgc.controller;

import com.ysfgc.dto.TodosDto;
import com.ysfgc.dto.TodosDtoUI;
import com.ysfgc.model.RootEntity;

public interface TodosController {

	public RootEntity<TodosDto> addTodosDto(TodosDtoUI todoUI);
	
	public RootEntity<TodosDto> updateTodo(TodosDtoUI todo, Long id) ;
	
	public void deleteTodoById(Long id) ;
}
