package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="db_sequences")
@Component
public class DbSequence {
	
	@Id
	private String id;
	
	private int seq;
	
	public DbSequence() {}
	
	public DbSequence(String id,int seq) {
		this.id=id;
		this.seq=seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	

}
