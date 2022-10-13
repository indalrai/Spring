package com.hotelmanagement.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.Visitor;

public interface VisitorReposatory extends JpaRepository<Visitor, Long> {

}
