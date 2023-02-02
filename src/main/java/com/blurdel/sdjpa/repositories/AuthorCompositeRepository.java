package com.blurdel.sdjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.domain.composite.AuthorComposite;
import com.blurdel.sdjpa.domain.composite.NameId;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId>{
}
