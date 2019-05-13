package com.moss.library;

import com.moss.library.book.domain.Book;
import com.moss.library.book.domain.BookStatus;
import com.moss.library.book.domain.CallNumber;
import com.moss.library.book.infrastructure.BookRepository;
import com.moss.library.rent.domain.Rent;
import com.moss.library.rent.infrastructure.RentRepository;
import com.moss.library.user.domain.User;
import com.moss.library.user.infrastructrue.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EnableJpaAuditing
@EntityScan(
        basePackageClasses = {LibraryApplication.class, Jsr310JpaConverters.class})
@SpringBootApplication
public class LibraryApplication {
    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public CommandLineRunner init(UserRepository userRepository,
                                  BookRepository bookRepository,
                                  RentRepository rentRepository) {
        return (args -> {
            List<User> userList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                userList.add(new User("user" + i));
            }
            userRepository.saveAll(userList);

            CallNumber callNumber = new CallNumber("1", "1", "1", "1");
            Book book = Book.builder()
                    .bookStatus(BookStatus.Available)
                    .author("작가")
                    .isbn("ISBN...")
                    .published(LocalDate.now())
                    .subject("책 제목")
                    .callNumber(callNumber)
                    .build();

            bookRepository.save(book);

            Rent rent = Rent.builder()
                    .bookId(book.getBookId())
                    .userId(1L)
                    .rented(LocalDateTime.now())
                    .dueDate(LocalDate.now().plusDays(5L))
                    .build();
            rentRepository.save(rent);

        });
    }

}
