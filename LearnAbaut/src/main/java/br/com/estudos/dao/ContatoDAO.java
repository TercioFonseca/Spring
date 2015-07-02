package br.com.estudos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.estudos.model.Contato;

@Repository("contatoDao")

public class ContatoDAO {

	protected EntityManager entityManager;

	public ContatoDAO() {

	}

	@PersistenceContext

	public void setEntityManager(EntityManager entityManager) {

		this.entityManager = entityManager;

	}

	public Contato find(Long id) {

		return entityManager.find(Contato.class, id);

	}

	@Transactional

	public void persist(Contato contato) {

		entityManager.persist(contato);

	}

	@Transactional

	public void merge(Contato contato) {

		entityManager.merge(contato);

	}

	@Transactional

	public void remove(Contato contato) {

		entityManager.remove(contato);

	}

	@SuppressWarnings("unchecked")

	public List<Contato> findAll() {

		return entityManager.createQuery("SELECT c FROM Contato c").getResultList();

	}

}