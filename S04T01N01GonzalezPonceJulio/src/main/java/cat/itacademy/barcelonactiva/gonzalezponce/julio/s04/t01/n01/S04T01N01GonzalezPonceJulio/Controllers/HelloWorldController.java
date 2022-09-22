package cat.itacademy.barcelonactiva.gonzalezponce.julio.s04.t01.n01.S04T01N01GonzalezPonceJulio.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/HelloWorld")
	public String saluda(@RequestParam(required=false, defaultValue="UNKNOWN")String nom) {
		return "Hola, " + nom + ". Estàs executant un projecte Maven.";
	}
	
	@GetMapping(value={"/HelloWorld2/{nom}","HelloWorld2"})
	public String saluda2(@PathVariable(name="nom", required=false)String nom) {
		nom = nom==null? "UNKNOWN":nom;
		return "Hola, " + nom + ". Estàs executant un projecte Maven.";
	}
	
	
}
