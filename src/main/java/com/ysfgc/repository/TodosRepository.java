package com.ysfgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ysfgc.model.Todos;

@Repository
public interface TodosRepository  extends JpaRepository<Todos,Long>{

}
