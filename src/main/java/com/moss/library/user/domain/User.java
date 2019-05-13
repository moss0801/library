package com.moss.library.user.domain;

import com.moss.library.book.domain.Book;
import com.moss.library.validation.Delete;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString(exclude = "rentalBookIdList")
@EqualsAndHashCode(of ={"userId"})
public class User {
    @Min(value = 1, groups = {Delete.class})
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotEmpty
    @Column(nullable = false)
    private String userName;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime registered;

    @ElementCollection
    @CollectionTable(name = "rent",
        joinColumns = @JoinColumn(name = "userId"))
    private List<Long> rentalBookIdList;

    public Book rent(Book book) {
        return null;
    }

    public Book returnBook(Book book) {
        return null;
    }

    @Builder
    public User(String userName) {
        this.userName = userName;
    }
}
