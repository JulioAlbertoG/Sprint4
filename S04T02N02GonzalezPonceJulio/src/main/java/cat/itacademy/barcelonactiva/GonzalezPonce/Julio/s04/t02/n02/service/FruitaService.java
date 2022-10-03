package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n02.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n02.entity.Fruita;
import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n02.repository.FruitaRepository;

@Service
public class FruitaService {

	@Autowired
	FruitaRepository fruitaRepository;
	
	
	@Transactional(readOnly = true)
	public List<Fruita> listaFruitas(){
		return fruitaRepository.findAll();
	}
	@Transactional(readOnly = true)
	public Optional<Fruita> unaFruita(int id) {
		return fruitaRepository.findById(id);
	}
	
	@Transactional
	public Fruita add(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}
	
	@Transactional
	public void borrar(int id) {
		fruitaRepository.deleteById(null);
	}
	

}
