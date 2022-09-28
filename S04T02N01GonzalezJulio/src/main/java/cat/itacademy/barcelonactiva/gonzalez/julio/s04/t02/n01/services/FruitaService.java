package cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.services;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.entity.Fruita;

public interface FruitaService {
	
	public List<Fruita> findAll();
	
	
	//Devuelve páginas si hay muchos elementos dentro va bien
	public Page<Fruita> findAll(Pageable pageable);
	
	public Optional<Fruita> findById(int id);
	
	public Fruita save(Fruita fruita);
	
	public void deleteById(int id);

}
