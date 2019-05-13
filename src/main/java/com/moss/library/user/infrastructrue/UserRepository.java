package com.moss.library.user.infrastructrue;

import com.moss.library.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 유저 Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

}
