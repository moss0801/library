package com.moss.library.book.infrastructure;

import com.moss.library.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>, CustomizedBookRepository {
}
