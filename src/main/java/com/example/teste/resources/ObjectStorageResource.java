package com.example.teste.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.models.ObjectStorage;
import com.example.teste.repository.ObjectStorageRepository;

@RestController
@RequestMapping("/objectStorage")
public class ObjectStorageResource {
	@Autowired
	ObjectStorageRepository objectRep;
	@GetMapping("/objects")
	public List<ObjectStorage> Mostrar(){
		return objectRep.findAll();
	}
	@GetMapping("/object/descricao/{description}")
	public List<ObjectStorage> MostrarPorDescricao(@PathVariable(value="description") String description){
		return objectRep.findByDescription(description);
	}
	@GetMapping("/object/id/{id}")
	public ObjectStorage MostrarPorId(@PathVariable(value="id") int id){
		return objectRep.findById(id);
	}
	@PostMapping("/objects")
	public ObjectStorage Adicionar(@RequestBody Object object) throws IOException {
		return objectRep.save(new ObjectStorage(object));
	}
}
