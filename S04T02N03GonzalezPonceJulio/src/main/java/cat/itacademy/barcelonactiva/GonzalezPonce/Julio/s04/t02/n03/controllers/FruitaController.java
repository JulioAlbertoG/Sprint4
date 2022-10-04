package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.entity.Fruita;
import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.repository.FruitaRepository;
import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.services.SequenceGeneratorService;


@RestController
@RequestMapping("/fruita")
@CrossOrigin(origins = "http://localhost:8080")
public class FruitaController {

	@Autowired
	private FruitaRepository repository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@PostMapping("/add")
	public ResponseEntity<?> creaFruita(@RequestBody Fruita fruita){
	
		try {
			Fruita fruitaNova=new Fruita(fruita.getNom(),fruita.getQuantitatQuilos());
			fruitaNova.setId(sequenceGeneratorService.generateSequence("db_sequences"));
			repository.save(fruitaNova);
			return new ResponseEntity<>(fruitaNova.getNom() + " creada.",HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>("No se pudo crear la fruta", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> actualizar(@RequestBody Fruita fruitaDetalle,@PathVariable int id){
		Optional<Fruita> fruitaOptional = repository.findById(id);
		
		if (!fruitaOptional.isPresent()) {
			return new ResponseEntity<>("No se ha encontrado la fruta" ,HttpStatus.NOT_FOUND);
		}
		Fruita fruitaExist = fruitaOptional.get();
		fruitaExist.setNom(fruitaDetalle.getNom());
		fruitaExist.setQuantitatQuilos(fruitaDetalle.getQuantitatQuilos());
		
		return new ResponseEntity<>(repository.save(fruitaExist),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> borrar(@PathVariable int id){
		if(!repository.findById(id).isPresent()) {
			return new ResponseEntity<>("No se ha encontrado la fruta",HttpStatus.NOT_FOUND);
		}
		repository.deleteById(id);
		return new ResponseEntity<>("Se ha borrado el elemento correctamente",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id){
		Optional<Fruita> fruitaOptional = repository.findById(id);
		if(!fruitaOptional.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(fruitaOptional.get(),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<Fruita> getAll(){
		return repository.findAll();
	}
}
