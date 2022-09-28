package cat.itacademy.barcelonactiva.gonzalez.julio.s04.t02.n01.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//indicamos que es una entidad y le decimos que nos cree una tabla en BBD con el nombre fruites
@Entity
@Table(name = "fruites")
public class Fruita implements Serializable {
	
	private static final long serialVersionUID = -5745350345606163606L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nom")
	String nom;
	@Column(name = "quilos")
	int quantitatQuilos;
	
	public Fruita() {
		
	}
	public Fruita(String nom, int quantitatQuilos) {
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
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
	public void setNom(String nom) {
		this.nom = nom;
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
