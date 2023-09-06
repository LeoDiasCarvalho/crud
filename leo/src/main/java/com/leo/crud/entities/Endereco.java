package com.leo.crud.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Long id;
	
	@Column(name = "logradouro", length = 45)
	private String logradouro;
	
	@Column(name = "bairro", length = 20)
	private String bairro;
	
	@Column(name = "cep", length = 10)
	private String cep;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Cidade_id")
	private Cidade cidade;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep) && Objects.equals(id, other.id)
				&& Objects.equals(logradouro, other.logradouro);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, id, logradouro);
	}

	
}
