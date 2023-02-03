package com.blurdel.sdjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.domain.composite.AuthorEmbedded;
import com.blurdel.sdjpa.domain.composite.NameId;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
