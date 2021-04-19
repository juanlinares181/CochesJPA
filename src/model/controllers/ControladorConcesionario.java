package model.controllers;

import model.Venta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Concesionario;
import model.Fabricante;

public class ControladorConcesionario {

	private static ControladorConcesionario instance = null;

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("CochesJPA");

	/**
	 * 
	 * @return
	 */
	public static ControladorConcesionario getInstance() {
		if (instance == null) {
			instance = new ControladorConcesionario();
		}
		return instance;
	}

	/**
	 * 
	 */
	public ControladorConcesionario() {

	}

	public Concesionario find(int id) {
		Concesionario co = null;
		EntityManager em = factory.createEntityManager();
		co = (Concesionario) em.find(Concesionario.class, id);
		em.close();
		return co;
	}

	/**
	 * 
	 * @return
	 */
	public Concesionario findPrimero() {
		Concesionario co = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario order by id limit 1",
				Fabricante.class);
		co = (Concesionario) q.getSingleResult();
		em.close();

		return co;
	}

	/**
	 * 
	 * @return
	 */
	public Concesionario findUltimo() {
		Concesionario co = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario order by id desc limit 1",
				Fabricante.class);
		co = (Concesionario) q.getSingleResult();
		em.close();

		return co;
	}

	/**
	 * 
	 * @return
	 */
	public Concesionario findSiguiente(int idActual) {
		Concesionario co = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery(
				"select * from tutorialjavacoches.concesionario where id > ? order by id limit 1", Concesionario.class);
		q.setParameter(1, idActual);
		co = (Concesionario) q.getSingleResult();
		em.close();

		return co;
	}

	/**
	 * 
	 * @return
	 */
	public Concesionario findAnterior(int idActual) {
		Concesionario co = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery(
				"select * from tutorialjavacoches.concesionario where id < ? order by id desc limit 1",
				Concesionario.class);
		q.setParameter(1, idActual);
		co = (Concesionario) q.getSingleResult();
		em.close();

		return co;
	}

	/**
	 * 
	 * @return
	 */
	public boolean guardar(Concesionario co) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (co.getId() == 0) {
				em.persist(co);
			} else {
				em.merge(co);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Concesionario co) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(co);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * 
	 * @return
	 */
	public List<Concesionario> findAll() {
		EntityManager em = factory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM concesionario", Concesionario.class);

		List<Concesionario> list = (List<Concesionario>) q.getResultList();
		em.close();
		return list;
	}

}
