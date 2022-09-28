package cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.entity.Fruita;
import cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.repository.FruitaRepository;
import cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.services.FruitaService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@EnableWebMvc
@RequestMapping("/fruita")
public class FruitaController {

	@Autowired
	private FruitaService fruitaService;
	
	//Crea una nueva fruta
	
	@PostMapping("/add")
	public ResponseEntity<?> create(@RequestBody Fruita fruita){
		//return ResponseEntity.status(HttpStatus.CREATED).body(fruitaService.save(fruita));
		
		try {
			Fruita _fruita = fruitaService.save(new Fruita(fruita.getNom(),fruita.getQuantitatQuilos()));
			return new ResponseEntity<>(_fruita.getNom() + " creada", HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>("No se pudo crear la fruta", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		
	}
	
	//Obtenemos una fruta
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id){
		Optional<Fruita> oFruita = fruitaService.findById(id);
		if(!oFruita.isPresent()) {
			//Si no lo encuentra responde con un error 404 not found
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(oFruita.get(),HttpStatus.OK);
		
	}
	
	//update una fruta
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Fruita fruitaDetails, @PathVariable int id){
		Optional<Fruita> oFruita = fruitaService.findById(id);
		
		if(!oFruita.isPresent()) {
			return new ResponseEntity<>("No se ha encontrado la fruta" ,HttpStatus.NOT_FOUND);
		}
		Fruita _Fruita = oFruita.get();
		_Fruita.setNom(fruitaDetails.getNom());
		_Fruita.setQuantitatQuilos(fruitaDetails.getQuantitatQuilos());
		
		return new ResponseEntity<>(fruitaService.save(_Fruita),HttpStatus.OK);
		}
	
	//Borrar una fruita
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		
		if(!fruitaService.findById(id).isPresent()) {
			return new ResponseEntity<>("No se ha encontrado la fruta",HttpStatus.NOT_FOUND);
		}
		fruitaService.deleteById(id);
		return new ResponseEntity<>("Se ha borrado el elemento correctamente",HttpStatus.NO_CONTENT);
	}
	
	//Traer a todas las frutas
	@GetMapping("getAll")
	public List<Fruita> getAll(){
		
		return fruitaService.findAll();
		
	}
}
