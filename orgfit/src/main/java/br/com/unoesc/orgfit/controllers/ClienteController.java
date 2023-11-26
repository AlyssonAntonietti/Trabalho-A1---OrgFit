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
import br.com.unoesc.orgfit.model.Cliente;
import br.com.unoesc.orgfit.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired // injeção de dependência
	private ClienteRepository clienteRepository;
	
	@PutMapping(value = "cliente/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Cliente cliente) {
		if (cliente.getId() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Cliente client = clienteRepository.saveAndFlush(cliente);
		return new ResponseEntity<Cliente>(client, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "cliente/delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		clienteRepository.deleteById(id);
		return new ResponseEntity<String>("Cliente excluido com sucesso", HttpStatus.OK);
	}

	@PostMapping(value = "cliente/salvar")
	@ResponseBody
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		Cliente client = clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(client, HttpStatus.CREATED);
	}

	@GetMapping(value = "cliente/listartodos")
	@ResponseBody
	public ResponseEntity<List<Cliente>> lista() {
		List<Cliente> clientes = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
}
