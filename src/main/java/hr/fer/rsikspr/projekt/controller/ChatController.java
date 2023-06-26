package hr.fer.rsikspr.projekt.controller;

import hr.fer.rsikspr.projekt.model.Chat;
import hr.fer.rsikspr.projekt.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    @GetMapping
    public List<Chat> getChats() {
        return chatService.getChats();
    }
    @GetMapping("/{clientID}")
    public List<Chat> getChatsByClientID(@PathVariable String clientID){
        return chatService.getChatsByClientID(clientID);
    }

    @GetMapping("/{clientID}/close")
    public ResponseEntity<Void> closeChat(@PathVariable String clientID) {
        chatService.closeChat(clientID);
        return ResponseEntity.ok().build();
    }
}
