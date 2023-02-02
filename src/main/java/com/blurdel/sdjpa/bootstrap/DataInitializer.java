package com.blurdel.sdjpa.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.blurdel.sdjpa.domain.AuthorUuid;
import com.blurdel.sdjpa.domain.Book;
import com.blurdel.sdjpa.domain.BookUuid;
import com.blurdel.sdjpa.repositories.AuthorUuidRepository;
import com.blurdel.sdjpa.repositories.BookRepository;
import com.blurdel.sdjpa.repositories.BookUuidRepository;


@Profile({"mysql", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

	private final BookRepository bookRepository;
	private final AuthorUuidRepository authorUuidRepository;
	private final BookUuidRepository bookUuidRepository;
	
	
	public DataInitializer(BookRepository bookRepository, AuthorUuidRepository authorUuidRepository, BookUuidRepository bookUuidRepository) {
		this.bookRepository = bookRepository;
		this.authorUuidRepository = authorUuidRepository;
		this.bookUuidRepository = bookUuidRepository;
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
		System.out.println("Saved Author UUID:" + savedAuthor.getId());
		
		BookUuid bookUuid = new BookUuid();
		bookUuid.setTitle("All About UUIDs");
		BookUuid savedBookUuid =  bookUuidRepository.save(bookUuid);
		System.out.println("Saved Book UUID:" + savedBookUuid.getId());
	}

}
