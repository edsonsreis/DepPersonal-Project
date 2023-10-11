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

import com.devedson.userdept.entities.Department;
import com.devedson.userdept.repositories.DepartmentRepository;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository repository;
	
	@GetMapping
	public List<Department> findAll(){
		List<Department> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Department findById(@PathVariable Long id) {
		Department result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Department insert(@RequestBody Department department) {
		Department result = repository.save(department);
		return result;
	}
	
	
	 @DeleteMapping(value = "/{id}")
	    public ResponseEntity<String> deleteById(@PathVariable Long id) {
		 
		    // Caso tenha usuário dentro do departamento, não irá permitir excluir
	        if (repository.existsById(id)) {
	            repository.deleteById(id);
	            return new ResponseEntity<>("Department with ID " + id + " deleted", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Department with ID " + id + " not found", HttpStatus.NOT_FOUND);
	        }
	    }

	    // Endpoint para atualizar um departamento por ID
	    @PutMapping(value = "/{id}")
	    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
	        Optional<Department> departmentOptional = repository.findById(id);

	        if (departmentOptional.isPresent()) {
	            Department existingDepartment = departmentOptional.get();
	            existingDepartment.setName(updatedDepartment.getName()); // Atualiza o nome do departamento com base nos dados fornecidos no corpo da solicitação
	            Department savedDepartment = repository.save(existingDepartment); // Salva as alterações no banco de dados
	            return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Departamento não encontrado
	        }
	    }
	 
}
