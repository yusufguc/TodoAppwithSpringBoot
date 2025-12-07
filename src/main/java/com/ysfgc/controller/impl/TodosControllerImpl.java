package com.ysfgc.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysfgc.controller.TodosController;
import com.ysfgc.dto.TodosDto;
import com.ysfgc.dto.TodosDtoUI;
import com.ysfgc.service.TodosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
public class TodosControllerImpl implements TodosController {

	@Autowired
	private TodosService todosService;
	
	@PostMapping()
	@Override
	public TodosDto addTodosDto(@Valid @RequestBody TodosDtoUI todoUI) {
		
		return todosService.addTodosDto(todoUI);
	}

	
	@PutMapping("/{id}")
	@Override
	public TodosDto updateTodo(@Valid @RequestBody TodosDtoUI todo, @PathVariable("id")Long id) {
	
		return todosService.updateTodo(todo, id);
	}


	@DeleteMapping("/{id}")
	@Override
	public void deleteTodoById(@PathVariable("id")Long id) {
		todosService.deleteTodoById(id);
	}
	
	

}
