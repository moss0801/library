package com.moss.library.book.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@EqualsAndHashCode
public class Book {
    /**
     * 책Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    /**
     * ISBN
     */
    @Column(nullable = false)
    private String isbn;

    /**
     * 제목
     */
    @Column(nullable = false)
    private String subject;

    /**
     * 저자
     */
    @Column(nullable = false)
    private String author;

    /**
     * 발행일
     */
    @Column(nullable = false)
    private LocalDate published;

    /**
     * 책 상태
     */
    @Column(nullable = false)
    private BookStatus bookStatus;

    /**
     * 청구기호
     */
    @Embedded
    private CallNumber callNumber;

    /**
     * 등록일
     */
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime registered;

    @Builder
    public Book(String isbn, String subject, String author, LocalDate published, BookStatus bookStatus,
                CallNumber callNumber) {
        this.isbn = isbn;
        this.subject = subject;
        this.author = author;
        this.published = published;
        this.bookStatus = bookStatus;
        this.callNumber = callNumber;
    }

    /**
     * 대출 가능 여부
     */
    public boolean canRent() {
        return BookStatus.Available.equals(this.getBookStatus());
    }
}
