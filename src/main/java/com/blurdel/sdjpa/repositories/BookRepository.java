package com.blurdel.sdjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
