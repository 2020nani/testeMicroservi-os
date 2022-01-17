package br.com.consumer.Jms;

import br.com.consumer.user.UserDto;
import br.com.consumer.user.UserRedis;
import br.com.consumer.user.UserRedisRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jms.annotation.JmsListener;

@Component
public class JmsServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(JmsServiceImpl.class);

    @Autowired
    private Gson serializer;

    @Autowired
    private UserRedisRepository redisRepository;


    @JmsListener(destination = "queue.sample")
    //@SendTo("outbound.queue.sample")
    public void onReceiverQueue(String message) {
        logger.info("message received: {}", message);
        UserDto usuarioDto = serializer.fromJson(message, UserDto.class);
        UserRedis usuario = usuarioDto.converteRedis();
        logger.info(usuario.toString());
        redisRepository.addUser(usuario);

    }

}
