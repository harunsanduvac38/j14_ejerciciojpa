package com.cursogetafe.agenda.persistencia;

import java.util.LinkedHashSet;
import java.util.Set;

import com.cursogetafe.agenda.config.Config;
import com.cursogetafe.agenda.modelo.Contacto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class ContactoDaoJPA implements ContactoDao {
	
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ContactoDaoJPA() {
		emf = Config.getEmf();
	}

	@Override
	public void insertar(Contacto c) {
		em = emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			
		}
		
		em.close();
	}

	@Override
	public void actualizar(Contacto c) {
		em = emf.createEntityManager();
		

		try {
			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		em.close();
			
	}

	@Override
	public boolean eliminar(int idContacto) {
			em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Contacto.class, idContacto));
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			
		}
		return em.contains(em.find(Contacto.class, idContacto));

		
	
	}

	@Override
	public boolean eliminar(Contacto c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacto buscar(int idContacto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Contacto> buscar(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Contacto> buscarTodos() {
		em = emf.createEntityManager();
		String jpql = "select c from Contacto c";

		TypedQuery<Contacto> q = em.createQuery(jpql, Contacto.class);
		
		return (Set<Contacto>) q.getResultList();
	}

}
