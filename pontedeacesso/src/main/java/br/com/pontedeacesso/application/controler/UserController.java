package br.com.pontedeacesso.application.controler;

import br.com.pontedeacesso.application.dto.UserDto;
import br.com.pontedeacesso.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping()
    public String cadastrarUsuario(@RequestBody UserDto usuario) {
        logger.info(usuario.toString());
        service.saveUser(usuario.toString());
        return usuario.toString();
    }
}
