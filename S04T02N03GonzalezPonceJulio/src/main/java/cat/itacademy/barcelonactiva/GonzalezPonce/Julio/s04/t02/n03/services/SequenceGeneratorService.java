package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.services;


import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.entity.DbSequence;

@Service
public class SequenceGeneratorService {
	
	@Autowired
	private MongoOperations mongoOperations;

	public int generateSequence(String seqName) {
		DbSequence counterDbSequence = mongoOperations.findAndModify(
				query(where("id").is(seqName)), 
				new Update().inc("seq",1), 
				options().returnNew(true).upsert(true),
				DbSequence.class);
		
		return counterDbSequence.getSeq();
	}
}
