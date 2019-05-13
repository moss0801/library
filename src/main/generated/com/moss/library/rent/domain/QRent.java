package com.moss.library.rent.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRent is a Querydsl query type for Rent
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRent extends EntityPathBase<Rent> {

    private static final long serialVersionUID = 476688672L;

    public static final QRent rent = new QRent("rent");

    public final NumberPath<Long> bookId = createNumber("bookId", Long.class);

    public final DatePath<java.time.LocalDate> dueDate = createDate("dueDate", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> rented = createDateTime("rented", java.time.LocalDateTime.class);

    public final NumberPath<Long> rentId = createNumber("rentId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> returned = createDateTime("returned", java.time.LocalDateTime.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QRent(String variable) {
        super(Rent.class, forVariable(variable));
    }

    public QRent(Path<? extends Rent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRent(PathMetadata metadata) {
        super(Rent.class, metadata);
    }

}

