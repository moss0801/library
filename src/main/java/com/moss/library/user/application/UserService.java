package com.moss.library.user.application;

import com.moss.library.rent.domain.Rent;
import com.moss.library.rent.infrastructure.RentRepository;
import com.moss.library.user.domain.User;
import com.moss.library.user.infrastructrue.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository repository;
    private RentRepository rentRepository;

    public UserService(UserRepository repository, RentRepository rentRepository) {
        this.repository = repository;
        this.rentRepository = rentRepository;
    }

    /**
     * 책 저장
     */
    @Transactional
    public User save(User user) {
        repository.findByUserName(user.getUserName())
                .ifPresent(u -> {
                    throw new RuntimeException("User Exists, userName=" + user.getUserName());
                });
        repository.saveAndFlush(user);
        return user;
    }

    /**
     * 책 조회
     */
    public Optional<User> findById(Long userId) {
        return repository.findById(userId);
    }

    /**
     * 책 삭제
     */
    @Transactional
    public User delete(User user) {
        // 존재 체크
        Optional<User> optionalUser = repository.findById(user.getUserId());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User Not Exists");
        }

        // 대여 목록 확인
        List<Rent> rentList = rentRepository.findAllByUserId(user.getUserId());
        if (!rentList.isEmpty()) {
            throw new RuntimeException("rent exists");
        }

        // 삭제
        repository.delete(user);
        return user;
    }
}
