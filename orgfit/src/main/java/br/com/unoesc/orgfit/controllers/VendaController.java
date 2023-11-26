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
import br.com.unoesc.orgfit.model.Venda;
import br.com.unoesc.orgfit.repository.VendaRepository;

@RestController
public class VendaController {

	@Autowired // injeção de dependência
	private VendaRepository vendaRepository;
	
	@PutMapping(value = "venda/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Venda venda) {
		if (venda.getId() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Venda sale = vendaRepository.saveAndFlush(venda);
		return new ResponseEntity<Venda>(sale, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "venda/delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		vendaRepository.deleteById(id);
		return new ResponseEntity<String>("Venda excluida com sucesso", HttpStatus.OK);
	}

	@PostMapping(value = "venda/salvar")
	@ResponseBody
	public ResponseEntity<Venda> salvar(@RequestBody Venda venda) {
		Venda sale = vendaRepository.save(venda);
		return new ResponseEntity<Venda>(sale, HttpStatus.CREATED);
	}

	@GetMapping(value = "venda/listartodos")
	@ResponseBody
	public ResponseEntity<List<Venda>> listar() {
		List<Venda> vendas = vendaRepository.findAll();
		return new ResponseEntity<List<Venda>>(vendas, HttpStatus.OK);
	}
}
