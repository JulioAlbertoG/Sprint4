package cat.itacademy.barcelonactiva.GonzalezPonce.Julio.s04.t01.n02.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(value="/HelloWorld", method = RequestMethod.GET)
	public String saluda(@RequestParam(required = false, defaultValue = "UNKNOWN") String nom) {
		
		return "Hola, " + nom + ". Estàs executant un projecte Gradle";
	}
	
	@RequestMapping(value={"/HelloWorld2","/HelloWorld2/{nom}"}, method = RequestMethod.GET)
	public String saluda2(@PathVariable(name = "nom",required = false)String nom) {
		
		if (nom == null) {
			nom="UNKNOWN";
		}
		return "Hola, " + nom + ". Estàs executant un projecte Gradle";
	}
}
