package com.jiho.web.socket.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class ChatRoom {

    private String chatId;

    private Map<String, Boolean> sessionList;

    private List<Chat> chatList = new ArrayList<>();

    public ChatRoom(String chatId) {
        this.chatId = chatId;
        this.sessionList = new HashMap<>();
        this.chatList = new ArrayList<>();
    }

}
