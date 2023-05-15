package com.jiho.web.socket.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class SessionRepository {

    private Map<String, Boolean> sessionMap = new HashMap<>();

    public void activateSession(String sessionId) {
        sessionMap.put(sessionId, true);
    }

    public void deactivateSession(String sessionId) {
        sessionMap.put(sessionId, false);
    }

}
