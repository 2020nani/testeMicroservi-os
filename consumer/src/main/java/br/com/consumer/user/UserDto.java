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

    public UserDto(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public UserDto() {
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
