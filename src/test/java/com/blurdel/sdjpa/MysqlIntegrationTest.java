package com.blurdel.sdjpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import com.blurdel.sdjpa.repositories.BookRepository;


@ActiveProfiles("local")
@DataJpaTest // Spring- Wires in H2 in-memory database
@ComponentScan(basePackages = {"com.blurdel.sdjpa.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // @DataJpaTest - Spring Boot still configures H2 database, tell it dont override MySql
public class MysqlIntegrationTest {

	@Autowired
	BookRepository bookRepository;
	
	
	@Test
	void testMysql() {
		long countBefore = bookRepository.count();
		assertThat(countBefore).isEqualTo(2);
	}
	
}
