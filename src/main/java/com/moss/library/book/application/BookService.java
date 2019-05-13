package com.moss.library.book.application;

import com.moss.library.book.domain.Book;
import com.moss.library.book.domain.BookStatus;
import com.moss.library.book.infrastructure.BookRepository;
import com.moss.library.user.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    /**
     * 책 추가
     */
    @Transactional
    public Book save(Book book) {
        repository.save(book);
        return book;
    }

    /**
     * 책 조회
     */
    public Optional<Book> findById(Long bookId) {
        return repository.findById(bookId);
    }

    /**
     * 책 수정
     */
    @Transactional
    public Book update(Book book) {
        repository.findById(book.getBookId());

        return book;
    }

    /**
     * 책 삭제
     */
    @Transactional
    public Book delete(Book book) {
        Optional<Book> exists = repository.findById(book.getBookId());
        if (exists.isEmpty()) {
            throw new RuntimeException("Not Exists");
        }

        // 상태 확인
        if (!BookStatus.Available.equals(book.getBookStatus())) {
            throw new RuntimeException("Not Available Status");
        }

        // 삭제
        repository.delete(book);
        return book;
    }
}
