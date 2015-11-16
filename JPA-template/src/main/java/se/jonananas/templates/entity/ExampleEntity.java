package se.jonananas.templates.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExampleEntity {

	@Id
	private String id;

	ExampleEntity() {
		// Needed by JPA
	}
	
	private ExampleEntity(String id) {
		this.id = id;
	}

	public static ExampleEntity createFromNaturalId(String id) {
		return new ExampleEntity(id);
	}

	public String getId() {
		return id;
	}
	
}