package fr.eql.ai108.jpa.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDao<T> implements GenericIDao<T> {
	
	private static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("CatPU");

	@Override
	public T add(T t) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return t;
	}

	@Override
	public Boolean delete(T t) {
		EntityManager em = null;
		Boolean removed;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			t = em.merge(t);
			em.remove(t);
			removed = true;
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			removed = false;
		}finally {
			em.close();
		}
		return removed;
	}

	@Override
	public T update(T t) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		return t;
	}

	@Override
	public T findById(Integer id) {
		EntityManager em = null;
		T t = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			String className = ((ParameterizedType)getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0]
							.getTypeName();
			Class<?> clazz;
			clazz = Class.forName(className);
			t = (T) em.find(clazz, id);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return t;
	}

}
