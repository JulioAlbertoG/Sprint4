package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.entity.Fruita;

@Repository
public interface FruitaRepository extends MongoRepository<Fruita, Integer> {

}
