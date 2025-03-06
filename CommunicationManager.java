import java.util.*;

class Message {
    private final String content;
    private final String sender;
    private final String recipient;

    public Message(String content, String sender, String recipient) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String formatMessage() {
        return sender + " -> " + recipient + ": " + content;
    }
}

class MessagingService {
    private final Map<String, List<Message>> inbox = new HashMap<>();

    public void sendMessage(String content, String sender, String recipient) {
        Message message = new Message(content, sender, recipient);
        inbox.computeIfAbsent(recipient, k -> new ArrayList<>()).add(message);
    }

    public List<Message> getMessagesForRecipient(String recipient) {
        return inbox.getOrDefault(recipient, Collections.emptyList());
    }

    public void printAllMessages() {
        inbox.forEach((recipient, messages) -> messages.forEach(msg -> System.out.println(msg.formatMessage())));
    }
}

public class CommunicationManager {
    public static void main(String[] args) {
        MessagingService messagingService = new MessagingService();

        messagingService.sendMessage("Hello, tenant!", "Property Manager", "Tenant A");
        messagingService.sendMessage("Rent due next week.", "Property Owner", "Tenant A");
        messagingService.sendMessage("Maintenance request received.", "Tenant A", "Property Manager");

        messagingService.getMessagesForRecipient("Tenant A")
                .forEach(msg -> System.out.println(msg.formatMessage()));

        messagingService.printAllMessages();
    }
}
