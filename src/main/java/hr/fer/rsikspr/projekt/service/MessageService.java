package hr.fer.rsikspr.projekt.service;

import hr.fer.rsikspr.projekt.model.Message;
import hr.fer.rsikspr.projekt.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final ChatService chatService;
    private final ChatbotService chatbotService;

    public Message save(Message message) {
        message.setTime(LocalDateTime.now());
        message.setChatID(chatService.getOrCreateChat(message.getSender()).getChatID());
        messageRepository.save(message);
        chatService.getOrCreateChat(message.getSender()).addMessage(message);
        return message;
    }

    public Message create(Message message) {

        Message response = new Message();
        response.setContent(chatbotService.generateResponse(message.getContent()));
        response.setRecipient(message.getSender());
        response.setSender("chatbot");
        response.setChatID(message.getChatID());
        response.setTime(LocalDateTime.now());
        messageRepository.save(response);

        chatService.addMessage(response.getChatID(), response);

        return response;
    }



}
