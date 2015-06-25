package be.vdab.services;

import javax.persistence.EntityManager;

import be.vdab.dao.DocentDAO;
import be.vdab.entities.Docent;
import be.vdab.filters.JPAFilter;

public class DocentService {
	
	private final DocentDAO docentDAO = new DocentDAO();
	
	public Docent read(long id){
		EntityManager entityManager = JPAFilter.getEntityManager();
		try{
			return docentDAO.read(id, entityManager);
		} finally{
			entityManager.close();
		}
	}
	
	public void create(Docent docent){
		EntityManager entityManager = JPAFilter.getEntityManager();
		try{
			entityManager.getTransaction().begin();
			docentDAO.create(docent, entityManager);
			entityManager.getTransaction().commit();
		}catch (RuntimeException ex){
			entityManager.getTransaction().rollback();
			throw ex;
		}finally{
			entityManager.close();
		}
	}
}
