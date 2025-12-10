package com.ysfgc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ysfgc.dto.TodosDto;
import com.ysfgc.dto.TodosDtoUI;
import com.ysfgc.model.Todos;

public interface TodosService {

	public  TodosDto addTodosDto(TodosDtoUI todo) ;
	
	public TodosDto updateTodo(TodosDtoUI todo,Long id);
	
	public void deleteTodoById(Long id);
	
	Page<Todos> findAllPageable(Pageable pageable);

	public List<TodosDto> toDtoList(List<Todos> todosList);

	
}
