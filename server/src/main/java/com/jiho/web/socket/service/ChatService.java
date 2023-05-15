package com.jiho.web.socket.service;

import com.jiho.web.socket.domain.Chat;
import com.jiho.web.socket.domain.ChatEntry;
import com.jiho.web.socket.domain.ChatRoom;
import com.jiho.web.socket.util.StringGenerator;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {

    private Map<String, ChatRoom> chatData = new HashMap<>();

    public ChatRoom enter(ChatEntry chatEntry) {
        chatData.get(chatEntry.getChatId()).getSessionList().put(chatEntry.getSessionId(), true);
        return findChat(chatEntry.getChatId());
    }

    public ChatRoom findChat(String chatRoomId) {
        return chatData.get(chatRoomId);
    }

    public ChatRoom addChat(Chat chat) {
        chatData.get(chat.getChatId()).getChatList().add(chat);
        return findChat(chat.getChatId());
    }

    public ChatRoom makeNewChatRoom() {
        String newCharRoomId = StringGenerator.generateChatRoom();
        ChatRoom newChatRoom = new ChatRoom(newCharRoomId);
        chatData.put(newCharRoomId, newChatRoom);
        return newChatRoom;
    }

}
