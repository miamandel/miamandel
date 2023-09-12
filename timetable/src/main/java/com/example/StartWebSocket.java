package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.EncodeException;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

@ServerEndpoint("/start-websocket/{name}")
@ApplicationScoped
public class StartWebSocket {

    HashMap<String, Session> sessions = new HashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam("name") String name) {
        System.out.println("onOpen> " + name);
        sessions.put(name, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("name") String name) {
        System.out.println("onClose> " + name);
        sessions.remove(name, session);
    }

    @OnError
    public void onError(Session session, @PathParam("name") String name, Throwable throwable) {
        System.out.println("onError> " + name + ": " + throwable);

    }

    @OnMessage
    public void onMessage(String message, @PathParam("name") String name) {
        System.out.println("onMessage> " + name + ": " + message);
        broadcast(message);
    }

    public void broadcast(String message) {
        // Nachricht schicken
        for (Session session : sessions.values()) {
            session.getAsyncRemote().sendText(message);
        }

    }

}
