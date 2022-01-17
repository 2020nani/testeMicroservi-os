package br.com.consumer.user;

import java.util.List;

public interface UserService {

    public String save(UserPostgres usuario);

    public UserPostgres findById(Long id);

    List<UserPostgres> findAll();
}
