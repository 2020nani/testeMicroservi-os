package br.com.consumer.application.controller;


import br.com.consumer.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        redisRepository.deleteItem(usuarioRedis.getId());
        logger.info("Salvando usuario " + usuarioRedis.getName());
        UserPostgres usuario = usuarioRedis.converte();
        String message = userService.save(usuario);
        logger.info(message);
        return message;
    }

    @DeleteMapping("user/{id}")
    public void deletaUsuarioRedis(@PathVariable String id){
        System.out.println(id);
        redisRepository.deleteItem(id);
    }

}
