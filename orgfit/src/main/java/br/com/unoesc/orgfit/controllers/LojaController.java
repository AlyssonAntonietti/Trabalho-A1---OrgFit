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
import br.com.unoesc.orgfit.model.Loja;
import br.com.unoesc.orgfit.repository.LojaRepository;

@RestController
public class LojaController {

	@Autowired // injeção de dependência
	private LojaRepository lojaRepository;
	
	@PutMapping(value = "loja/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Loja loja) {
		if (loja.getId() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Loja store = lojaRepository.saveAndFlush(loja);
		return new ResponseEntity<Loja>(store, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "loja/delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		lojaRepository.deleteById(id);
		return new ResponseEntity<String>("Loja excluida com sucesso", HttpStatus.OK);
	}

	@PostMapping(value = "loja/salvar")
	@ResponseBody
	public ResponseEntity<Loja> salvar(@RequestBody Loja loja) {
		Loja store = lojaRepository.save(loja);
		return new ResponseEntity<Loja>(store, HttpStatus.CREATED);
	}

	@GetMapping(value = "loja/listartodos")
	@ResponseBody
	public ResponseEntity<List<Loja>> listar() {
		List<Loja> lojas = lojaRepository.findAll();
		return new ResponseEntity<List<Loja>>(lojas, HttpStatus.OK);
	}
}
