package net.raveTech.springboot.Config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.queue.json.name}")
    private String jsonQueue;

    @Value("${rabbitmq.exchange.name}")
    private  String exchangel;

    @Value("${rabbitmq.routing.key}")
    private String routing_key;

    @Value("${rabbitmq.routing.json.key}")
    private String json_routing_key;
    //springbean for rabbit mq queue
    @Bean
    public Queue queue(){
        return  new Queue(queue);
    }

    //Spring bean for queue to store json messages
    @Bean
    public Queue jsonQueue(){
        return  new Queue(jsonQueue);
    }

    //spring bean for routing and exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchangel);
    }

    //Binding bewtween queue and exchange using routing key
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange())
                .with(routing_key);
    }

    //Binding bewtween JSON queue and exchange using routing key
    @Bean
    public  Binding jsonBinding(){
        return  BindingBuilder.bind(jsonQueue())
                .to(exchange())
                .with(json_routing_key);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return  rabbitTemplate;
    }

    //connection factory,rabbittemplate,rabbitAdmin
    //this above bean will automatically configured by springbean
}
