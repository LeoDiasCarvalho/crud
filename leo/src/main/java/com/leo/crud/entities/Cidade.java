package com.leo.crud.entities;

import java.util.List;
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
@Table(name = "cidade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = true)
	private Long id;
	
	@Column(name = "nome", length = 40, nullable = true)
	private String nome;
	
	@Column(name = "estado", length = 20, nullable = true)
	private String estado;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Cidade_id")
	private List<Endereco> endercos;
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(estado, other.estado) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	@Override
	public int hashCode() {
		return Objects.hash(estado, id, nome);
	}

}
