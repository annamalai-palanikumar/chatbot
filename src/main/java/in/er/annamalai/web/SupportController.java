package in.er.annamalai.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import in.er.annamalai.model.Message;

@Controller
public class SupportController {

    private final SimpMessagingTemplate messagingTemplate;

    public SupportController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Page for customers to contact customer service
    @GetMapping
    public String supportPage() {
        return "support";
    }

    // Page for customer service representatives to respond
    @GetMapping("/live")
    public String liveSupportPage() {
        return "live";
    }

    // Method to handle messages from the customer (send to the customer service
    // queue)
    @MessageMapping("/sendMessage")
    @SendTo("/topic/customer") // This ensures all customers and customer service can see the message
    public Message sendMessage(Message message) {
        // Return the message to the topic so both sides can see it
        return message;
    }

    // Method to handle customer service responses (send to the specific customer
    // queue)
    @MessageMapping("/sendResponse")
    public void sendResponse(Message message) {
        // Here, we're assuming we have some mechanism to identify the customer ID
        String customerQueue = "/queue/" + message.getTo(); // You can customize this with customer-specific IDs
        messagingTemplate.convertAndSend(customerQueue, message); // Send message to the customer's queue
    }
}
