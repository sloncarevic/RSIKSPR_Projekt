package hr.fer.rsikspr.projekt.service;

import hr.fer.rsikspr.projekt.model.Chat;
import hr.fer.rsikspr.projekt.model.Message;
import hr.fer.rsikspr.projekt.repository.ChatRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public List<Chat> getChats() {
        return chatRepository.findAll();
    }

    public Optional<Chat> getChatById(Long id) {
        return chatRepository.findById(id);
    }

    public List<Chat> getChatsByClientID (String clientID) {
        return chatRepository.findByClientID(clientID);
    }

    public Chat getOrCreateChat(String clientID) {
        Optional<Chat> existingChat = chatRepository.findFirstByClientIDOrderByStartTimeDesc(clientID);
        if (existingChat.isPresent() && existingChat.get().getEndTime() == null) {
            return existingChat.get();
        } else {
            Chat newChat = new Chat();
            newChat.setClientID(clientID);
            newChat.setStartTime(LocalDateTime.now());

            return chatRepository.save(newChat);
        }
    }

    public Chat closeChat(String clientID) {
        Optional<Chat> chat = chatRepository.findFirstByClientIDOrderByStartTimeDesc(clientID);
        if (chat.isPresent()) {
            chat.get().setEndTime(LocalDateTime.now());
            chatRepository.save(chat.get());
            return chat.get();
        } else {
            throw new EntityNotFoundException("Chat not found with clientID: " + clientID);
        }
    }

    public void addMessage(Long chatID, Message message) {
        Optional<Chat> chat = getChatById(chatID);
        if (chat.isPresent()) {
            chat.get().addMessage(message);
            chatRepository.save(chat.get());
        }
    }
}
