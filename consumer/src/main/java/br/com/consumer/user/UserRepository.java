package br.com.consumer.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserPostgres, Long> {
    Optional<UserPostgres> findByName(String name);
}
