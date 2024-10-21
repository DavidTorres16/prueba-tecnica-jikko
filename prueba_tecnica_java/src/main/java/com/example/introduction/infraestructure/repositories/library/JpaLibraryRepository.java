package com.example.introduction.infraestructure.repositories.library;

import com.example.introduction.infraestructure.entities.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLibraryRepository extends JpaRepository<LibraryEntity, Long> {
}
