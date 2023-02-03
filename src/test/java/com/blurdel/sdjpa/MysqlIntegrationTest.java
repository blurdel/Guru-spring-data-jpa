package com.blurdel.sdjpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import com.blurdel.sdjpa.domain.AuthorUuid;
import com.blurdel.sdjpa.domain.BookUuid;
import com.blurdel.sdjpa.domain.composite.AuthorComposite;
import com.blurdel.sdjpa.domain.composite.AuthorEmbedded;
import com.blurdel.sdjpa.domain.composite.NameId;
import com.blurdel.sdjpa.repositories.AuthorCompositeRepository;
import com.blurdel.sdjpa.repositories.AuthorEmbeddedRepository;
import com.blurdel.sdjpa.repositories.AuthorUuidRepository;
import com.blurdel.sdjpa.repositories.BookRepository;
import com.blurdel.sdjpa.repositories.BookUuidRepository;


@ActiveProfiles("mysql")
@DataJpaTest // Spring- Wires in H2 in-memory database
@ComponentScan(basePackages = {"com.blurdel.sdjpa.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // @DataJpaTest - Spring Boot still configures H2 database, tell it dont override MySql
public class MysqlIntegrationTest {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorUuidRepository authorUuidRepository;
	
	@Autowired
	BookUuidRepository bookUuidRepository;
	
	@Autowired
	AuthorCompositeRepository authorCompositeRepository;
	
	@Autowired
	AuthorEmbeddedRepository authorEmbeddedRepository;
	
	
	@Test
	void testAuthorEmbedded() {
		NameId nameId = new NameId("John", "T");
		AuthorEmbedded authorEmbedded = new AuthorEmbedded(nameId);
		
		AuthorEmbedded saved = authorEmbeddedRepository.save(authorEmbedded);
		assertThat(saved).isNotNull();
		
		AuthorEmbedded fetched = authorEmbeddedRepository.getById(nameId);
		assertThat(fetched).isNotNull();
		
		assertThat(fetched.getNameid()).isEqualTo(nameId);
	}
	
	@Test
	void testAuthorComposite() {
		NameId nameId = new NameId("John", "T");
		AuthorComposite authorComposite = new AuthorComposite();
		authorComposite.setFirstName(nameId.getFirstName());
		authorComposite.setLastName(nameId.getLastName());
		authorComposite.setCountry("USA");
		
		AuthorComposite saved = authorCompositeRepository.save(authorComposite);
		assertThat(saved).isNotNull();
		
		AuthorComposite fetched = authorCompositeRepository.getById(nameId);
		assertThat(fetched).isNotNull();		
	}
	
	@Test
	void testBookUuid() {
		BookUuid bookUuid = bookUuidRepository.save(new BookUuid());
		assertThat(bookUuid).isNotNull();
		assertThat(bookUuid.getId()).isNotNull();
		
		BookUuid fetched = bookUuidRepository.getById(bookUuid.getId());
		assertThat(fetched).isNotNull();
		
		assertThat(bookUuid.getId()).isEqualTo(fetched.getId());
	}
	
	@Test
	void testAuthorUuid() {
		AuthorUuid authorUuid = authorUuidRepository.save(new AuthorUuid());
		assertThat(authorUuid).isNotNull();
		assertThat(authorUuid.getId()).isNotNull();
		
		AuthorUuid fetched = authorUuidRepository.getById(authorUuid.getId());
		assertThat(fetched).isNotNull();
		
		assertThat(authorUuid.getId()).isEqualTo(fetched.getId());
	}
	
	@Test
	void testMysql() {
		long countBefore = bookRepository.count();
		assertThat(countBefore).isEqualTo(2);
	}
	
}
