package com.example . boilerroom1 . controller ;
import com . example . boilerroom1 . entity . Message ;
import com . example . boilerroom1 . service . MessageService ;
import org . springframework . web . bind . annotation .*;
import java . util . List ;

@RestController
@RequestMapping ( "/messages" )
public class MessageController {
    private final MessageService service ;
    public MessageController ( MessageService service ) {
        this . service = service ;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        return service.create(message.getText(), message.getNumber());
    }

    @PostMapping("/hard")
    public Message createHard() {
        return service.create("Hard coded string!", 42);
    }

    @GetMapping
    public List < Message > getAll () {
        return service . getAll () ;
    }

    //Expand
    @GetMapping("/{id}/number")
    public int getNumber(@PathVariable Long id) {
        Message message = service.getById(id);
        return message.getNumber();
    }
    @GetMapping("/{id}/string")
    public String getText(@PathVariable Long id) {
        Message message = service.getById(id);
        return message.getText();
    }
}


