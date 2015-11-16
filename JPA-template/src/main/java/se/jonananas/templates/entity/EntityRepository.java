package se.jonananas.templates.entity;

public interface EntityRepository {

	void store(ExampleEntity entity1);

	ExampleEntity findById(String string);
	
}