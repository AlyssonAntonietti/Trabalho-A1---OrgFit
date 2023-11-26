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
import br.com.unoesc.orgfit.model.VendaMercadoria;
import br.com.unoesc.orgfit.repository.VendaMercadoriaRepository;

@RestController
public class VendaMercadoriaController {

	@Autowired // injeção de dependência
	private VendaMercadoriaRepository vendaMercadoriaRepository;
	
	@PutMapping(value = "vendaMercadoria/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody VendaMercadoria vendaMercadoria) {
		if (vendaMercadoria.getId() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		VendaMercadoria sale = vendaMercadoriaRepository.saveAndFlush(vendaMercadoria);
		return new ResponseEntity<VendaMercadoria>(sale, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "vendaMercadoria/delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		vendaMercadoriaRepository.deleteById(id);
		return new ResponseEntity<String>("Venda da Mercadoria excluida com sucesso", HttpStatus.OK);
	}

	@PostMapping(value = "vendaMercadoria/salvar")
	@ResponseBody
	public ResponseEntity<VendaMercadoria> salvar(@RequestBody VendaMercadoria vendaMercadoria) {
		VendaMercadoria sale = vendaMercadoriaRepository.save(vendaMercadoria);
		return new ResponseEntity<VendaMercadoria>(sale, HttpStatus.CREATED);
	}

	@GetMapping(value = "vendaMercadoria/listartodos")
	@ResponseBody
	public ResponseEntity<List<VendaMercadoria>> listar() {
		List<VendaMercadoria> vendaMercadorias = vendaMercadoriaRepository.findAll();
		return new ResponseEntity<List<VendaMercadoria>>(vendaMercadorias, HttpStatus.OK);
	}
}