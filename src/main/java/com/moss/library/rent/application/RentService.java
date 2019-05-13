package com.moss.library.rent.application;

import com.moss.library.book.application.BookService;
import com.moss.library.book.domain.Book;
import com.moss.library.rent.domain.Rent;
import com.moss.library.rent.infrastructure.RentRepository;
import com.moss.library.user.application.UserService;
import com.moss.library.user.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RentService {
    private RentRepository repository;
    private UserService userService;
    private BookService bookService;

    public RentService(RentRepository repository, UserService userService, BookService bookService) {
        this.repository = repository;
        this.userService = userService;
        this.bookService = bookService;
    }

    @Transactional
    public Rent save(Rent rent) {
        // 유저 체크
        Optional<User> optionalUser = userService.findById(rent.getUserId());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User Not exist");
        }
        User user = optionalUser.get();
        if (user.getRentalBookIdList().size() > 5) {
            throw new RuntimeException("full");
        }

        // 책 체크
        Optional<Book> optionalBook = bookService.findById(rent.getBookId());
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Book Not exist");
        }
        Book book = optionalBook.get();
        if (!book.canRent()) {
            throw new RuntimeException("Can rent");
        }

        // 대출
        repository.save(rent);
        return rent;
    }
}
