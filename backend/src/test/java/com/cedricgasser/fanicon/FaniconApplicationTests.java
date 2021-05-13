package com.cedricgasser.fanicon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

public class FaniconApplicationTests {

	@Test
	public void testNothing() {
		assertThat(1).isEqualTo(1);
	}
}
