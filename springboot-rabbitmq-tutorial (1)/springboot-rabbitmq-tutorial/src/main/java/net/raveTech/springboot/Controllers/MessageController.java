package net.raveTech.springboot.Controllers;

import net.raveTech.springboot.Publisher.RabbitMQProducers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {




    private RabbitMQProducers producers;


    public MessageController(RabbitMQProducers producers) {
        this.producers = producers;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
            producers.sendMessage(message);
            return ResponseEntity.ok("Message sent to rabbitMq .....");
    }
}
