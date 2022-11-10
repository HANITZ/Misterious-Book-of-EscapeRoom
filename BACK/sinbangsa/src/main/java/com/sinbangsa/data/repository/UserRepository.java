package com.sinbangsa.data.repository;

import com.sinbangsa.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNickname(String nickname);

    User findById(long userId);
    boolean existsByNickname(String nickname);

}