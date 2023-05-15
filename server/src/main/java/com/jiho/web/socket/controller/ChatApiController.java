package com.jiho.web.socket.controller;

import com.jiho.web.socket.domain.ChatRoom;
import com.jiho.web.socket.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chat")
@RequiredArgsConstructor
public class ChatApiController {

    private final ChatService chatService;

    @PostMapping
    public ChatRoom makeNewChatRoom() {
        return chatService.makeNewChatRoom();
    }

}
