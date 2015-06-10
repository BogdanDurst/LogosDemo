package com.logos.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.logos.demo.dao.BaseDao;

public abstract class BaseDaoImpl<E, N extends Number> implements BaseDao<E, N> {

	private Class<E> entityClass;

	public BaseDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@PersistenceContext(name = "logos")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional
	public E findById(N id) {
		try {
			return (E) entityManager
					.createQuery(
							"select e from " + entityClass.getSimpleName()
									+ " e where e.id = :id")
					.setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public void save(E entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	@Transactional
	public void remove(E entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	@Transactional
	public E update(E entity) {
		return entityManager.merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> findAll() {
		return entityManager.createQuery("from " + entityClass.getSimpleName())
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> findAllByPage(int count, int page) {
		
		int startFrom = page * count - count;
		return entityManager.createQuery("from " + entityClass.getSimpleName())
				.setFirstResult(startFrom).setMaxResults(count).getResultList();
	}

}
