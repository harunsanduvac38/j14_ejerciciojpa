package com.cursogetafe.ejerciciojpa.consultas;

import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta05 {
	public static void main(String[] args) {
		
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		//Busca todos los clientes con todos sus datos que están en modo eager. No carga los productos
		//Para cargar los datos de la Persona, realiza una consulta por cada Idro.
		String jpql1 = "select c from Cliente c";
		
	
		//----------
		//Realiza una consulta con join a personas con todo los datos
		//No carga los produt¡ctos
		
		//Fetch cambia de modo lazy a eagle de la lista que está  en otra clase de clase principal.
		
		String jpql2 = "select c from Cliente c join fetch c.persona";
		
		
		
		//--------
		//Realiza una sola consulta de clientes join roles join personas join clientes_productos join productoso
		//Devuelve los productos en modo eager
		String jpql3 = "select c from Cliente c join fetch c.persona left join fetch c.productos";
		
		
		
		
		
		TypedQuery<Cliente> q = em.createQuery(jpql3, Cliente.class);
		
		for(Cliente cli : q.getResultList()) {
			System.out.println(cli);
			System.out.println("\n\n " + cli.getProductos());
		}
	}

}
