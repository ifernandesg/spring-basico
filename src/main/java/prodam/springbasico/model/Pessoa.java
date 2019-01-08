package prodam.springbasico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="pessoa")
public class Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ApiModelProperty(notes = "Nome da pessoa",name="nome",required=true,value="test nome")
    @Column
    private String nome;
 
    @ApiModelProperty(notes = "Sobrenome da pessoa",name="sobrenome",required=true,value="test sobrenome")
    @Column
    private String sobrenome;
 
    @ApiModelProperty(notes = "Empresa da pessoa",name="empresa",required=true,value="test empresa")
    @Column
    private String empresa;
 
    public Pessoa() {}
    
    public Pessoa(String nome, String sobrenome, String empresa) {
        super();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.empresa = empresa;
    }
 
    public String getNome() {
        return nome;
    }
 
    public String getSobrenome() {
        return sobrenome;
    }
 
    public String getEmpresa() {
        return empresa;
    }
 
    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", sobrenome=" + sobrenome + ", empresa=" + empresa + "]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}   
    
}