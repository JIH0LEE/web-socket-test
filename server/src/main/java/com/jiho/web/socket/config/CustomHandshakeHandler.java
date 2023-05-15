package com.jiho.web.socket.config;

import com.jiho.web.socket.repository.SessionRepository;
import java.security.Principal;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;


@RequiredArgsConstructor
@Service
public class CustomHandshakeHandler extends DefaultHandshakeHandler {

    private final SessionRepository sessionRepository;

    @Override
    public Principal determineUser(ServerHttpRequest request,
        WebSocketHandler wsHandler,
        Map<String, Object> attributes) {
        String sessionId = UUID.randomUUID().toString();
        sessionRepository.activateSession(sessionId);
        return new StompPrincipal(sessionId);
    }

}
