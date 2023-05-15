package com.jiho.web.socket.controller;


import com.jiho.web.socket.domain.Chat;
import com.jiho.web.socket.domain.ChatEntry;
import com.jiho.web.socket.domain.ChatRoom;
import com.jiho.web.socket.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@RequiredArgsConstructor
@Controller
public class ChatSocketController {

    //Client가 SEND할 수 있는 경로
    //stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    //"/pub/chat/enter"

    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달

    private final ChatService chatService;

    @MessageMapping(value = "/chat/enter")
    public void enter(ChatEntry chatEntry) {
        ChatRoom response = chatService.enter(chatEntry);
        template.convertAndSend("/sub/chat/room/" + chatEntry.getChatId(), response);
    }

    @MessageMapping(value = "/chat/message")
    public void message(Chat chat) {
        ChatRoom response = chatService.addChat(chat);
        template.convertAndSend("/sub/chat/room/" + chat.getChatId(), response);
    }

}
