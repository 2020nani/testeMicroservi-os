package br.com.consumer.user;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class UserPostgres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;

    private Boolean admin;

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Boolean getAdmin() {
        return admin;
    }

    @Deprecated
    public UserPostgres() {
    }

    public UserPostgres(String name, String email, String cpf, Boolean admin) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.admin = admin;
    }
}
