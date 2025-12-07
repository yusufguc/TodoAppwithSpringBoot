package com.ysfgc.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysfgc.dto.TodosDto;
import com.ysfgc.dto.TodosDtoUI;
import com.ysfgc.model.Todos;
import com.ysfgc.repository.TodosRepository;
import com.ysfgc.service.TodosService;

@Service
public class TodosServiceImpl implements TodosService{
	
	@Autowired
	private TodosRepository todosRepository;

	@Override
	public TodosDto addTodosDto(TodosDtoUI todoUI) {
		
		Todos todos = new Todos();
		TodosDto todosDto=new TodosDto();
		BeanUtils.copyProperties(todoUI, todos);
	
		Todos savedTodos = todosRepository.save(todos);
		BeanUtils.copyProperties(savedTodos, todosDto);
		
		return todosDto;
	}
	

	@Override
	public TodosDto updateTodo(TodosDtoUI todo, Long id) {
		
		Optional<Todos> optional = todosRepository.findById(id);
		if (optional.isEmpty()) {
			return null; // exception will be added later
		}
		Todos  todoDb= optional.get();
		todoDb.setTitle(todo.getTitle());
		todoDb.setDescription(todo.getDescription());
		Todos saveTodos = todosRepository.save(todoDb);
		
		TodosDto todosDto=new TodosDto();
		BeanUtils.copyProperties(saveTodos, todosDto);
		
		return todosDto;
	}


	@Override
	public void deleteTodoById(Long id) {
		if ( !todosRepository.existsById(id)) {
			return ;// exception will be added later

		}
		
		todosRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
