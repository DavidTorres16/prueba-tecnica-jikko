package com.example.introduction.infraestructure.repositories.book;

import com.example.introduction.infraestructure.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository extends JpaRepository<BookEntity, Long> {
}
