package com.ysfgc.controller;

import com.ysfgc.dto.TodosDto;
import com.ysfgc.dto.TodosDtoUI;

public interface TodosController {

	public TodosDto addTodosDto(TodosDtoUI todoUI);
	
	public TodosDto updateTodo(TodosDtoUI todo, Long id) ;
	
	public void deleteTodoById(Long id) ;
}
