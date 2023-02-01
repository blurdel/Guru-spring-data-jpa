package com.blurdel.sdjpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import com.blurdel.sdjpa.domain.Book;
import com.blurdel.sdjpa.repositories.BookRepository;


//Brings up Hibernate with H2 database auto configured
@DataJpaTest // Spring- Brings up minimal context for testing Spring data repositories (no Bootstrap (data-initializer), Web, JMS messaging)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackages = {"com.blurdel.sdjpa.bootstrap"}) // Can force Bootstrap (data-initializer) with this
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // @DataJpaTest - Spring Boot still configures H2 database, tell it dont override MySql
public class SpringBootJpaTestSplice {

	@Autowired
	BookRepository bookRepository;
	
	
	@Commit // Default behavior would be to run this test, roll it back, then run the next test. Not for this particular test! 
	@Order(1)
	@Test
	void testJpaSplice() {
		long countBefore = bookRepository.count();
		assertThat(countBefore).isEqualTo(2);
		
		bookRepository.save(new Book("My Book", "1235555", "Self", null));
		
		long countAfter = bookRepository.count();
		
		assertThat(countBefore).isLessThan(countAfter);
	}
	
	@Order(2)
	@Test
	void testJpaSpliceTransaction() {
		long countBefore = bookRepository.count();
		assertThat(countBefore).isEqualTo(3);
	}
	
}
