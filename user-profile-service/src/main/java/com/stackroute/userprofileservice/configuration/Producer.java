package com.stackroute.userprofileservice.configuration;


import com.stackroute.userprofileservice.payload.EmailDto;
import com.stackroute.userprofileservice.payload.UserDto;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final static String ROUTING_KEY_FOR_SAVE_USER = "user_routing_to_save_user";
    private final static String ROUTING_KEY_FOR_UPDATE_USER = "user_routing_to_update_user";
    private final static String ROUTING_KEY_FOR_DELETE_USER = "user_routing_to_delete_user";
    private final static String ROUTING_KEY_FOR_EMAIL_SUCCESS = "user_routing_to_email_success";

    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public void sendMessageToRabbitMqToSaveUser(UserDto userDTO) {
        rabbitTemplate.convertAndSend(directExchange.getName(), ROUTING_KEY_FOR_SAVE_USER, userDTO);
    }

    public void sendMessageToRabbitMqToDeleteUser(String emailId) {
        rabbitTemplate.convertAndSend(directExchange.getName(), ROUTING_KEY_FOR_DELETE_USER, emailId);
    }

    public void sendMessageToRabbitMqToUpdateUser(UserDto userDTO) {
        rabbitTemplate.convertAndSend(directExchange.getName(), ROUTING_KEY_FOR_UPDATE_USER, userDTO);
    }

    public void sendMessageToRabbitMqForEmailSuccess(EmailDto emailDTO) {
        rabbitTemplate.convertAndSend(directExchange.getName(), ROUTING_KEY_FOR_EMAIL_SUCCESS, emailDTO);
    }
}