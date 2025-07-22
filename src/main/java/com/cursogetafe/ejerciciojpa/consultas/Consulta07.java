package com.cursogetafe.ejerciciojpa.consultas;


import com.cursogetafe.ejerciciojpa.config.Config;
import com.cursogetafe.ejerciciojpa.modelo.ClienteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class Consulta07 {
	public static void main(String[] args) {
		
		
		EntityManager em = Config.getEmf().createEntityManager();
		
		String jpql = "select new com.cursogetafe.ejerciciojpa.modelo.ClienteDTO(c.idRol, c.persona.apellidos, c.nroCliente, c.categoria)"
				+ " from Cliente c";
		
		TypedQuery<ClienteDTO> q = em.createQuery(jpql, ClienteDTO.class);
		
		q.getResultList().forEach(System.out::println);
	}

}
