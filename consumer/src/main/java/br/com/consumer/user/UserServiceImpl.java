package br.com.consumer.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String save(UserPostgres usuario)  {
        Boolean usuarioExist = userRepository.findByName(usuario.getName()).isPresent();
        if (!usuarioExist) {
            userRepository.save(usuario);
            return "Salvo com sucesso";
        } else {
            return "Ja ha um usuario cadastrado com o nome " + usuario.getName();
        }
    }

    @Override
    public UserPostgres findById(Long id) {
        UserPostgres usuario = userRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException());
        return usuario;
    }

    @Override
    public List<UserPostgres> findAll() {
        return userRepository.findAll();
    }
}
