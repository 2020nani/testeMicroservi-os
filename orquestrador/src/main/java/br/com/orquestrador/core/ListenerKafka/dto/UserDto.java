package br.com.orquestrador.core.ListenerKafka.dto;

import br.com.orquestrador.user.User;
import com.google.gson.Gson;

import java.util.UUID;

public class UserDto {

    private String name;
    private String email;
    private String cpf;

    public UserDto(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public UserDto() {
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public User converte() {
      return User.builder()
              .id(UUID.randomUUID().toString())
              .name(name)
              .cpf(cpf)
              .email(email)
              .build();
    }
}
