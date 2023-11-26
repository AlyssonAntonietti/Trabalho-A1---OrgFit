package br.com.unoesc.orgfit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.unoesc.orgfit.model.Mercadoria;
import br.com.unoesc.orgfit.repository.MercadoriaRepository;


@RestController
public class MercadoriaController {

	@Autowired // injeção de dependência
	private MercadoriaRepository mercadoriaRepository;
	
	@GetMapping(value = "mercadoria/buscarpornome")
	@ResponseBody
	public ResponseEntity<List<Mercadoria>> bucarpornome(@RequestParam(name = "descricao") String descricao){
		List<Mercadoria> mercadoria = mercadoriaRepository.buscarPorNome(descricao.trim().toUpperCase());
		return new ResponseEntity<List<Mercadoria>>(mercadoria, HttpStatus.OK);
	}
	
	@PutMapping(value = "mercadoria/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Mercadoria mercadoria) {
		if (mercadoria.getId() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Mercadoria merc = mercadoriaRepository.saveAndFlush(mercadoria);
		return new ResponseEntity<Mercadoria>(merc, HttpStatus.OK);
	}

	@GetMapping(value = "mercadoria/buscarporid")
	@ResponseBody
	public ResponseEntity<Mercadoria> buscarid(@RequestParam(name = "id") Long id) {
		Mercadoria mercadoria = mercadoriaRepository.findById(id).get();
		return new ResponseEntity<Mercadoria>(mercadoria, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "mercadoria/delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long idmercadoria) {
		mercadoriaRepository.deleteById(idmercadoria);
		return new ResponseEntity<String>("Mercadoria excluida com sucesso", HttpStatus.OK);
	}

	@PostMapping(value = "mercadoria/salvar")
	@ResponseBody
	public ResponseEntity<Mercadoria> salvar(@RequestBody Mercadoria mercadoria) {
		Mercadoria merc = mercadoriaRepository.save(mercadoria);
		return new ResponseEntity<Mercadoria>(merc, HttpStatus.CREATED);
	}

	@GetMapping(value = "mercadoria/listartodos")
	@ResponseBody
	public ResponseEntity<List<Mercadoria>> listar() {
		List<Mercadoria> mercadorias = mercadoriaRepository.findAll();
		return new ResponseEntity<List<Mercadoria>>(mercadorias, HttpStatus.OK);
	}
}
