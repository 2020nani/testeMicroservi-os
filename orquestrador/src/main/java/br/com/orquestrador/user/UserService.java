package br.com.orquestrador.user;

public interface UserService {

    public String save(User usuario);

    public User findByName(String name);
}
