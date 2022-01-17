package br.com.orquestrador.user;

import br.com.orquestrador.infrastructure.repository.elasticsearch.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String save(User usuario)  {
        User usuarioExist = userRepository.findByName(usuario.getName())
                .orElse(null);
        if (usuarioExist == null) {
            userRepository.save(usuario);
            return "Salvo com sucesso";
        } else {
            return "Ja ha um usuario cadastrado com o nome " + usuario.getName();
        }
    }

    @Override
    public User findByName(String name) {
        User usuario = userRepository.findByName(name).
                orElseThrow(() -> new IllegalArgumentException());
        return usuario;
    }
}
