package cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.entity.Fruita;
import cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.repository.FruitaRepository;

@Service
public class FruitaServiceImpl implements FruitaService{
	
	@Autowired
	private FruitaRepository fruitaRepository;
//El transactional con readOnly indica que solo lectura y no modifica la BBDD
	@Override
	@Transactional(readOnly = true)
	public List<Fruita> findAll() {
		return fruitaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Fruita> findAll(Pageable pageable) {		
		return fruitaRepository.findAll(pageable);
	}
	

	@Override
	@Transactional(readOnly = true)
	public Optional<Fruita> findById(int id) {
		return fruitaRepository.findById(id);
	}
//Aqui no indicamos que es readOnly porque sí que realiza cambios
	@Override
	@Transactional
	public Fruita save(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		fruitaRepository.deleteById(id);
		
	}
	
	

}
