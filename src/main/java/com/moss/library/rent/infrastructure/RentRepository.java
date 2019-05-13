package com.moss.library.rent.infrastructure;

import com.moss.library.rent.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findAllByUserId(Long bookId);

}
