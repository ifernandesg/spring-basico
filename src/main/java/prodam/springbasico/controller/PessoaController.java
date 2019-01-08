package prodam.springbasico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import prodam.springbasico.model.Pessoa;
import prodam.springbasico.service.PessoaService;
 
@Api(value = "PessoaController", description = "REST Apis relacionados a Pessoa!")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
 
    @ApiOperation(value = "Listar as Pessoas", response = Iterable.class, tags = "getPessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
 
    
    @GetMapping(produces = "application/json")
    public List<Pessoa> getPessoas() {
        return service.listar();
    }
    
    @GetMapping(value="/{id}")
    public Pessoa getPessoa(@PathVariable("id") Long id) {
    	return service.getPessoaPorId(id);
    }
    
    @PostMapping(consumes = "application/json", produces = "application/json")
	public void createPessoa(@RequestBody Pessoa p){
		service.salvar(p);
		System.out.println(p);
	}
    
    @PutMapping(consumes = "application/json", produces = "application/json")
   	public void updatePessoa(@RequestBody Pessoa p){
   		service.salvar(p);
   		System.out.println(p);
   	}
 
    @DeleteMapping(value="/{id}")
    public void deletePessoa(@PathVariable("id") Long id) {
    	service.deletePessoaPorId(id);
    }
    
}