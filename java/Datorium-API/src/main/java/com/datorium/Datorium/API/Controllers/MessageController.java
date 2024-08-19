package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTOs.Message;
import com.datorium.Datorium.API.Services.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;
    public MessageController(){
        messageService = new MessageService();
    }
    @PostMapping("/add") // localhost:8080/message/add
    public String add(@RequestBody Message message){
        return messageService.add(message);
    }
}
    //. Create MessageController.java
//		2. Create MessageService.java
//		3. Create Message.java
//		4. In message controller, create an endpoint, which uses both MessageService and Message.java


