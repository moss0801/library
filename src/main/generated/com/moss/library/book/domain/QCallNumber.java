package com.moss.library.book.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCallNumber is a Querydsl query type for CallNumber
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCallNumber extends BeanPath<CallNumber> {

    private static final long serialVersionUID = 1796531102L;

    public static final QCallNumber callNumber = new QCallNumber("callNumber");

    public final StringPath additionalNumber = createString("additionalNumber");

    public final StringPath bookNumber = createString("bookNumber");

    public final StringPath className = createString("className");

    public final StringPath locationSymbol = createString("locationSymbol");

    public QCallNumber(String variable) {
        super(CallNumber.class, forVariable(variable));
    }

    public QCallNumber(Path<? extends CallNumber> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCallNumber(PathMetadata metadata) {
        super(CallNumber.class, metadata);
    }

}

