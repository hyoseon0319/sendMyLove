package com.sendmylove.demo.controller;

import com.sendmylove.demo.service.*;
import model.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

//    @Autowired
//    private LoginController userService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    	System.out.println("=============");
    	System.out.println(chatMessage.getSender());
    	
        if (chatMessage.getType() == ChatMessage.MessageType.CHAT) {
            Message message = new Message();
            message.setContent(chatMessage.getContent());
            message.setUser_name(chatMessage.getSender());
            message.setUser_id(chatMessage.getSender_id());
            messageService.saveMessage(message);
        }
        return chatMessage;
    }

//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(@Payload ChatMessage chatMessage,
//                               SimpMessageHeaderAccessor headerAccessor) {
//        // Add username in web socket session
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        headerAccessor.getSessionAttributes().put("user_id", chatMessage.getSender_id());
//
//        userService.updateUserActiveState(chatMessage.getSender_id(), 1);
//
//        return chatMessage;
//    }

}
