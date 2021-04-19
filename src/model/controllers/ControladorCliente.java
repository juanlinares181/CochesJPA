package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Cliente;
import model.Fabricante;

public class ControladorCliente {

	private static ControladorCliente instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CochesJPA");

	/**
	 * 
	 * @return
	 */
	public static ControladorCliente getInstance() {
		if (instance == null) {
			instance = new ControladorCliente();
		}
		return instance;
	}

	/**
	 * 
	 */
	public ControladorCliente() {

	}

	public Cliente find(int id) {
		Cliente cl = null;
		EntityManager em = factory.createEntityManager();
		cl = (Cliente) em.find(Cliente.class, id);
		em.close();
		return cl;
	}

	/**
	 * 
	 * @return
	 */
	public Cliente findPrimero() {
		Cliente cl = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id limit 1", Cliente.class);
		cl = (Cliente) q.getSingleResult();
		em.close();

		return cl;
	}

	/**
	 * 
	 * @return
	 */
	public Cliente findUltimo() {
		Cliente cl = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id desc limit 1",
				Cliente.class);
		cl = (Cliente) q.getSingleResult();
		em.close();

		return cl;
	}

	/**
	 * 
	 * @return
	 */
	public Cliente findSiguiente(int idActual) {
		Cliente cl = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id > ? order by id limit 1",
				Cliente.class);
		q.setParameter(1, idActual);
		cl = (Cliente) q.getSingleResult();
		em.close();

		return cl;
	}

	/**
	 * 
	 * @return
	 */
	public Cliente findAnterior(int idActual) {
		Cliente cl = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id < ? order by id desc limit 1",
				Fabricante.class);
		q.setParameter(1, idActual);
		cl = (Cliente) q.getSingleResult();
		em.close();

		return cl;
	}

	/**
	 * 
	 * @return
	 */
	public boolean guardar(Cliente cl) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (cl.getId() == 0) {
				em.persist(cl);
			} else {
				em.merge(cl);
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
	public void borrar(Cliente cl) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(cl);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * 
	 * @return
	 */
	public List<Cliente> findAll() {
		EntityManager em = factory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM cliente", Cliente.class);

		List<Cliente> list = (List<Cliente>) q.getResultList();
		em.close();
		return list;
	}

}
