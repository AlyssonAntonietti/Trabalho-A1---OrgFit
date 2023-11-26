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
import br.com.unoesc.orgfit.model.Cidade;
import br.com.unoesc.orgfit.repository.CidadeRepository;

@RestController
public class CidadeController {

	@Autowired // injeção de dependência
	private CidadeRepository cidadeRepository;
	
	@PutMapping(value = "cidade/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Cidade cidade) {
		if (cidade.getId() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Cidade city = cidadeRepository.saveAndFlush(cidade);
		return new ResponseEntity<Cidade>(city, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "cidade/delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		cidadeRepository.deleteById(id);
		return new ResponseEntity<String>("Cidade excluida com sucesso", HttpStatus.OK);
	}

	@PostMapping(value = "cidade/salvar")
	@ResponseBody
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade) {
		Cidade city = cidadeRepository.save(cidade);
		return new ResponseEntity<Cidade>(city, HttpStatus.CREATED);
	}

	@GetMapping(value = "cidade/listartodos")
	@ResponseBody
	public ResponseEntity<List<Cidade>> listar() {
		List<Cidade> cidades = cidadeRepository.findAll();
		return new ResponseEntity<List<Cidade>>(cidades, HttpStatus.OK);
	}
}


