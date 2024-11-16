package in.er.annamalai.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {
    public String processMessage(String message) {
        // Simple logic for responses
        if (message.contains("hello")) {
            return "Hi! How can I help you today?";
        } else if (message.contains("bye")) {
            return "Goodbye!";
        }
        return "I'm not sure how to respond to that.";
    }

    public String getResponse(String userMessage) {
        if (userMessage.contains("help") || userMessage.contains("agent")) {
            return "I will connect you to a live agent shortly.";
        } else {
            return "I'm here to help!";
        }
    }    
}
