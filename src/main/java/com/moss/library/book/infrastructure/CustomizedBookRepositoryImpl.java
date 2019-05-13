package com.moss.library.book.infrastructure;

import com.moss.library.rent.domain.QRent;
import com.moss.library.user.domain.QUser;
import com.moss.library.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class CustomizedBookRepositoryImpl implements CustomizedBookRepository {
    private final JPAQueryFactory queryFactory;

    public CustomizedBookRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public User findUser(Long bookId) {
        return queryFactory.select(QUser.user)
                .from(QRent.rent)
                .join(QUser.user).on(QRent.rent.userId.eq(QUser.user.userId))
                .where(QRent.rent.bookId.eq(bookId))
                .fetchFirst();
    }
}
