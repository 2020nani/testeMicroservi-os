package br.com.pontedeacesso.application.controler;

import br.com.pontedeacesso.application.dto.UserDto;
import br.com.pontedeacesso.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping()
    public String cadastrarUsuario(@RequestBody UserDto usuario) {
        logger.info(usuario.toString());
        service.saveUser(usuario.toString());
        return usuario.toString();
    }
}
