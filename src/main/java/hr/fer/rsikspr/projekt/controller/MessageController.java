package hr.fer.rsikspr.projekt.controller;


import hr.fer.rsikspr.projekt.model.Message;
import hr.fer.rsikspr.projekt.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping()
    public Message create(@RequestBody Message message) {
        message = messageService.save(message);

        Message response = messageService.create(message);

        return response;
    }
}
