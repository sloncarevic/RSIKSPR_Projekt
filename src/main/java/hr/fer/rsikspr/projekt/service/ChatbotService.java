package hr.fer.rsikspr.projekt.service;

import hr.fer.rsikspr.projekt.model.Message;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String generateResponse(String messageContent) {
        String response = "I received: " + messageContent;

        return response;
    }
}
