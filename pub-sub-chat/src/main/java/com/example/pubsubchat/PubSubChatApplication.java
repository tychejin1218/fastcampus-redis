package com.example.pubsubchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// cd build/libs
// java -Dserver.port=9090 -jar pub-sub-chat-0.0.1-SNAPSHOT.jar
// java -Dserver.port=9091 -jar pub-sub-chat-0.0.1-SNAPSHOT.jar
// java -Dserver.port=9092 -jar pub-sub-chat-0.0.1-SNAPSHOT.jar
// java -Dserver.port=9093 -jar pub-sub-chat-0.0.1-SNAPSHOT.jar
@SpringBootApplication
public class PubSubChatApplication implements CommandLineRunner {

    @Autowired
    private ChatService chatService;

    public static void main(String[] args) {
        SpringApplication.run(PubSubChatApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started..");

        chatService.enterCharRoom("chat1");
    }
}