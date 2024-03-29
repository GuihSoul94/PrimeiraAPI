package br.com.api.nova.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.api.nova.entidade.Cep;
import br.com.api.nova.entidade.Contact;
import br.com.api.nova.entidade.Pokemon;
import br.com.api.nova.services.ContactServices;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PrimeiroController {

	@Autowired
	private ContactServices servico;

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/ola")
	public ResponseEntity bemVindo() {
		return ResponseEntity.ok("Olá!");
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/contatos")
	public ResponseEntity listarContatos() {
		List<Contact> listaResultado = servico.listarContatos();
		return ResponseEntity.ok(listaResultado);
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@PostMapping(value = "/contatos/inserir")
	public ResponseEntity InserirContato(@RequestBody Contact contato) {
		Contact cont = new Contact();
		cont = servico.adicionarContato(contato);
		return ResponseEntity.ok("Contato inserido com sucesso!" + contato);
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@GetMapping(value = "/pokemon/{nome}")
	public ResponseEntity buscarPokemon(@PathVariable String nome) throws MalformedURLException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		try {
			ResponseEntity<Pokemon> result = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/" + nome,HttpMethod.GET,entity, Pokemon.class);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Erro na consulta! Pokemon inexistente ou inválido!");
		}

	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/cep/{cep}", produces = "application/JSON")
	public ResponseEntity buscarCEP(@PathVariable String cep) {
		String url = "http://viacep.com.br/ws/" + cep + "/json";
		RestTemplate template = new RestTemplate();
		Cep resultado = template.getForObject(url, Cep.class);
		return ResponseEntity.ok(resultado);

	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/contatos/{id}")
	public ResponseEntity encontrarPorId(@PathVariable int id) {
		Optional<Contact> opcional = null;
		opcional = servico.encontrarPorId(id);
		return ResponseEntity.ok(opcional);

	}

	@SuppressWarnings("rawtypes")
	@PutMapping(value = "/contatos/editar")
	public ResponseEntity EditarContato(@RequestBody Contact contato) {
		Contact cont = new Contact();
		cont = servico.editarContato(contato);
		return ResponseEntity.ok("Contato editado com sucesso!" + cont);
	}

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/contatos/contador")
	public ResponseEntity listarQuantidade() {
		int contador = 0;
		contador = servico.totalResultado();

		return ResponseEntity.ok(contador);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "/contatos/{id}")
	public ResponseEntity deletarPorId(@PathVariable int id) {
		try {
			servico.deletarContato(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok("Contato " + id + " Deletado com sucesso!");
	}

}
