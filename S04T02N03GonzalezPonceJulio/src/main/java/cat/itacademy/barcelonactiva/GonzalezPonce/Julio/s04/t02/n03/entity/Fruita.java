package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t02.n03.entity;

import javax.persistence.Column;

import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="fruita")
public class Fruita {

	@Transient
    public static final String SEQUENCE_NAME = "fruita_sequence";
	
	@Id
	private int id;

	private String nom;
	
	private int quantitatQuilos;

	public Fruita(String nom2, int quantitatQuilos2) {
		this.nom = nom2;
		this.quantitatQuilos = quantitatQuilos2;
	}
	public Fruita() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nomString) {
		this.nom = nomString;
	}

	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}

	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}
	
	@Override
	public String toString() {
		return "Fruta: " + nom + ", Kilos: " + quantitatQuilos + "kg.";
		
	}
	
	
	
}
