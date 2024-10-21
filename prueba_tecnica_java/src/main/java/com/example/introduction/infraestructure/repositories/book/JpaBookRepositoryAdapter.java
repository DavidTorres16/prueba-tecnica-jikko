package com.example.introduction.infraestructure.repositories.book;

import com.example.introduction.domain.models.Book;
import com.example.introduction.domain.ports.out.book.BookRepositoryPort;
import com.example.introduction.infraestructure.entities.BookEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JpaBookRepositoryAdapter implements BookRepositoryPort {

    private final JpaBookRepository jpaBookRepository;

    @Override
    public Book save(Book book) {
        BookEntity productEntity = BookEntity.fromDomainModel(book);
        return jpaBookRepository.save(productEntity).toDomainModel();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return jpaBookRepository.findById(id.longValue()).map(BookEntity::toDomainModel);
    }

    @Override
    public List<Book> findAll() {
        return jpaBookRepository.findAll().stream()
                .map(BookEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> update(Integer id, Book book) {
        if(jpaBookRepository.existsById(id.longValue())){
            BookEntity updatedProductEntity = jpaBookRepository.save(BookEntity.fromDomainModel(book));
            return Optional.of(updatedProductEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteById(Integer id) {
        if(jpaBookRepository.existsById(id.longValue())){
            jpaBookRepository.deleteById(id.longValue());
            return true;
        }
        return false;
    }
}
