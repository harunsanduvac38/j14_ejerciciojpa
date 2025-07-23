package com.cursogetafe.ejerciciojpa.pruebas;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;
import com.cursogetafe.ejerciciojpa.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class Test01 {
	
	public static void main(String[] args) {
		
		//Buscar el cliente 12 con sus productos:
		
//		Cliente cli = buscaClienteId(12);
		Cliente cli = buscaClienteIdJpql(12);
		
		if(cli != null) {
			System.out.println(cli);
		
		
			for(Producto p : cli.getProductos()) {
				System.out.println(p);
			}

		}
	}
	
	
	//retorna el cliente con sus productos cargados en caso que exista
		// si el cliente no existe retorna un null
	public static Cliente buscaClienteId(int id) {
		
		EntityManager em = Config.getEmf().createEntityManager();

		Cliente buscado = em.find(Cliente.class, id);
		if(buscado != null) {
			buscado.getProductos().size();
		}
	
		em.close();
		return buscado;
		
	}

	//retorna el cliente con sus productos cargados en caso que exista
		// si el cliente no existe retorna un null
	public static Cliente buscaClienteIdJpql(int id) {
		
		EntityManager em = Config.getEmf().createEntityManager();
		String jpql = "select c from Cliente c left join fetch c.productos where c.idRol = :id";
		TypedQuery<Cliente> q = em.createQuery(jpql, Cliente.class);
		q.setParameter("id", id);
		
//		Cliente buscado = null;
//		try {
//			buscado = q.getSingleResult();
//		}catch (NoResultException e) {
//			buscado = null;
//			
//		}
		Cliente buscado = q.getSingleResultOrNull();
		
		em.close();
		return buscado;
	}
	
}
