package com.dextratraining.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.dextratraing.jpa.EntityManagerUtil;

public class GenericService<T> {

	private Class<T> targetClass;

	public GenericService(Class<T> targetClass) {
		this.targetClass = targetClass;

	}

	public void salvar(T entidade) {

		EntityManager em = EntityManagerUtil.criarEntityManager();

		try {
			em.getTransaction().begin();

			em.persist(entidade);

			// código considerado como bloco.

			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			em.close();
		}

	}

	public T buscarPorId(Long id) {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		try {
			return em.find(targetClass, id);
		} finally {
			em.close();
		}

	}

	public List<T> buscarTodos() {
		EntityManager em = EntityManagerUtil.criarEntityManager();
		try {
			String jpql = "SELECT e FROM " + targetClass.getSimpleName() + " e";
			TypedQuery<T> query = em.createQuery(jpql, targetClass);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}
