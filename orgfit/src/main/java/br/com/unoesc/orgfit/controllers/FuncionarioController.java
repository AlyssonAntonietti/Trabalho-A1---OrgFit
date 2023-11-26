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
import br.com.unoesc.orgfit.model.Funcionario;
import br.com.unoesc.orgfit.repository.FuncionarioRepository;

@RestController
public class FuncionarioController {

	@Autowired // injeção de dependência
	private FuncionarioRepository funcionarioRepository;
	
	@PutMapping(value = "funcionario/atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Funcionario funcionario) {
		if (funcionario.getId() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Funcionario employee = funcionarioRepository.saveAndFlush(funcionario);
		return new ResponseEntity<Funcionario>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "funcionario/delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		funcionarioRepository.deleteById(id);
		return new ResponseEntity<String>("Funcionário excluido com sucesso", HttpStatus.OK);
	}

	@PostMapping(value = "funcionario/salvar")
	@ResponseBody
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
		Funcionario employee = funcionarioRepository.save(funcionario);
		return new ResponseEntity<Funcionario>(employee, HttpStatus.CREATED);
	}

	@GetMapping(value = "funcionario/listartodos")
	@ResponseBody
	public ResponseEntity<List<Funcionario>> listar() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
	}
}
