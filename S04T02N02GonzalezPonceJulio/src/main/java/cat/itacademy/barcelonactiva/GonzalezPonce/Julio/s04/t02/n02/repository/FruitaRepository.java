package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n02.entity.Fruita;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {

}
