package br.com.orquestrador.infrastructure.repository;


import br.com.orquestrador.user.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

    @Repository
    public interface UserRepository extends ElasticsearchRepository<User, String> {
        Optional<User> findByName(String name);

    }

