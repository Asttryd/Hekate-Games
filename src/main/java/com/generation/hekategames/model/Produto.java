package com.generation.hekategames.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	//Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Nome
	@NotBlank(message = "O nome do jogo é obrigatório!")
	@Size(min = 5, max = 255, message = "O nome do jogo deve ter entre 5 e 255 caracteres")
	private String nome;
	
	//Descrição
	@NotBlank (message = "A descrição do jogo é obrigatória!")
	@Size(min = 5, max = 255, message = "A descrição do jogo deve ter entre 5 e 255 caracteres")
	private String descricao;
	
	//Preço
	@DecimalMin(value = "1.00", message = "O preço mínimo deve ser 1.00")
	@Digits(integer = 4, fraction = 2, message = "O preço deve ter no máximo 6 dígitos inteiros e 2 decimais")
	private BigDecimal preco;
	
	//Data de lançamento na loja
	@UpdateTimestamp
	private LocalDateTime data;
	
	//Vendas
	private Long vendas;
	
	@ManyToOne
	@JsonIgnoreProperties("Produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getVendas() {
		return vendas;
	}

	public void setVendas(Long vendas) {
		this.vendas = vendas;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
