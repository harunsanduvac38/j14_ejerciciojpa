package com.cursogetafe.agenda.tests;

import com.cursogetafe.agenda.modelo.Contacto;
import com.cursogetafe.agenda.modelo.Domicilio;
import com.cursogetafe.agenda.persistencia.ContactoDao;
import com.cursogetafe.agenda.persistencia.ContactoDaoJPA;
import com.cursogetafe.agenda.persistencia.ContactoDaoMem;

public class Test02Dao  {
	public static void main(String[] args) {
		ContactoDao dao = new ContactoDaoJPA();
		
		Domicilio dom1 = new Domicilio("tipo", "null", 0234, 23432, "nusdfll", "nsdfasull", "nsdfaull", "nullsdfas");

		Contacto ins = new Contacto(0, "harun", "Sanduvac", "sandu", dom1);
		
		dao.insertar(ins);
		
		dao.buscarTodos().forEach(System.out::println);
//		dao.buscarTodos().forEach(c -> System.out.println(c));		
		System.out.println();
		
		dao.buscar("al").forEach(System.out::println);
		System.out.println();
		
		System.out.println(dao.buscar(44));
		System.out.println();
		
		Contacto buscado = dao.buscar(88);
		buscado.setApellidos("Nuevo Apellido");
		buscado.setApodo("Cabezon");
		dao.actualizar(buscado);
		System.out.println(dao.buscar(88));
		System.out.println();
		
		dao.eliminar(88);
		System.out.println(dao.buscar(88));
		System.out.println();
		
		
		
		
	}

}
