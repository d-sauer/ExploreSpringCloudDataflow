package org.ds.dataflow.sample.filecreationsenderkafka;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileDetailSenderTest {

    @Autowired
    private MessageCollector messageCollector;

    @Autowired
    private Source source;

    @Test
    @DisplayName("Send event")
    void sendEvent() throws InterruptedException {
        Message message = this.messageCollector.forChannel(this.source.output()).poll(1, TimeUnit.SECONDS);
        String fileDetailJSON = message.getPayload().toString();
        assertTrue(fileDetailJSON.contains("name"));
        assertTrue(fileDetailJSON.contains("size"));
    }
}