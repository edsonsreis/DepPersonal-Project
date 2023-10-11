package com.devedson.userdept.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devedson.userdept.entities.User;
import com.devedson.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> findAll(){
		List<User> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
	    // Verifica se o usuário com o ID fornecido existe
	    if (repository.existsById(id)) {
	        repository.deleteById(id);
	        return new ResponseEntity<>("User with ID " + id + " deleted", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("User with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
	}
	
    // Endpoint para atualizar um usuário por ID
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> userOptional = repository.findById(id);

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setName(updatedUser.getName()); // Atualiza o nome do usuário com base nos dados fornecidos no corpo da solicitação
            existingUser.setEmail(updatedUser.getEmail()); // Atualiza o email do usuário com base nos dados fornecidos no corpo da solicitação
            // Atualize outros campos, se necessário

            User savedUser = repository.save(existingUser); // Salva as alterações no banco de dados
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Usuário não encontrado
        }
    }
	
}
