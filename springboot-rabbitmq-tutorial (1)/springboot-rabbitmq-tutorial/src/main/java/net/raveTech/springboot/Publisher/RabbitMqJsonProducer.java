package net.raveTech.springboot.Publisher;

import net.raveTech.springboot.Consumers.RabbitMQConsumer;
import net.raveTech.springboot.DTO.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonProducer {

    private static  final Logger logger= LoggerFactory.getLogger(RabbitMqJsonProducer.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key}")
    private String routingJSonKey;

    private RabbitTemplate rabbitTemplate;
    public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public  void sendJsonMessage(User user){
        logger.info(String.format("Json message sent -> %s",user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJSonKey,user);
    }

}
