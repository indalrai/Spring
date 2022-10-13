package com.hotelmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.exception.ResourceNotFoundException;
import com.hotelmanagement.model.Visitor;
import com.hotelmanagement.reposatory.VisitorReposatory;
import com.hotelmanagement.service.VisitorService;
@Service
public class VisitorServiceImpl implements VisitorService {
 @Autowired
	public VisitorReposatory visitorRepository;

	@Override
	public Visitor saveVisitor(Visitor visitor) {
		return visitorRepository.save(visitor);
	}

	@Override
	public List<Visitor> getAllVisitor() {

		return visitorRepository.findAll();
	}

	@Override
	public Visitor getVisitorById(long id) throws ResourceNotFoundException {

		Optional<Visitor> visitor = visitorRepository.findById(null);

		if (visitor.isPresent()) {
			return visitor.get();
		} else {
			throw new ResourceNotFoundException("ID NOT FOUND PLEASE CHECK");
		}
	}

	@Override
	public Visitor updateVisitor(Visitor visitor, long id) throws ResourceNotFoundException {

		Visitor existingVisitor = visitorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID NOT FOUND"));

		existingVisitor.setFirstName(visitor.getFirstName());
		existingVisitor.setLastName(visitor.getLastName());
		existingVisitor.setProducts(visitor.getProducts());
		existingVisitor.setMobileNumber(visitor.getMobileNumber());
		existingVisitor.setEmailId(visitor.getEmailId());
		visitorRepository.save(existingVisitor);
		return existingVisitor;
	}

	@Override
	public void deleteVisitor(long id) throws ResourceNotFoundException {

		visitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NOT FOUND PLEASE CHECK"));

		visitorRepository.deleteById(id);

	}

}
