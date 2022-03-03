package br.com.consumer.application.controller;


import br.com.consumer.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    private UserRedisRepository redisRepository;

    public UserController(UserService userService, UserRedisRepository redisRepository) {
        this.userService = userService;
        this.redisRepository = redisRepository;
    }

    @GetMapping("redis/user")
    public List<Object> buscaUsuarioRedis(){

        return redisRepository.getAllUsers();
    }

    @PostMapping("user")
    public String criaUsuario(@RequestBody UserRedis usuarioRedis){
        UserRedis userRedisExiste = redisRepository.getUser(usuarioRedis.getId());
        if(userRedisExiste == null) {
            return "Nao ha este usuario no banco de memoria";
        }
        logger.info("Salvando usuario " + usuarioRedis.getName());
        UserPostgres usuario = usuarioRedis.converte();
        String message = userService.save(usuario);
        logger.info(message);
        if(message == "Salvo com sucesso") {
            redisRepository.deleteItem(usuarioRedis.getId());
        }
        return message;
    }

    @DeleteMapping("user/{id}")
    public void deletaUsuarioRedis(@PathVariable String id){
        redisRepository.deleteItem(id);
    }

}
