package br.com.orquestrador.application.ListenerKafka;

import br.com.orquestrador.application.ListenerKafka.dto.UserDto;
import br.com.orquestrador.user.User;
import br.com.orquestrador.user.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private Gson serializer;

    @Autowired
    private UserService userService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    public KafkaConsumer(Gson serializer) {
        this.serializer = serializer;
    }

    @KafkaListener(topics = "${user.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void receive( @Payload String message)  {
        logger.info("message received: {}", message);
        UserDto usuarioDto = serializer.fromJson(message, UserDto.class);
        jmsTemplate.convertAndSend("queue.sample", message);
        User usuario = usuarioDto.converte();
        logger.info(usuario.toString());
        String messageFinal = userService.save(usuario);
        logger.info(messageFinal);
    }
}
