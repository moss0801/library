package com.moss.library.book.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 85551232L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBook book = new QBook("book");

    public final StringPath author = createString("author");

    public final NumberPath<Long> bookId = createNumber("bookId", Long.class);

    public final EnumPath<BookStatus> bookStatus = createEnum("bookStatus", BookStatus.class);

    public final QCallNumber callNumber;

    public final StringPath isbn = createString("isbn");

    public final DatePath<java.time.LocalDate> published = createDate("published", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> registered = createDateTime("registered", java.time.LocalDateTime.class);

    public final StringPath subject = createString("subject");

    public QBook(String variable) {
        this(Book.class, forVariable(variable), INITS);
    }

    public QBook(Path<? extends Book> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBook(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBook(PathMetadata metadata, PathInits inits) {
        this(Book.class, metadata, inits);
    }

    public QBook(Class<? extends Book> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.callNumber = inits.isInitialized("callNumber") ? new QCallNumber(forProperty("callNumber")) : null;
    }

}

