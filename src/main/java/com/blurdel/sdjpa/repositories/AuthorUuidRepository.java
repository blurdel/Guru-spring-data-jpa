package com.blurdel.sdjpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.domain.AuthorUuid;

public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}
