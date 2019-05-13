package com.moss.library.rent.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString(exclude = "")
@EqualsAndHashCode(of ={""})
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentId;

    @Column(nullable = false, updatable = false)
    private Long bookId;

    @Column(nullable = false, updatable = false)
    private Long userId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime rented;

    @Column(nullable = false, updatable = false)
    private LocalDate dueDate;

    @Column(insertable = false)
    private LocalDateTime returned;

    @Builder
    public Rent(Long bookId, Long userId, LocalDateTime rented, LocalDate dueDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.rented = rented;
        this.dueDate = dueDate;
    }
}
