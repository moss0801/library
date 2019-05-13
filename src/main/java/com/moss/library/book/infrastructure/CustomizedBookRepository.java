package com.moss.library.book.infrastructure;

import com.moss.library.user.domain.User;

import java.util.List;

public interface CustomizedBookRepository {

    /**
     * 대출자 찾기
     */
    User findUser(Long bookId);
}
