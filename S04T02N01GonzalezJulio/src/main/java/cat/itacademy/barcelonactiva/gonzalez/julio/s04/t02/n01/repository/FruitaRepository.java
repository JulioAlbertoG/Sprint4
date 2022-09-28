package cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.entity.Fruita;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer>{

	//List<Fruita> findByNom(String nom);
	
}
