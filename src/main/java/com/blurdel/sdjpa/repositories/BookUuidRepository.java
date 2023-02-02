package com.blurdel.sdjpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.domain.BookUuid;

public interface BookUuidRepository extends JpaRepository<BookUuid, UUID>{
}
