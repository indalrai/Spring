package com.hotelmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.model.Visitor;
import com.hotelmanagement.service.VisitorService;

@RestController
public class VisitorController {

	@Autowired
	public VisitorService visitorService;

	@PostMapping("/added-visitor")
	public ResponseEntity<Visitor> saveVisitor(@Valid @RequestBody Visitor visitor) {
	
		return new ResponseEntity<Visitor>(visitorService.saveVisitor(visitor), HttpStatus.CREATED);
	}

	@GetMapping("/total-visitors")
	public List<Visitor> getAllVisitor() {
		return visitorService.getAllVisitor();
	}

	@GetMapping("{id}")
	public ResponseEntity<Visitor> getVisitorById(@PathVariable("id") long id) throws Exception {
		return new ResponseEntity<Visitor>(visitorService.getVisitorById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Visitor> updateVisitor(@PathVariable("id") long id, @RequestBody Visitor visitor)
			throws Exception {
		return new ResponseEntity<Visitor>(visitorService.updateVisitor(visitor, id), HttpStatus.OK);
	}

	// delete
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVisitor(@PathVariable("id") long id) throws Exception {
		visitorService.deleteVisitor(id);

		return new ResponseEntity<String>("DELETED SUCCESSFULL !", HttpStatus.OK);
	}

}
