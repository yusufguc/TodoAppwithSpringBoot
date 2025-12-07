package com.ysfgc.service;

import com.ysfgc.dto.TodosDto;
import com.ysfgc.dto.TodosDtoUI;

public interface TodosService {

	public  TodosDto addTodosDto(TodosDtoUI todo) ;
	
	public TodosDto updateTodo(TodosDtoUI todo,Long id);
	
	public void deleteTodoById(Long id);
	
}
