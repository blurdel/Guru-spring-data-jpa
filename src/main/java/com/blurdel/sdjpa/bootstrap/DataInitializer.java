package com.blurdel.sdjpa.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.blurdel.sdjpa.domain.AuthorUuid;
import com.blurdel.sdjpa.domain.Book;
import com.blurdel.sdjpa.repositories.AuthorUuidRepository;
import com.blurdel.sdjpa.repositories.BookRepository;


@Profile({"mysql", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

	private final BookRepository bookRepository;
	private final AuthorUuidRepository authorUuidRepository;
	
	
	public DataInitializer(BookRepository bookRepository, AuthorUuidRepository authorUuidRepository) {
		this.bookRepository = bookRepository;
		this.authorUuidRepository = authorUuidRepository;
	}


	@Override
	public void run(String... args) throws Exception {

		bookRepository.deleteAll();
		
		Book bookDDD = new Book("Data Driven Design", "123", "Randomware", null);
		Book savedDDD = bookRepository.save(bookDDD);
		
		Book bookSIA = new Book("Spring In Action", "234234", "O'Reilly", null);
		Book savedSIA = bookRepository.save(bookSIA);
		
		bookRepository.findAll().forEach(book -> {
			System.out.println("id: " + book.getId());
			System.out.println("title: " + book.getTitle());
		});
		
		AuthorUuid authorUuid = new AuthorUuid();
		authorUuid.setFirstName("Joe");
		authorUuid.setLastName("Buck");
		AuthorUuid savedAuthor = authorUuidRepository.save(authorUuid);
		System.out.println("Saved UUID:" + savedAuthor.getId());
	}

}
