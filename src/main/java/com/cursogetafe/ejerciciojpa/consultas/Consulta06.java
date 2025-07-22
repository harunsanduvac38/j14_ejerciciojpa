package com.cursogetafe.ejerciciojpa.consultas;

import java.util.List;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta06 {
	public static void main(String[] args) {
		
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		//Buscar la cantidad de clientes por categoria
		
		String jpql = "select c.categoria, count(c.idRol) from Cliente c group by c.categoria";
		
//		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		
		List<Object[]> count =  em.createQuery(jpql, Object[].class).getResultList();
		
		for(Object[] objetos : count) {
			System.out.println(objetos[0] + ": " + objetos[1]);
		}
	}
	
	
	public static List<Object[]> cantClientesPorCategoria() {

		EntityManager em = Config.getEmf().createEntityManager();
		
		//Buscar la cantidad de clientes por categoria
		
		String jpql = "select c.categoria, count(c.idRol) from Cliente c group by c.categoria";
		
//		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		
		return  em.createQuery(jpql, Object[].class).getResultList();
		
		
	}

}
