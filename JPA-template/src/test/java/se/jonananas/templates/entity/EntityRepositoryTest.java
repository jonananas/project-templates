package se.jonananas.templates.entity;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EntityRepositoryTest {

	protected EntityManagerProvider sessionEm;
	protected EntityManager em;
	
	EntityRepository entityRepo;
	private ExampleEntity entity1;

	@Before
	public void setup() throws Exception {
		entityRepo = new EntityRepositoryEM();
		this.sessionEm = new EntityManagerProviderStaticImpl("H2SQLPU");
		this.em = sessionEm.createEntityManager();
		((EntityRepositoryEM) entityRepo).em = em;
		this.sessionEm.beginTransaction();
		entity1 = ExampleEntity.createFromNaturalId("123");
	}

	@After
	public void tearDown() {
		this.sessionEm.rollbackTransaction();
		this.sessionEm.endTransaction();
	}

	@Test
	public void shouldStoreAndFindExampleEntity() throws Exception {
		entityRepo.store(entity1);
		assertThat(entityRepo.findById("123")).isEqualTo(entity1);
	}

}