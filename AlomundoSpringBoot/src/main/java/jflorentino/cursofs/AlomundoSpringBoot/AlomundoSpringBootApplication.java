package jflorentino.cursofs.AlomundoSpringBoot;

import java.util.List;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
@RestController
public class AlomundoSpringBootApplication {
	
	Pessoa p1 = new Pessoa(1L,"Larinha");
	Pessoa p2 = new Pessoa(2L,"Vó Driana");
	Pessoa p3 = new Pessoa(3L,"Vô João");

	public static void main(String[] args) {
		SpringApplication.run(AlomundoSpringBootApplication.class, args);
	}
	@GetMapping(value = "/alomundo")
	public String aloMundoStr() {
		return p1.toString();
	}
	@GetMapping(value = "/alomundojson")
	public ResponseEntity<Pessoa> aloMundoJson() {
		return ResponseEntity.ok().body(p1);
	}
	@GetMapping(value = "/alomundojsons")
	public ResponseEntity<List<Pessoa>> aloMundoJsons() {
		return ResponseEntity.ok().body(Arrays.asList(p1, p2, p3));
	}

}
