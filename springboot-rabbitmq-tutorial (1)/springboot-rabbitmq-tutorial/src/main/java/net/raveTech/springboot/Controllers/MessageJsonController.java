package net.raveTech.springboot.Controllers;

import net.raveTech.springboot.DTO.User;
import net.raveTech.springboot.Publisher.RabbitMqJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMqJsonProducer rabbitMqJsonProducer;


    public MessageJsonController(RabbitMqJsonProducer rabbitMqJsonProducer) {
        this.rabbitMqJsonProducer = rabbitMqJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessege(@RequestBody User user){
        rabbitMqJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to rabbitMq");
    }
}
