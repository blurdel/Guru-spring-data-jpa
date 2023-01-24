package com.blurdel.sdjpa.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blurdel.sdjpa.domain.Book;
import com.blurdel.sdjpa.repositories.BookRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	private final BookRepository bookRepository;
	
	
	public DataInitializer(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Book bookDDD = new Book("Data Driven Design", "123", "Randomware");
		System.out.println("id=" + bookDDD.getId());
		Book savedDDD = bookRepository.save(bookDDD);
		System.out.println("id=" + bookDDD.getId());
		
		Book bookSIA = new Book("Spring In Action", "234234", "O'Reilly");
		Book savedSIA = bookRepository.save(bookSIA);
		
		bookRepository.findAll().forEach(book -> {
			System.out.println("id: " + book.getId());
			System.out.println("title: " + book.getTitle());
		});
	}

}
