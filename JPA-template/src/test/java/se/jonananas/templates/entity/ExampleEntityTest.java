package se.jonananas.templates.entity;


import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ExampleEntityTest {

	@Test
	public void shouldCreateWithId() {
		ExampleEntity entity = ExampleEntity.createFromNaturalId("123");
		Assertions.assertThat(entity.getId()).isEqualTo("123");
	}

}
