package br.com.consumer.user;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class UserDto {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @CPF
    @NotBlank
    private String cpf;

    private Boolean admin;

    public UserDto(String name, String email, String cpf, Boolean admin) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.admin = admin;
    }

    public UserDto() {
    }


    public UserPostgres converte() {
      return new UserPostgres(name, email, cpf, admin);
    }

    public UserRedis converteRedis() {
        return UserRedis.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .cpf(cpf)
                .email(email)
                .build();
    }
}
