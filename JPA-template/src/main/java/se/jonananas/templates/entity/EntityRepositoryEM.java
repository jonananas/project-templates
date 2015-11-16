package se.jonananas.templates.entity;

import javax.persistence.EntityManager;

public class EntityRepositoryEM implements EntityRepository {

	public EntityManager em;

	@Override
	public void store(ExampleEntity entity) {
		this.em.persist(entity);
	}

	@Override
	public ExampleEntity findById(String string) {
		return em.find(ExampleEntity.class, string);
	}
	
}