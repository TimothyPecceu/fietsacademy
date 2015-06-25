package be.vdab.dao;

import javax.persistence.EntityManager;

import be.vdab.entities.Docent;
import be.vdab.filters.JPAFilter;

public class DocentDAO {
	
	public Docent read(long id, EntityManager entityManager){
		return entityManager.find(Docent.class, id);
	}
	
	public void create(Docent docent, EntityManager entityManager){
		entityManager.persist(docent);
	}
}
