package com.senso.gate.sensoApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.senso.gate.sensoApi.model.Contact;
import com.senso.gate.sensoApi.repository.ContactRepository;

@RestController
@RequestMapping({"api/v1/contacts"})
public class ContactController {
	private ContactRepository repository;

	ContactController(ContactRepository contactRepository) {
       this.repository = contactRepository;
	}
	
	@GetMapping
	public List<?> findAll(){
	   return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id){
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Contact> create(@RequestBody Contact contact){
		Contact contato = repository.save(contact);
		return new ResponseEntity<>(contato,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Contact> update(@PathVariable("id") long id,
	                                      @RequestBody Contact contact) {
	   return repository.findById(id)
	           .map(record -> {
	               
	        	   record.setName(contact.getName());
	               record.setEmail(contact.getEmail());
	               record.setPhone(contact.getPhone());
	               
	               Contact updated = repository.save(record);
	               
	               return ResponseEntity.ok().body(updated);
	               
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable long id) {
	   return repository.findById(id)
	           .map(record -> {
	               repository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
