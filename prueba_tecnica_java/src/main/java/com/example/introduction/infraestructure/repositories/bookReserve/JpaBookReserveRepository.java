package com.example.introduction.infraestructure.repositories.bookReserve;

import com.example.introduction.infraestructure.entities.BookReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookReserveRepository extends JpaRepository<BookReserveEntity, Long> {
}
