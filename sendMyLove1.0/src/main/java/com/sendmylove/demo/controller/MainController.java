package com.sendmylove.demo.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sendmylove.demo.service.MessageService;
import model.domain.Board;
import model.domain.Message;
import model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {


    @Autowired
    private MessageService messageService;

    @Autowired
    private ServletContext servletContext;
 

    @RequestMapping(value = "/getLastMessages", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String getLastMessages(HttpServletRequest request, HttpServletResponse response) {

        // Get User list and last 3 messages
        List<Message> messageslist = messageService.getLastMessages();
        Gson gsonBuilder = new GsonBuilder().create();
        String messagelistJson = gsonBuilder.toJson(messageslist);
        return messagelistJson;

    }
    
    @RequestMapping(value = "/getAllMessages", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String getAllMessages(HttpServletRequest request, HttpServletResponse response) {

        // Get User list and last 3 messages
        List<Message> messageslist = messageService.getAllMessages();
        Gson gsonBuilder = new GsonBuilder().create();
        String messagelistJson = gsonBuilder.toJson(messageslist);
        return messagelistJson;

    }

}
