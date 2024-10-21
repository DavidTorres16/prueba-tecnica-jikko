package com.example.introduction.infraestructure.config;

import com.example.introduction.application.services.BookReserveService;
import com.example.introduction.application.services.LibraryService;
import com.example.introduction.application.services.BookService;
import com.example.introduction.application.services.UserService;
import com.example.introduction.application.usecases.bookReserve.CreateBookReserveUseCaseImpl;
import com.example.introduction.application.usecases.bookReserve.DeleteBookReserveUseCaseImpl;
import com.example.introduction.application.usecases.bookReserve.RetrieveBookReserveUseCaseImpl;
import com.example.introduction.application.usecases.bookReserve.UpdateBookReserveUseCaseImpl;
import com.example.introduction.application.usecases.library.CreateLibraryUseCaseImpl;
import com.example.introduction.application.usecases.library.DeleteLibraryUseCaseImpl;
import com.example.introduction.application.usecases.library.RetrieveLibraryUseCaseImpl;
import com.example.introduction.application.usecases.library.UpdateLibraryUseCaseImpl;
import com.example.introduction.application.usecases.book.CreateBookUseCaseImpl;
import com.example.introduction.application.usecases.book.DeleteBookUseCaseImpl;
import com.example.introduction.application.usecases.book.RetrieveBookUseCaseImpl;
import com.example.introduction.application.usecases.book.UpdateBookUseCaseImpl;
import com.example.introduction.application.usecases.user.CreateUserUseCaseImpl;
import com.example.introduction.application.usecases.user.DeleteUserUseCaseImpl;
import com.example.introduction.application.usecases.user.RetrieveUserUseCaseImpl;
import com.example.introduction.application.usecases.user.UpdateUserUseCaseImpl;
import com.example.introduction.domain.ports.out.bookReserve.BookReserveRepositoryPort;
import com.example.introduction.domain.ports.out.library.LibraryRepositoryPort;
import com.example.introduction.domain.ports.out.book.BookRepositoryPort;
import com.example.introduction.domain.ports.out.user.UserRepositoryPort;
import com.example.introduction.infraestructure.repositories.bookReserve.JpaBookReserveRepository;
import com.example.introduction.infraestructure.repositories.bookReserve.JpaBookReserveRepositoryAdapter;
import com.example.introduction.infraestructure.repositories.library.JpaLibraryRepository;
import com.example.introduction.infraestructure.repositories.library.JpaLibraryRepositoryAdapter;
import com.example.introduction.infraestructure.repositories.book.JpaBookRepository;
import com.example.introduction.infraestructure.repositories.book.JpaBookRepositoryAdapter;
import com.example.introduction.infraestructure.repositories.user.JpaUserRepository;
import com.example.introduction.infraestructure.repositories.user.JpaUserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort){
        return new UserService(
                new CreateUserUseCaseImpl(userRepositoryPort),
                new RetrieveUserUseCaseImpl(userRepositoryPort),
                new DeleteUserUseCaseImpl(userRepositoryPort),
                new UpdateUserUseCaseImpl(userRepositoryPort)
        );
    }

    @Bean
    public BookService bookService(BookRepositoryPort bookRepositoryPort){
        return new BookService(
                new RetrieveBookUseCaseImpl(bookRepositoryPort),
                new DeleteBookUseCaseImpl(bookRepositoryPort),
                new UpdateBookUseCaseImpl(bookRepositoryPort),
                new CreateBookUseCaseImpl(bookRepositoryPort)
        );
    }

    @Bean
    public LibraryService libraryService(LibraryRepositoryPort libraryRepositoryPort){
        return new LibraryService(
                new CreateLibraryUseCaseImpl(libraryRepositoryPort),
                new RetrieveLibraryUseCaseImpl(libraryRepositoryPort),
                new DeleteLibraryUseCaseImpl(libraryRepositoryPort),
                new UpdateLibraryUseCaseImpl(libraryRepositoryPort)
        );
    }

    @Bean
    public BookReserveService bookReserveService(BookReserveRepositoryPort bookReserveRepositoryPort){
        return new BookReserveService(
                new RetrieveBookReserveUseCaseImpl(bookReserveRepositoryPort),
                new DeleteBookReserveUseCaseImpl(bookReserveRepositoryPort),
                new UpdateBookReserveUseCaseImpl(bookReserveRepositoryPort),
                new CreateBookReserveUseCaseImpl(bookReserveRepositoryPort)
        );
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(JpaUserRepositoryAdapter jpaUserRepositoryAdapter){
        return jpaUserRepositoryAdapter;
    }

    @Bean
    public BookRepositoryPort bookRepositoryPort(JpaBookRepositoryAdapter jpaBookRepositoryAdapter){
        return jpaBookRepositoryAdapter;
    }

    @Bean
    public LibraryRepositoryPort libraryRepositoryPort(JpaLibraryRepositoryAdapter jpaLibraryRepositoryAdapter){
        return jpaLibraryRepositoryAdapter;
    }

    @Bean
    public BookReserveRepositoryPort bookReserveRepositoryPort(JpaBookReserveRepositoryAdapter jpaBookReserveRepositoryAdapter){
        return jpaBookReserveRepositoryAdapter;
    }

    @Bean
    public JpaUserRepositoryAdapter jpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository){
        return new JpaUserRepositoryAdapter(jpaUserRepository);
    }

    @Bean
    public JpaLibraryRepositoryAdapter jpaLibraryRepositoryAdapter(JpaLibraryRepository jpaLibraryRepository){
        return new JpaLibraryRepositoryAdapter(jpaLibraryRepository);
    }

    @Bean
    public JpaBookRepositoryAdapter jpaBookRepositoryAdapter(JpaBookRepository jpaBookRepository){
        return new JpaBookRepositoryAdapter(jpaBookRepository);
    }

    @Bean
    public JpaBookReserveRepositoryAdapter jpaBookReserveRepositoryAdapter(JpaBookReserveRepository jpaBookReserveRepository){
        return new JpaBookReserveRepositoryAdapter(jpaBookReserveRepository);
    }

}
