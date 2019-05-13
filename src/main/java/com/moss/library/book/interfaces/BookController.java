package com.moss.library.book.interfaces;

import com.moss.library.book.application.BookService;
import com.moss.library.book.domain.Book;
import com.moss.library.book.infrastructure.BookRepository;
import com.moss.library.user.domain.User;
import com.moss.library.validation.Delete;
import com.moss.library.validation.Save;
import com.moss.library.validation.Update;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.ConvertGroup;
import java.util.List;

/**
 * 책 Controller
 */
@RestController
@RequestMapping("api/book")
public class BookController {
    private BookService service;
    private BookRepository repository;

    public BookController(BookService service, BookRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    /**
     * 책 추가
     */
    @PostMapping
    public Book save(
            @RequestBody
            @Valid
            @ConvertGroup(to = Save.class)
                    Book book) {
        return service.save(book);
    }

    /**
     * 책 목록 검색
     */
    @GetMapping
    public List<Book> findAll() {
        return repository.findAll();
    }

    /**
     * 책 조회
     */
    @GetMapping(value="{bookId}")
    public Book find(@PathVariable Long bookId) {
        return repository.findById(bookId).get();
    }

    /**
     * 대출자 조회
     */
    @GetMapping("{bookId}/user")
    public User findUser(@PathVariable Long bookId) {
        return repository.findUser(bookId);
    }

    /**
     * 책 수정
     */
    @PutMapping("{bookId}")
    public Book update(
            @PathVariable("bookId")
            @RequestBody
            @Valid
            @ConvertGroup(to= Update.class)
            Book book ) {
        return service.update(book);
    }

    /**
     * 책 삭제
     */
    @DeleteMapping("bookId}")
    public Book delete(
            @PathVariable("bookId")
            @RequestBody
            @Valid
            @ConvertGroup(to= Delete.class)
            Book book) {
        return service.delete(book);
    }


}
