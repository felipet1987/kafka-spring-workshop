package cl.talavera.producer.controller;


import cl.talavera.producer.Producer;
import cl.talavera.producer.domain.DefaultEvent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController(value = "event")
public class EventController {

    private final Producer publisher;

    @PostMapping("/send")
    public String send(@RequestBody DefaultEvent event){

        publisher.send(event);

        return "Enviado";
    }
}
