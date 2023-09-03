package com.leo.crud.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
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
	
	private Long id;
	private String nome;
	private String estado;
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
