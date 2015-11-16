package se.jonananas.templates.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerProviderImpl implements EntityManagerProvider {

	protected EntityManagerFactory emf;
	private EntityManager em;
	protected String persistenceProvider;

	public EntityManagerProviderImpl() {
	}

	public EntityManagerProviderImpl(String persistenceUnitName) {
		this.persistenceProvider = persistenceUnitName;
	}

	protected void createEntityManagerFactory() {
		this.emf = Persistence.createEntityManagerFactory(persistenceProvider);
	}

	@Override
	public EntityManager createEntityManager() {
		if (this.emf == null)
			createEntityManagerFactory();
		this.em = this.emf.createEntityManager();
		return this.em;
	}

	@Override
	public void beginTransaction() {
		this.em.getTransaction().begin();
	}

	@Override
	public void endTransaction() {
		if (this.em != null) {
			this.em.close();
			this.em = null;
		}
	}

	@Override
	public void commitTransaction() {
		this.em.getTransaction().commit();
	}

	@Override
	public void rollbackTransaction() {
		this.em.getTransaction().rollback();
	}
}