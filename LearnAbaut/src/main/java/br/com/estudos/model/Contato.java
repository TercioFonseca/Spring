package br.com.estudos.model;

import javax.persistence.*;

@Entity

@Table(name = "contato")

public class Contato {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")

	private Long id;

	private String nome;

	private String email;

	private String telefone;

	// getters and setters

}