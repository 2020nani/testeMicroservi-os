package br.com.pontedeacesso.user;

import br.com.pontedeacesso.application.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class UserServiceImpl implements UserService{

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${order.topic}")
    private String topic;

    @Override
    public String saveUser(String message) {
        kafkaTemplate.send(topic,message).addCallback(
                success -> logger.info("Mensagem enviada " + success.getProducerRecord().value()),
                failure -> logger.info("Erro ao enviar mensagem " + failure.getMessage())
        );
        return "ok";
    }
}
