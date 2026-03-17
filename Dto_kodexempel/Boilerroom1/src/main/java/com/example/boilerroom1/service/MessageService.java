package com.example.boilerroom1.service ;
import com . example . boilerroom1 . entity . Message ;
import com . example . boilerroom1 . repository . MessageRepository ;
import org . springframework . stereotype . Service ;
import java . util . List ;
@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message create(String text, int number) {
        Message message = new Message(text, number);
        return repository.save(message);
    }

    public List<Message> getAll() {
        return repository.findAll();
    }

    //Expand
    public Message getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found"));
    }
}